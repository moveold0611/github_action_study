package com.server.deploy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class HealthCheckController {
    @Value("${serverName}")
    private String serverName;
    @Value("${server.env}")
    private String env;
    private Integer visitedCount = 0;


    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        visitedCount++;

        Map<String, Object> healthCheckData = new HashMap<>();
        healthCheckData.put("actor", "이동헌");
        healthCheckData.put("serverName", serverName);
        healthCheckData.put("env", env);
        healthCheckData.put("visitedCount", visitedCount);

        return ResponseEntity.ok().body(healthCheckData);
    }

    @GetMapping("/env")
    public ResponseEntity<String> getEnv() {
        return ResponseEntity.ok().body(env);
    }


}
