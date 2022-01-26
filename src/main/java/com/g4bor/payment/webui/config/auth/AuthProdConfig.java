package com.g4bor.payment.webui.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Profile("prod")
@Configuration
@Order(2)
public class AuthProdConfig implements AuthenticationConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetailsManager getUserDetailsManager() {

        return jdbcUserDetailsManager();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
//        manager.setUsersByUsernameQuery("SELECT user_name, password, enabled FROM users WHERE user_name =?");
//        manager.setAuthoritiesByUsernameQuery("SELECT user_name, authority FROM authorities WHERE user_name =?");
        return manager;
    }

//    @Override
//    public void configureProd(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .dataSource(dataSource)
//            .usersByUsernameQuery("SELECT * FROM users WHERE user_name = ?")
//            .authoritiesByUsernameQuery("SELECT * FROM authorities WHERE user_name = ?");
//    }


}
