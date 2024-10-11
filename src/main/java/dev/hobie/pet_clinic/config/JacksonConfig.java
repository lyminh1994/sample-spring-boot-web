package dev.hobie.pet_clinic.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class JacksonConfig {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
    return jacksonObjectMapperBuilder ->
        jacksonObjectMapperBuilder
            .modules(new JavaTimeModule())
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .featuresToDisable(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                DeserializationFeature.ACCEPT_FLOAT_AS_INT,
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                SerializationFeature.FAIL_ON_EMPTY_BEANS);
  }
}
