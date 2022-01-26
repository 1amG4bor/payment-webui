package com.g4bor.payment.webui.config.auth;

import org.springframework.security.provisioning.UserDetailsManager;

public interface AuthenticationConfig {
    UserDetailsManager getUserDetailsManager();
}
