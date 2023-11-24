package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    protected LocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }


    /**
     * @param jsonParser
     * @param deserializationContext
     * @throws IOException
     */
    @Override
    public LocalDateTime deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        // from：2023-08-23T03:40:31-04:00
        return OffsetDateTime
                .parse(jsonParser.getValueAsString())
                .atZoneSameInstant(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}
