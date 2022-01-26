package com.g4bor.payment.webui.config.client;

import com.g4bor.payment.webui.config.client.BaseHttpClientConfig;
import com.g4bor.payment.webui.config.client.HttpClientConfiguration;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpClient implementation for HTTP Client
 */
@Component
@Profile("dev")
public class OkHttpClientConfig extends BaseHttpClientConfig implements HttpClientConfiguration {

    @Override
    public RestTemplate getRestTemplate() {
        OkHttpClient.Builder builder = getClientBuilder();
        OkHttpClient okHttpClient = builder.build();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory(okHttpClient));
        return restTemplate;
    }

    private OkHttpClient.Builder getClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        ConnectionPool okHttpConnectionPool = new ConnectionPool(MAX_CONNECTIONS, KEEP_ALIVE_TIME_SEC,
                TimeUnit.SECONDS);
        builder.connectionPool(okHttpConnectionPool);
        builder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(false);
        return builder;
    }
}
