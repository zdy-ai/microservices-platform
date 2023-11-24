package com.sdk.oms.shopify.api.rest.mappers;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * Instead of using the default Spring ObjectMapper we are using a custom one for the Shopify REST API. This way, we can customize the serialization
 * and deserialization process for the Shopify REST API, seperately from any Jackson based REST services we may wish to vend from our application
 * (which can then use the default Spring ObjectMapper).
 * 
 * 
 */
public class ShopifySdkObjectMapper {

	private ShopifySdkObjectMapper() {}


	/**
	 * @return ObjectMapper
	 * 
	 */
	public static ObjectMapper buildMapper() {
		final AnnotationIntrospector pair =
				AnnotationIntrospector.pair(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()), new JacksonAnnotationIntrospector());

		ObjectMapper objectMapper = JsonMapper.builder().enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(MapperFeature.USE_ANNOTATIONS, true)
				.annotationIntrospector(pair).serializationInclusion(Include.NON_NULL).build();
		objectMapper.registerModule(new SimpleModule());
		return objectMapper;
	}
}
