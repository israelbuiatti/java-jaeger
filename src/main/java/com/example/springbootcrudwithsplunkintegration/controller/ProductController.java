package com.example.springbootcrudwithsplunkintegration.controller;


import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    Logger logger = LogManager.getLogger(ProductController.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String findAll() {

        Tracer tracer = GlobalOpenTelemetry.getTracer("my-java-app");
        Span span = tracer.spanBuilder("exampleSpan").startSpan();
        try (Scope scope = span.makeCurrent()) {
            logger.info("test api");
        } finally {
            span.end();
        }

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://viacep.com.br/ws/60191355/json/", String.class);

        return responseEntity.getBody();
    }




}

