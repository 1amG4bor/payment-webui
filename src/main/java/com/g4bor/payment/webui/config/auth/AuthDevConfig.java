package com.g4bor.payment.webui.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Profile("dev")
@Configuration
@Order(2)
public class AuthDevConfig implements AuthenticationConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetailsManager getUserDetailsManager() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withUsername("admin").password(passwordEncoder.encode("admin"))
                .roles("ADMIN", "USER").build());
        userDetailsList.add(User.withUsername("user").password(passwordEncoder.encode("pass"))
                .roles("USER").build());
        return new InMemoryUserDetailsManager(userDetailsList);
    }

}
