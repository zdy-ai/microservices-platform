package com.sdk.oms.shopify.api.rest.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;

public class EscapedStringSerializer extends StdSerializer<String> {

    public EscapedStringSerializer() {
        super(String.class);
    }


    /**
     * @param value
     * @param jgen
     * @param provider
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(StringEscapeUtils.unescapeHtml4(value));
    }
}

