package com.sdk.tms.track123.handler;

import com.common.business.annotation.BusinessType;
import com.common.business.annotation.PlatformCategoryType;
import com.common.business.annotation.PlatformType;
import com.common.business.dto.JobTaskDTO;
import com.common.business.enums.BusinessTypeEnum;
import com.common.business.enums.LogisticsPlatformEnum;
import com.common.business.enums.PlatformCategoryEnum;
import com.common.business.enums.PlatformDictEnum;
import com.common.business.handler.AbstractLogisticsTrackHandler;
import com.common.business.vo.PagingVO;
import com.erp.model.dmp.dto.CfgAppClientDTO;
import com.erp.model.dmp.entity.CfgAppClientEntity;
import com.erp.model.dmp.enums.AppClientEnum;
import com.erp.model.tms.dto.LogisticsBillDetailQueryDTO;
import com.erp.model.tms.entity.LogisticsBillDetailEntity;
import com.erp.model.tms.enums.LogisticTrackStatusEnum;
import com.erp.rpc.dmp.feign.DmpTaskFeign;
import com.erp.rpc.oms.feign.ShopInfoFeign;
import com.erp.rpc.tms.feign.LogisticsBillFeign;
import com.sdk.tms.track123.dto.PlatformTrackDTO;
import com.sdk.tms.track123.dto.PlatformTrack123TrackDTO;
import com.sdk.tms.track123.dto.PlatformTrackDetail;
import com.sdk.tms.track123.model.request.TrackRequest;
import com.sdk.tms.track123.model.response.*;
import com.sdk.tms.track123.service.TrackShipperService;
import io.seata.common.util.CollectionUtils;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 物流轨迹查询
 *
 * @author Jim
 * @since 2023-11-01
 **/
@Slf4j
@Component
@PlatformCategoryType(PlatformCategoryEnum.THIRD_SYSTEM)
@PlatformType(PlatformDictEnum.TRACK123)
@BusinessType(BusinessTypeEnum.GET_TRACK)
public class Track123LogisticsHandler extends AbstractLogisticsTrackHandler<PlatformTrack123TrackDTO, PlatformTrackDTO> {
    private static long pageSize = 100;
    @Resource
    private DmpTaskFeign dmpTaskFeign;
    @Resource
    private LogisticsBillFeign logisticsBillFeign;
    @Resource
    private TrackShipperService trackShipperService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PlatformTrack123TrackDTO> download(JobTaskDTO data) {
        CfgAppClientDTO.FindDTO findDTO = new CfgAppClientDTO.FindDTO();
        AppClientEnum appClientEnum = AppClientEnum.TRACK123_AUTHORIZE;
        findDTO.setBusinessType(appClientEnum.getBusinessType());
        findDTO.setDictPlatform(appClientEnum.getPlatform());
        findDTO.setPlatformType(appClientEnum.getPlatformType());
        CfgAppClientEntity cfgAppClient = null;
        try {
            cfgAppClient = dmpTaskFeign.getCfgAppClient(findDTO);
        } catch (Exception e) {
            log.error("erp-dmp服务获取Track123配置信息异常：{}", e.getMessage());
        }
        if (Objects.isNull(cfgAppClient)) {
            return Collections.emptyList();
        }
        long current = 1;
        //根据跟踪单获取跟踪轨迹
        LogisticsBillDetailQueryDTO query = LogisticsBillDetailQueryDTO.builder()
                .trackQueryMode(LogisticsPlatformEnum.TRACK123.getCode())
                .size(pageSize)
                .current(current)
                .registerStatus(1)
                .trackEnable(true)
                .build();
        List<ResponseData> responseDataList = new ArrayList<>();
        getTrackData(query, responseDataList, cfgAppClient);
        return responseDataList.stream().map(e -> new PlatformTrack123TrackDTO(e, data)).collect(Collectors.toList());
    }

    private void getTrackData(LogisticsBillDetailQueryDTO query, List<ResponseData> responseDataList, CfgAppClientEntity cfgAppClient) {
        PagingVO<LogisticsBillDetailEntity> page = logisticsBillFeign.getLogisticsBillDetails(query);
        if (Objects.isNull(page) || CollectionUtils.isEmpty(page.getList())) return;
        ResponseData responseData = processTrackData((List<LogisticsBillDetailEntity>) page.getList(), cfgAppClient);
        if (Objects.isNull(responseData)) return;
        //业务处理
        responseDataList.add(responseData);
        long pages = page.getTotalPage();
        if (pages > page.getCurrPage()) {
            //下一页
            query.setCurrent(page.getCurrPage() + 1);
            getTrackData(query, responseDataList, cfgAppClient);
        } else {
            //无数据
            log.info("========同步物流轨迹数据完成==========");
        }
    }

    private ResponseData processTrackData(List<LogisticsBillDetailEntity> records, CfgAppClientEntity cfgAppClient) {
        if (CollectionUtils.isNotEmpty(records)) {
            String token = cfgAppClient.getClientSecret();
            TrackRequest trackRequest = TrackRequest.builder()
                    .trackNos(records.stream().map(LogisticsBillDetailEntity::getTrackNo).collect(Collectors.toList()))
                    .cursor("")
                    .queryPageSize(100)
                    .build();
            try {
                TrackResponse track = trackShipperService.getTrack(token, trackRequest);
                return track.getData();
            } catch (Exception e) {
                log.error("获取Track123物流轨迹查询异常：{}", e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<PlatformTrackDTO> convert(List<PlatformTrack123TrackDTO> sourceDataList) {
        List<PlatformTrackDTO> resultList = new LinkedList<>();
        for (PlatformTrack123TrackDTO sourceDto : sourceDataList) {
            //将成功和失败的数据返回
            TrackInfo accepted = sourceDto.getAccepted();
            if (Objects.nonNull(accepted)) {
                if (CollectionUtils.isNotEmpty(accepted.getContent())) {
                    for (TrackDetail trackDetail : accepted.getContent()) {
                        PlatformTrackDTO acceptedToSaveDto = new PlatformTrackDTO();
                        acceptedToSaveDto.setTrackNo(trackDetail.getTrackNo());
                        LocalLogisticsInfo localLogisticsInfo = trackDetail.getLocalLogisticsInfo();
                        if (CollectionUtils.isNotEmpty(localLogisticsInfo.getTrackingDetails())) {
                            List<PlatformTrackDetail> details = new ArrayList<>();
                            for (TrackingDetail trackingDetail : localLogisticsInfo.getTrackingDetails()) {
                                PlatformTrackDetail detail = new PlatformTrackDetail();
                                detail.setTrackNo(trackDetail.getTrackNo());
                                detail.setStatus(convertTrackStatus(trackingDetail.getTransitSubStatus()));//转换类型
                                LocalDateTime eventTime = LocalDateTime.parse(trackingDetail.getEventTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                detail.setTrackTime(eventTime);
                                detail.setContent(trackingDetail.getEventDetail());
                                details.add(detail);
                            }
                            acceptedToSaveDto.setDetails(details);
                            resultList.add(acceptedToSaveDto);
                        } else if (StringUtils.isNotEmpty(trackDetail.getTransitStatus())) {
                            List<PlatformTrackDetail> details = new ArrayList<>();
                            PlatformTrackDetail detail = new PlatformTrackDetail();
                            detail.setTrackNo(trackDetail.getTrackNo());
                            detail.setStatus(convertTrackStatus(trackDetail.getTransitStatus()));//转换类型
                            LocalDateTime eventTime = LocalDateTime.parse(trackDetail.getCreateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            detail.setTrackTime(eventTime);
                            detail.setContent("暂无信息");
                            details.add(detail);
                            acceptedToSaveDto.setDetails(details);
                            resultList.add(acceptedToSaveDto);
                        }
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(sourceDto.getRejected())) {
                for (Rejected rejected : sourceDto.getRejected()) {
                    PlatformTrackDTO acceptedToSaveDto = new PlatformTrackDTO();
                    acceptedToSaveDto.setTrackNo(rejected.getTrackNo());
                    PlatformTrackDetail detail = new PlatformTrackDetail();
                    detail.setTrackNo(rejected.getTrackNo());
                    detail.setStatus(LogisticTrackStatusEnum.NOT_FIND.getCode());
                    detail.setContent(rejected.getError().getCode() + ":" + rejected.getError().getMsg());
                    detail.setTrackTime(LocalDateTime.now());
                    acceptedToSaveDto.setDetails(Collections.singletonList(detail));
                    resultList.add(acceptedToSaveDto);
                }
            }

        }
        return resultList;
    }


    /**
     * INIT	待查询	单号正在查询中，请等待
     * NO_RECORD	暂无信息	包裹无法查询到物流轨迹信息
     * INFO_RECEIVED	已接收	物流公司已经收到寄运订单，正在准备揽收包裹
     * IN_TRANSIT	运输中	包裹正在运输途中
     * WAITING_DELIVERY	派送中	包裹正在派送或已到达代收点等待收件人自提
     * DELIVERY_FAILED	投递失败	包裹尝试派送，但由于地址问题、收件人联系不上等原因导致派送失败
     * ABNORMAL	异常	包裹出现破损、退件、海关扣留等异常情况
     * DELIVERED	已成功	包裹投递成功
     * EXPIRED	已过期	包裹在最近的30天没有任何物流更新
     *
     * @param transitSubStatus
     * @return
     */
    private String convertTrackStatus(String transitSubStatus) {
        if (StringUtils.isBlank(transitSubStatus)) {//待查询
            return LogisticTrackStatusEnum.NOT_FIND.getCode();
        } else if (transitSubStatus.contains("INIT")) {//待查询  单号正在查询中，请等待
            return LogisticTrackStatusEnum.NOT_FIND.getCode();
        } else if (transitSubStatus.contains("NO_RECORD")) {//暂无信息 包裹无法查询到物流轨迹信息
            return LogisticTrackStatusEnum.NOT_FIND.getCode();
        } else if (transitSubStatus.contains("INFO_RECEIVED")) {//已接收 物流公司已经收到寄运订单，正在准备揽收包裹
            return LogisticTrackStatusEnum.WAIT_COLLECT.getCode();
        } else if (transitSubStatus.contains("IN_TRANSIT")) {//运输中 包裹正在运输途中
            return LogisticTrackStatusEnum.TRACK_ING.getCode();
        } else if (transitSubStatus.contains("WAITING_DELIVERY")) {//派送中 包裹正在派送或已到达代收点等待收件人自提
            return LogisticTrackStatusEnum.DELIVERY_ING.getCode();
        } else if (transitSubStatus.contains("DELIVERY_FAILED")) {//投递失败 包裹尝试派送，但由于地址问题、收件人联系不上等原因导致派送失败
            return LogisticTrackStatusEnum.DELIVERY_FAIL.getCode();
        } else if (transitSubStatus.contains("ABNORMAL")) {//异常 包裹出现破损、退件、海关扣留等异常情况
            return LogisticTrackStatusEnum.MAYBE_EXCEPTION.getCode();
        } else if (transitSubStatus.contains("DELIVERED")) {//已成功 包裹投递成功
            return LogisticTrackStatusEnum.SIGN.getCode();
        } else if (transitSubStatus.contains("EXPIRED")) {//已过期 包裹在最近的30天没有任何物流更新
            return LogisticTrackStatusEnum.TRANSPORT_LONG.getCode();
        }
        return LogisticTrackStatusEnum.NOT_FIND.getCode();
    }

    public static void main(String[] args) {
//        String json = "{\"shipmentInfo\":{\"shipmentId\":\"FBA17FKD1MPZ\",\"shipmentName\":\"FBA STA (10/07/2023 07:09)-CMH2\",\"shipFromAddress\":{\"name\":\"LC108092（Ling）\",\"addressLine1\":\"14939 Summit Drive\",\"city\":\"Eastvale\",\"stateOrProvinceCode\":\"CA\",\"countryCode\":\"US\",\"postalCode\":\"92880\"},\"destinationFulfillmentCenterId\":\"CMH2\",\"shipmentStatus\":\"RECEIVING\",\"labelPrepType\":\"SELLER_LABEL\",\"boxContentsSource\":\"INTERACTIVE\"},\"shopId\":\"1720261566995107842\",\"shopName\":\"亚马逊测试店铺美国\",\"platformUpdateTime\":1698995263691,\"downloadStatus\":0,\"downloadTime\":\"\",\"detailList\":[]}";
//        PlatformTrackDTO shipmentDTO = TrackDataConverter.INSTANCE.downloadDtoToSaveDto(JSONUtil.toBean(json, PlatformTrack123TrackDTO.class));
//        System.out.println(JSONUtil.toJsonStr(shipmentDTO));
    }

    @Override
    public String getTargetPlatform() {
        return PlatformDictEnum.TRACK123.getCode();
    }

    /**
     * 是否发送MQ
     * true=发送
     * false=不发送（有其他详情需要额外拉取）
     */
    public Boolean getIsSendMq() {
        return Boolean.TRUE;
    }
}
