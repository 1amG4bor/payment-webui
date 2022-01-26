package com.g4bor.payment.webui.controller;

import com.g4bor.payment.webui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/principal")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }

    @PostMapping("/login")
    public boolean login(String username, String password) {
        System.out.println("'/user/login' is called!");
        return userService.authenticate(username, password);
    }
}
