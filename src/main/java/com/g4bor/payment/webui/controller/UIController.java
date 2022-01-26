package com.g4bor.payment.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class UIController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/403")
    public ModelAndView accessDenied(Principal user) {
        String username = user.getName();
        if (null == username) {
            username = "stranger";
        }

        ModelAndView model = new ModelAndView();
        String message = String.format("Hi %s, you are not authorized to view this page!", username);
        model.addObject("message", message);
        model.setViewName("403");
        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transfer")
    public String mainPage() {
        return "transfer";
    }
}
