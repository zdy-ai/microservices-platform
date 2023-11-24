package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Currency;

public class CurrencyDeserializer extends StdDeserializer<Currency> {

    public CurrencyDeserializer() {
        super(Currency.class);
    }

    protected CurrencyDeserializer(Class<?> vc) {
        super(vc);
    }


    /**
     * @param jsonParser
     * @param deserializationContext
     * @return Currency
     * @throws IOException
     */
    @Override
    public Currency deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        return Currency.getInstance(jsonParser.getText().toUpperCase());
    }

}
