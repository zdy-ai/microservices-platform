package com.sdk.oms.shopee.dto;

import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.common.business.dto.CleanBaseDTO;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.PlatformDictEnum;
import com.sdk.oms.shopee.dto.product.response.Dimension;
import com.sdk.oms.shopee.dto.product.response.Image;
import com.sdk.oms.shopee.dto.product.response.ItemInfo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

/**
 * 平台亚马逊产品DTO
 *
 * @Author Cloud
 * @Date 2023/8/31 16:01
 **/
@Slf4j
@Setter
@Getter
@NoArgsConstructor
public class PlatformShopeeListingDTO extends CleanBaseDTO {
    //
    private ItemInfo itemInfo;

    /**
     * 初始化
     */
    public PlatformShopeeListingDTO(ItemInfo itemInfo, JobTaskDTO dto) {
        this.itemInfo = itemInfo;
        this.setIsClean(0);
        this.setPlatform(PlatformDictEnum.SHOPEE.getCode());
        this.setUniqueId(String.valueOf(itemInfo.getId()));
        this.setDownloadTime(LocalDateTime.now(ZoneId.systemDefault()).toString());
        this.setLastPushTime(dto.getNextTime().toString());
    }

    /**
     * 转换目标实体:PlatformProductDTO
     */
    public static PlatformProductDTO convertDTO(PlatformShopeeListingDTO dto) {
        // 原商品信息
        ItemInfo itemInfo = dto.getItemInfo();
        if (Objects.isNull(itemInfo)){
            return null;
        }
        Long updateTime = itemInfo.getUpdateTime();
        Instant instant = Instant.ofEpochMilli(updateTime);
        ZoneId zone = ZoneId.systemDefault();
        Image image = itemInfo.getImage();
        String imageUrl = null;
        if (Objects.nonNull(image)) {
            List<String> urls = image.getUrls();
            if (CollectionUtils.isNotEmpty(urls)) {
                imageUrl = urls.get(0).toString();
            }
        }
        PlatformProductDTO productDTO = new PlatformProductDTO()
                // 类型 platform 平台  warehouse 仓库
                .setPlatformType("platform")
                // 平台spu no
                .setPlatformProductNo(String.valueOf(itemInfo.getId()))
                // 平台sku no
                .setPlatformSkuNo(itemInfo.getItemSku())
                // 平台产品名称
                .setPlatformProductName(itemInfo.getName())
                //产品包装信息
                .setProductPacking(processDimension(itemInfo.getDimension()))
                //产品规格信息
                .setProductSpec(String.valueOf(itemInfo.getCategoryId()))
                // 产品图片 url
                .setProductImageUrl(imageUrl)
                //平台最后修改时间
                .setPlatformUpdateTime(LocalDateTime.ofInstant(instant, zone));
        productDTO.setPlatform(PlatformDictEnum.SHOPEE.getCode());
        return productDTO;
    }

    public static String processDimension(Dimension dimension) {
        if (Objects.isNull(dimension)) {
            return "";
        }
        return StrUtil.format("长度:{};宽度:{};高度:{};", dimension.getPackageLength(), dimension.getPackageWidth(), dimension.getPackageHeight());
    }

    @Override
    public String toString() {
        return "PlatformShopeeListingDTO{" +
                "itemInfo=" + itemInfo +
                '}';
    }
}
