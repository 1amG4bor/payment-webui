package com.g4bor.payment.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UIController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transfer")
    public String mainPage() {
        return "index";
    }
}
