package com.sdk.oms.shopify.api.rest.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://shopify.dev/docs/api/admin-rest/2023-07/resources/product">接口文档</a>
 */
@Slf4j
@Data
@NoArgsConstructor
public class ShopifyProduct {

    private String id;
    @JsonSerialize(using = EscapedStringSerializer.class)
    private String title;
    @JsonProperty("product_type")
    private String productType;
    @JsonProperty("body_html")
    @JsonSerialize(using = EscapedStringSerializer.class)
    private String bodyHtml;
    @JsonSerialize(using = EscapedStringSerializer.class)
    private String vendor;
    @JsonSerialize(using = TagsSerializer.class)
    @JsonDeserialize(using = TagsDeserializer.class)
    @JsonProperty("tags")
    private Set<String> tags = new HashSet<>();
    private List<Option> options = new LinkedList<>();
    @JsonProperty("metafields_global_title_tag")
    private String metafieldsGlobalTitleTag;
    @JsonProperty("metafields_global_description_tag")
    private String metafieldsGlobalDescriptionTag;
    private List<Image> images = new LinkedList<>();
    private Image image;
    private List<ShopifyVariant> variants = new LinkedList<>();
    @JsonProperty("published_at")
    private String publishedAt;
    private Boolean published;
    @JsonProperty("created_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;
    @JsonProperty("published_scope")
    private String publishedScope;
    private String handle;
    @JsonProperty("template_suffix")
    private String templateSuffix;
    /**
     * active/archived/draft
     * active: 上架
     * archived: 下架
     * draft: 未准备好
     */
    private String status;
    @JsonProperty("admin_graphql_api_id")
    private String adminGraphqlApiId;


    /**
     * @return Boolean
     */
    public Boolean isPublished() {
        return (published == null) ? StringUtils.isNotBlank(publishedAt) : published;
    }


    /**
     * @return List<String>
     */
    public List<String> getSortedOptionNames() {
        final Comparator<Option> optionPositionComparator = new Comparator<Option>() {
            @Override
            public int compare(final Option o1, final Option o2) {
                return o1.getPosition() - o2.getPosition();
            }
        };
        return options.stream().sorted(optionPositionComparator).map(Option::getName).collect(Collectors.toList());
    }


    /**
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void ignored(String name, Object value) {
        log.debug("ShopifyRestAPI Ignored Property: {} = {}", name, value);
    }
}
