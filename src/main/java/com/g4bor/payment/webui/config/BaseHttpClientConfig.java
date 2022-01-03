package com.g4bor.payment.webui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Base configuration for HTTP Client
 */
@Configuration
@PropertySource("application.yaml")
public abstract class BaseHttpClientConfig {

    // The timeout in milliseconds until a connection is established
    @Value("${http.client.connectionTimeout:30_000}")
    protected int CONNECTION_TIMEOUT;

    // The timeout when requesting a connection from the connection manager
    @Value("${http.client.requestTimeout:30_000}")
    protected int REQUEST_TIMEOUT;

    // The timeout for waiting for data
    @Value("${http.client.socketTimeout:60_000}")
    protected int SOCKET_TIMEOUT;

    // Max connections in the pool
    @Value("${http.client.maxConnections:50}")
    protected int MAX_CONNECTIONS;

    // The timeout in seconds to keep alive a connection
    @Value("${http.client.defaultKeepAlive:30}")
    protected int KEEP_ALIVE_TIME_SEC;

    @Value("${http.client.idleTimeSecs:30}")
    protected int CLOSE_IDLE_CONNECTION_WAIT_TIME_SECS;
}
