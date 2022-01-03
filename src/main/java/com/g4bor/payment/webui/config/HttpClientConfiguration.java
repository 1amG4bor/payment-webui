package com.g4bor.payment.webui.config;

import org.springframework.web.client.RestTemplate;

public interface HttpClientConfiguration {
    public RestTemplate getRestTemplate();
}
