package com.sdk.oms.shopify.api.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeDeserializer;
import com.sdk.oms.shopify.api.rest.model.serializer.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopifyDeliveryMethod {

    /**
     * The type of method used to transfer a product or service to a customer
     *
     * @see #NONE
     * @see #LOCAL
     * @see #CUSTOM
     * @see #RETAIL
     * @see #PICK_UP
     * @see #SHIPPING
     */
    public enum MethodType {
        /**
         * No delivery method
         */
        NONE("none"),
        /**
         * A delivery to a customer's doorstep.
         */
        LOCAL("local"),
        /**
         * A default value for a non matching delivery method
         */
        CUSTOM("custom"),
        /**
         * Items delivered immediately in a retail store.
         */
        RETAIL("retail"),
        /**
         * A delivery that a customer picks up at your retail store, curbside,
         * or any location that you choose
         */
        PICK_UP("pick_up"),
        /**
         * A delivery to a customer using a shipping carrier
         */
        SHIPPING("shipping");

        static final String NO_MATCHING_ENUMS_ERROR_MESSAGE = "No matching enum found for status: %s";
        private final String value;

        private MethodType(final String value) {
            this.value = value;
        }

        public static MethodType toEnum(final String value) {
            if (NONE.toString().equals(value)) {
                return MethodType.NONE;
            } else if (LOCAL.toString().equals(value)) {
                return MethodType.LOCAL;
            } else if (RETAIL.toString().equals(value)) {
                return MethodType.RETAIL;
            } else if (PICK_UP.toString().equals(value)) {
                return MethodType.PICK_UP;
            } else if (SHIPPING.toString().equals(value)) {
                return MethodType.SHIPPING;
            } else {
                return MethodType.CUSTOM;
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private String id;
    @JsonProperty("method_type")
    private String methodType;
    @JsonProperty("min_delivery_date_time")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime minDeliveryDateTime;
    @JsonProperty("max_delivery_date_time")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime maxDeliveryDateTime;


}
