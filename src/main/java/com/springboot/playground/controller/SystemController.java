package com.springboot.playground.controller;

import com.springboot.playground.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(SystemController.API_ROOT)
public class SystemController {

    static final String API_ROOT = "api/v1/system";
    private SystemService systemService;

    @Autowired
    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return systemService.healtCheck();
    }
}
