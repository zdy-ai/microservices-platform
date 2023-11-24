package com.erp.sdk.oms.amz.spapi.dto;

import com.common.business.dto.CleanBaseDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.PlatformDictEnum;
import com.erp.sdk.oms.amz.spapi.model.catalogitems.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 平台亚马逊产品DTO
 *
 * @Author Cloud
 * @Date 2023/8/31 16:01
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlatformAmazonListingDTO extends CleanBaseDTO {

    private String itemName;

    private String itemDescription;

    private String listingId;

    private String sellerSku;

    private String price;

    private String quantity;

    private String openDate;

    private String imageUrl;

    private String itemIsMarketplace;

    private String productIdType;

    private String zshopShippingFee;

    private String itemNote;

    private String itemCondition;

    private String zshopCategory1;

    private String zshopBrowsePath;

    private String zshopStorefrontFeature;

    private String asin1;

    private String asin2;

    private String asin3;

    private String willShipInternationally;

    private String expeditedShipping;

    private String zshopBoldface;

    private String productId;

    private String bidForFeaturedPlacement;

    private String addDelete;

    private String pendingQuantity;

    private String fulfillmentChannel;

    private String merchantShippingGroup;

    /**
     * 店铺ID
     */
    private String shopId;

    /**
     * 平台最后修改时间(数据结束时间)
     */
    private LocalDateTime platformUpdateTime;

    /**
     * 产品规格信息
     */
    private String productSpec;

    /**
     * 产品包装信息
     */
    private String productPacking;

    /**
     * 详情或其他数据下载状态
     * 0 详情数据需要更新
     * 1 详情数据已更新
     */
    private Integer downloadStatus;

    /**
     * 产品详情
     */
    private Item detail;

    /**
     * 亚马逊关联的库存SKU
     */
    private String platformFnSku;

    /**
     * 转换目标实体:PlatformProductDTO
     */
    public static PlatformProductDTO convertDTO(PlatformAmazonListingDTO sourceEntity) {
        // 图片默认
        String imageUrl = sourceEntity.getImageUrl();
        // 时间
        PlatformProductDTO resultDto = new PlatformProductDTO()
                // 平台spu no
                .setPlatformProductNo(sourceEntity.getAsin1())
                // 平台sku no
                .setPlatformSkuNo(sourceEntity.getSellerSku())
                // 平台产品名称
                .setPlatformProductName(sourceEntity.getItemName())
                // 类型 platform 平台  warehouse 仓库
                .setPlatformType("platform")
                // 产品图片 url
                .setProductImageUrl(imageUrl)
                // 包装
                .setProductPacking(sourceEntity.getProductPacking())
                // 规格
                .setProductSpec(sourceEntity.getProductSpec())
                // 平台最后修改时间
                .setPlatformUpdateTime(sourceEntity.getPlatformUpdateTime())
                // 店铺ID
                .setShopId(sourceEntity.getShopId())
                // 亚马逊关联的库存SKU
                .setPlatformFnSku(sourceEntity.getPlatformFnSku())
                ;

        // 平台
        resultDto.setPlatform(PlatformDictEnum.AMAZON.getCode());
        resultDto.setUniqueId(sourceEntity.getListingId());
        resultDto.setDownloadStatus(0);
        return resultDto;
    }

    public static void main(String[] args) {
        String ee = "2020-08-04 03:56:29 PDT";
        LocalDateTime parse = LocalDateTime.parse(ee, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z", Locale.ENGLISH));
        System.out.println(parse);
    }
}
