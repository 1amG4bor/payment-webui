package com.g4bor.payment.webui.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Apache HttpClient implementation for HTTP Client
 */
@Component
@Profile("prod")
public class ApacheHttpClientConfig extends BaseHttpClientConfig implements HttpClientConfiguration {

    @Override
    public RestTemplate getRestTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    private HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        CloseableHttpClient apacheClient = HttpClients.custom()
                .setDefaultRequestConfig(getRequestConfig())
                .setConnectionManager(getConnectionManager())
                .setKeepAliveStrategy(getKeepAliveStrategy())
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(apacheClient);
        return factory;
    }

    private RequestConfig getRequestConfig() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
    }

    private PoolingHttpClientConnectionManager getConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTIONS);
        connectionManager.setDefaultMaxPerRoute(MAX_CONNECTIONS);
        return connectionManager;
    }

    private ConnectionKeepAliveStrategy getKeepAliveStrategy() {
        return (httpResponse, httpContext) -> KEEP_ALIVE_TIME_SEC * 1000L;
    }
}
