package com.sdk.oms.shopify.api.graphql;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class GraphqlSchemaReaderUtil {

    /**
     * @param filename
     * @return String
     * @throws IOException
     */
    /* Load GraphQL schema from file in the classpath. */
    public static String getSchemaFromFileName(final String filename) throws IOException {
        InputStream inputStream = GraphqlSchemaReaderUtil.class.getClassLoader().getResourceAsStream("graphql/" + filename + ".graphql");
        if (inputStream == null) {
            log.error("getSchemaFromFileName: no file found with name: {}", "graphql/" + filename + ".graphql");
            return null;
        } else {
            return new String(IOUtils.toByteArray(inputStream));
        }
    }


    /**
     * @param filename
     * @return String
     * @throws IOException
     */
    /* Load GraphQL variables from file in the classpath. */
    public static String getVariablesFromFileName(final String filename) throws IOException {
        InputStream inputStream = GraphqlSchemaReaderUtil.class.getClassLoader().getResourceAsStream("graphql/" + filename + "Variables.json");
        if (inputStream == null) {
            log.error("getVariablesFromFileName: no file found with name: {}", "graphql/" + filename + "Variables.json");
            return null;
        } else {
            return new String(IOUtils.toByteArray(inputStream));
        }
    }

}
