package com.g4bor.payment.webui.config.client;

import org.springframework.web.client.RestTemplate;

public interface HttpClientConfiguration {
    public RestTemplate getRestTemplate();
}
