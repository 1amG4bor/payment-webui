package com.g4bor.payment.webui.controller;

import com.g4bor.payment.webui.service.AcquirerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private AcquirerService testService;

    public TestController(AcquirerService service) {
        this.testService = service;
    }

    @GetMapping
    public String testHttpClient() {
        return testService.testingAcquirerService();
    }
}
