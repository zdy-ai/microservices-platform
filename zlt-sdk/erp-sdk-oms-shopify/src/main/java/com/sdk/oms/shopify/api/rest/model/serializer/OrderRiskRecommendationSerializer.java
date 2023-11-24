package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sdk.oms.shopify.api.rest.model.OrderRiskRecommendation;

import java.io.IOException;

public class OrderRiskRecommendationSerializer extends StdSerializer<OrderRiskRecommendation> {

    public OrderRiskRecommendationSerializer() {
        this(OrderRiskRecommendation.class);
    }

    protected OrderRiskRecommendationSerializer(Class<OrderRiskRecommendation> t) {
        super(t);
    }


    /**
     * @param value
     * @param gen
     * @param provider
     * @throws IOException
     */
    @Override
    public void serialize(OrderRiskRecommendation value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());

    }

}
