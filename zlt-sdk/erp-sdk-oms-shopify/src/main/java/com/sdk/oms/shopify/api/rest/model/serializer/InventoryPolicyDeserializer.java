package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.sdk.oms.shopify.api.rest.model.InventoryPolicy;

import java.io.IOException;

public class InventoryPolicyDeserializer extends StdDeserializer<InventoryPolicy> {

    public InventoryPolicyDeserializer() {
        this(InventoryPolicy.class);
    }

    protected InventoryPolicyDeserializer(Class<?> vc) {
        super(vc);
    }


    /**
     * @param p
     * @param ctxt
     * @return InventoryPolicy
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public InventoryPolicy deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return InventoryPolicy.toEnum(p.getText());
    }

}
