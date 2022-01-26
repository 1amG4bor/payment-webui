package com.g4bor.payment.webui.config;

import com.g4bor.payment.webui.config.auth.AuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationConfig userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService.getUserDetailsManager())
            .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions()
                .sameOrigin();
        http
            .csrf().disable().authorizeRequests()
            .antMatchers("/", "/css/**", "/imgs/**", "/js/**").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/logout").permitAll()
            .antMatchers("/h2/**").hasRole("ADMIN")
            .antMatchers("/**").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/transfer")
            .and().logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
            .and().exceptionHandling().accessDeniedPage("/403");
    }
}
