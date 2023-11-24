package com.sdk.oms.shopify.dto;

import com.common.business.dto.CleanBaseDTO;
import com.common.business.dto.JobTaskDTO;
import com.common.business.dto.PlatformProductDTO;
import com.common.business.enums.PlatformDictEnum;
import com.sdk.oms.shopify.api.rest.model.Image;
import com.sdk.oms.shopify.api.rest.model.ShopifyProduct;
import com.sdk.oms.shopify.api.rest.model.ShopifyVariant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 平台Shopify产品DTO
 *
 * @Author Jim
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PlatformShopifyListingDTO extends CleanBaseDTO {

    /**
     * Shopify SDK 产品信息
     */
    private ShopifyProduct shopifyProduct;


    /**
     * 初始化
     */
    public PlatformShopifyListingDTO(ShopifyProduct shopifyProduct, JobTaskDTO dto) {
        this.shopifyProduct = shopifyProduct;
        this.setIsClean(0);
        this.setPlatform(PlatformDictEnum.SHOPIFY.getCode());
        this.setUniqueId(shopifyProduct.getId());
        this.setDownloadTime(LocalDateTime.now(ZoneId.systemDefault()).toString());
        this.setLastPushTime(dto.getNextTime().toString());
    }


    /**
     * 转换目标实体:PlatformProductDTO
     */
    public static List<PlatformProductDTO> convertDTO(PlatformShopifyListingDTO dto) {
        // 原商品信息
        ShopifyProduct sourceProduct = dto.getShopifyProduct();
        return sourceProduct.getVariants().stream()
                .map(v -> initPlatformProductDTO(sourceProduct, dto, v))
                .collect(Collectors.toList());
    }

    /**
     * 根据ShopifyVariant变体(SKU) 转换 DTO
     */
    private static PlatformProductDTO initPlatformProductDTO(ShopifyProduct sourceProduct, PlatformShopifyListingDTO dto, ShopifyVariant variant) {
        // 产品规格信息
        String productSpec = variant.checkAndGetOptions(sourceProduct.getOptions());
        // 图片默认
        String imageUrl = sourceProduct.getImage().getSource();
        // 规格的图片不为空查询
        if (StringUtils.isNotBlank(variant.getImageId())) {
            // 找到对应ImageId的图片
            Image currentImage = sourceProduct.getImages().stream()
                    .filter(e -> e.getId().equalsIgnoreCase(variant.getImageId()))
                    .findFirst().orElse(null);
            if (null != currentImage) {
                imageUrl = currentImage.getSource();
            }
        }
        // 包装信息
        String packing = "包装重量:".concat(variant.getWeight()).concat(variant.getWeightUnit());

        PlatformProductDTO resultDto = new PlatformProductDTO()
                // 平台spu no
                .setPlatformProductNo(variant.getProductId())
                // 平台sku no
                .setPlatformSkuNo(variant.getId())
                // 平台产品名称
                .setPlatformProductName(sourceProduct.getHandle())
                // 类型 platform 平台  warehouse 仓库
                .setPlatformType("platform")
                // 产品图片 url
                .setProductImageUrl(imageUrl)
                // 产品规格信息
                .setProductSpec(productSpec)
                // 产品包装信息
                .setProductPacking(packing)
                // 平台最后修改时间
                .setPlatformUpdateTime(variant.getCreatedAt())
                ;

        // 平台
        resultDto.setPlatform(dto.getPlatform());
        resultDto.setUniqueId(variant.getId());
        return resultDto;
    }
}
