package com.sdk.oms.shopify.constant;

/**
 * @author Lambda
 * @Classname ShopifyConstant
 * @Description TODO
 * @Date 2023-08-28 16:43
 * @Created by yl
 */
public interface ShopifyConstant {


    /**
     * 店铺授权的范围
     * <a href="https://shopify.dev/docs/api/usage/access-scopes">权限范围链接</a>
     * shopify不支持过多的SHOP_SCOPE
     */
//    String SHOP_SCOPE = "read_orders,read_products,write_products,write_orders,write_fulfillments,read_fulfillments,read_merchant_managed_fulfillment_orders,write_merchant_managed_fulfillment_orders";
//    String SHOP_SCOPE = "read_all_orders,read_assigned_fulfillment_orders,write_assigned_fulfillment_orders,read_cart_transforms,write_cart_transforms,read_checkouts,write_checkouts,read_checkout_branding_settings,,write_checkout_branding_settings,read_content,write_content,read_customer_merge,write_customer_merge,read_customers,write_customers,read_customer_payment_methods,read_discounts,write_discounts,read_draft_orders,write_draft_orders,read_files,write_files,read_fulfillments,write_fulfillments,read_gift_cards,write_gift_cards,read_inventory,write_inventory,read_locales,write_locales,read_markets,write_markets,read_metaobject_definitions,write_metaobject_definitions,read_metaobjects,write_metaobjects,read_marketing_events,write_marketing_events,read_merchant_managed_fulfillment_orders,,write_merchant_managed_fulfillment_orders,read_orders,write_orders,read_payment_mandate,write_payment_mandate,read_payment_terms,write_payment_terms,read_price_rules,write_price_rules,read_products,write_products,read_publications,write_publications,read_purchase_options,write_purchase_options,read_reports,write_reports,read_resource_feedbacks,,write_resource_feedbacks,read_script_tags,write_script_tags,read_shipping,write_shipping,read_own_subscription_contracts,write_own_subscription_contracts,read_returns,write_returns,read_themes,write_themes,read_translations,write_translations,read_third_party_fulfillment_orders,write_third_party_fulfillment_orders,read_order_edits,write_order_edits,write_payment_gateways,write_payment_sessions";
    String SHOP_SCOPE = "read_all_orders,read_assigned_fulfillment_orders,write_assigned_fulfillment_orders,read_discounts,write_discounts,read_fulfillments,write_fulfillments,read_inventory,write_inventory,read_locales,write_locales,read_merchant_managed_fulfillment_orders,,write_merchant_managed_fulfillment_orders,read_orders,write_orders,read_products,write_products,read_reports,write_reports,read_shipping,write_shipping,read_returns,write_returns,read_third_party_fulfillment_orders,write_third_party_fulfillment_orders,read_order_edits,write_order_edits";

    String DOMAIN = ".myshopify.com";

}



