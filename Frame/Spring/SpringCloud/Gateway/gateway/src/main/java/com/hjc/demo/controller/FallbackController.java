package com.hjc.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FallbackController {

    @GetMapping("/fallbackA")
    public ResponseEntity fallbackA() {
        return ResponseEntity.ok("服务不可用，降级");
    }
}