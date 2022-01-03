package com.g4bor.payment.webui.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateConfig.class);

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateConfig(HttpClientConfiguration httpClientConfig) {
        String clientConfig = httpClientConfig.getClass().getSimpleName();
        LOGGER.info("RestTemplate initialized with HttpClient configuration of: " + clientConfig);
        this.restTemplate = httpClientConfig.getRestTemplate();
    }

    @Bean
    public RestTemplate restTemplate() {
        return this.restTemplate;
    }
}
