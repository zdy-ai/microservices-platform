package com.erp.sdk.oms.amz.spapi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.common.core.exception.ServiceException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 亚马逊SP-API中使用的商城标识符
 *
 * @author Jim
 * @date 2023/10/17 10:13
 */
@Getter
@AllArgsConstructor
public enum AmazonMarketplaceEnum {
    // 北美
    CA("A2EUQ1WTGCTBG2", "加拿大", "CA", AmazonEndpointsEnum.US_EAST_1),
    US("ATVPDKIKX0DER", "美国", "US", AmazonEndpointsEnum.US_EAST_1),
    MX("A1AM78C64UM0Y8", "墨西哥", "MX", AmazonEndpointsEnum.US_EAST_1),
    BR("A2Q3Y263D00KWC", "巴西", "BR", AmazonEndpointsEnum.US_EAST_1),
    // 欧洲
    ES("A1RKKUPIHCS9HS", "西班牙", "ES", AmazonEndpointsEnum.EN_WAST_1),
    GB("A1F83G8C2ARO7P", "英国", "GB", AmazonEndpointsEnum.EN_WAST_1),
    FR("A13V1IB3VIYZZH", "法国", "FR", AmazonEndpointsEnum.EN_WAST_1),
    BE("AMEN7PMS3EDWL", "比利时", "BE", AmazonEndpointsEnum.EN_WAST_1),
    NL("A1805IZSGTT6HS", "荷兰", "NL", AmazonEndpointsEnum.EN_WAST_1),
    DE("A1PA6795UKMFR9", "德国", "DE", AmazonEndpointsEnum.EN_WAST_1),
    IT("APJ6JRA9NG5V4", "意大利", "IT", AmazonEndpointsEnum.EN_WAST_1),
    SE("A2NODRKZP88ZB9", "瑞典", "SE", AmazonEndpointsEnum.EN_WAST_1),
    ZA("AE08WJ6YKNBMC", "南非", "ZA", AmazonEndpointsEnum.EN_WAST_1),
    PL("A1C3SOZRARQ6R3", "波兰", "PL", AmazonEndpointsEnum.EN_WAST_1),
    EG("ARBP9OOSHTCHU", "埃及", "EG", AmazonEndpointsEnum.EN_WAST_1),
    TR("A33AVAJ2PDY3EV", "土耳其", "TR", AmazonEndpointsEnum.EN_WAST_1),
    SA("A17E79C6D8DWNP", "沙特阿拉伯", "SA", AmazonEndpointsEnum.EN_WAST_1),
    AE("A2VIGQ35RCS4UG", "阿拉伯联合酋长国", "AE", AmazonEndpointsEnum.EN_WAST_1),
    IN("A21TJRUUN4KGV", "印度", "IN", AmazonEndpointsEnum.EN_WAST_1),
    // 远东
    SG("A19VAU5U5O7RUS", "新加坡", "SG", AmazonEndpointsEnum.US_WAST_2),
    AU("A39IBJ37TRP1C6", "澳大利亚", "AU", AmazonEndpointsEnum.US_WAST_2),
    JP("A1VC38T7YXB528", "日本", "JP", AmazonEndpointsEnum.US_WAST_2),
    ;

    /**
     * 商城编号
     */
    @EnumValue
    @JsonValue
    private final String marketplaceId;
    /**
     * 名称
     */
    private final String name;
    /**
     * 国家/地区代码
     */
    private final String countryCode;
    /**
     * 对应亚马逊SP-API端点
     */
    private final AmazonEndpointsEnum endpointsEnum;


    /**
     * 通过Region查找枚举
     */
    public static AmazonMarketplaceEnum getByCountryCode(String countryCode) {
        return Stream.of(AmazonMarketplaceEnum.values())
                .filter(e -> e.getCountryCode().equalsIgnoreCase(countryCode))
                .findFirst()
                .orElseThrow(() -> new ServiceException("未找到对应Marketplace"));
    }


    /**
     * 通过marketPlaceId查找枚举
     */
    public static AmazonMarketplaceEnum getByMarketplaceId(String marketPlaceId) {
        return Stream.of(AmazonMarketplaceEnum.values())
                .filter(e -> e.getMarketplaceId().equalsIgnoreCase(marketPlaceId))
                .findFirst()
                .orElseThrow(() -> new ServiceException("未找到对应Marketplace"));
    }
}
