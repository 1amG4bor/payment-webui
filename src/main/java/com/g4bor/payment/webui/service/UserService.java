package com.g4bor.payment.webui.service;

import com.g4bor.payment.webui.model.User;
import com.g4bor.payment.webui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String password) {
        UserDetails user = userDetailsService.loadUserByUsername(username);
        return passwordEncoder.matches(password, user.getPassword());
//        String encodedPassword = passwordEncoder.encode(password);
//        return user.getPassword().equals(encodedPassword);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userDetailsManager.loadUserByUsername(username);
//    }
}
