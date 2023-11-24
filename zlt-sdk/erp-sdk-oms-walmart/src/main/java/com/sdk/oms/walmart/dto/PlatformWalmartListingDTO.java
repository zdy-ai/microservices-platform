package com.sdk.oms.walmart.dto;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.common.business.dto.CleanBaseDTO;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.PlatformDictEnum;
import com.sdk.oms.walmart.dto.walmart.item.GroupingAttributesBean;
import com.sdk.oms.walmart.dto.walmart.item.ItemResponseBean;
import com.sdk.oms.walmart.dto.walmart.item.VariantGroupInfoBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlatformWalmartListingDTO extends CleanBaseDTO {
    private ItemResponseBean itemResponseBean;

    /**
     * 初始化
     */
    public PlatformWalmartListingDTO(ItemResponseBean itemResponseBean, JobTaskDTO dto) {
        this.itemResponseBean = itemResponseBean;
        this.setIsClean(0);
        this.setPlatform(PlatformDictEnum.WALMART.getCode());
        this.setUniqueId(itemResponseBean.getWpid());
        this.setDownloadTime(LocalDateTime.now(ZoneId.systemDefault()).toString());
        this.setLastPushTime(dto.getNextTime().toString());
    }

    /**
     * 转换目标实体:PlatformProductDTO
     */
    public static PlatformProductDTO convertDTO(PlatformWalmartListingDTO dto) {
        // 原商品信息
        return initPlatformProductDTO(dto);
    }

    /**
     * 根据PlatformWalmartListingDTO 转换 DTO
     */
    private static PlatformProductDTO initPlatformProductDTO(PlatformWalmartListingDTO dto) {
        ItemResponseBean itemResponseBean = dto.getItemResponseBean();
        //获取产品规格信息
        VariantGroupInfoBean variantGroupInfo = itemResponseBean.getVariantGroupInfo();
        String spec = "";
        if (ObjectUtil.isNotEmpty(variantGroupInfo)) {
            List<GroupingAttributesBean> groupingAttributes = variantGroupInfo.getGroupingAttributes();
            if (CollectionUtil.isNotEmpty(groupingAttributes)) {
                List<String> specList = groupingAttributes.stream().map(req -> req.getName() + "：" + req.getValue()).collect(Collectors.toList());
                spec = String.join(",", specList);
            }
        }
        PlatformProductDTO resultDto = new PlatformProductDTO();

        //平台sku
        resultDto.setPlatformSkuNo(itemResponseBean.getSku());
        // 平台产品名称
        resultDto.setPlatformProductName(itemResponseBean.getProductName());
        // 类型 platform 平台  warehouse 仓库
        resultDto.setPlatformType("platform");
        //产品规格
        resultDto.setProductSpec(spec);
        // 平台
        resultDto.setPlatform(dto.getPlatform());
        resultDto.setUniqueId(itemResponseBean.getWpid());
        return resultDto;
    }
}
