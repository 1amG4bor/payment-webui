package com.g4bor.payment.webui.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AcquirerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcquirerService.class);
    private static final String APIKEY_HEADER_NAME = "X-API-Key";

    private final RestTemplate restTemplate;

    @Value("${http.apikey.acquirer}")
    private String acquirerApiKey;

    private String TEST_URL = "http://127.0.0.1:9100/api/test";

    public AcquirerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String testingAcquirerService() {
        String response = executeAcquirerRequest(TEST_URL, HttpMethod.GET, String.class);
        return response;
    }

    private <T> T executeAcquirerRequest(String URL, HttpMethod httpMethod, Class<T> targetClass) {
        HttpEntity<Void> requestEntity = getAcquirerRequestEntity();
        ResponseEntity<T> response = restTemplate.exchange(URL, httpMethod, requestEntity, targetClass);
        return response.getBody();
    }

    private HttpEntity<Void> getAcquirerRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(APIKEY_HEADER_NAME, acquirerApiKey);
        return new HttpEntity<Void>(headers);
    }
}
