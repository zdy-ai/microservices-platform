package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Currency;

public class CurrencySerializer extends StdSerializer<Currency> {

    public CurrencySerializer() {
        this(Currency.class);
    }

    protected CurrencySerializer(Class<Currency> t) {
        super(t);
    }


    /**
     * @param value
     * @param gen
     * @param provider
     * @throws IOException
     */
    @Override
    public void serialize(Currency value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getCurrencyCode());
    }

}
