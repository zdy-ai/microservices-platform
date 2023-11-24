package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.time.LocalDateTime;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    public LocalDateTimeSerializer() {
        this(LocalDateTime.class);
    }

    protected LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }


    /**
     * @param value
     * @param gen
     * @param provider
     * @throws IOException
     */
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        // 格式 2023-08-23T03:40:31-04:00
        gen.writeString(value.atZone(ZoneId.systemDefault()).toOffsetDateTime().toString());
    }

}
