package com.example.springbootcrudwithsplunkintegration.controller;


import com.example.springbootcrudwithsplunkintegration.service.ViaCep;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ViaCep viaCep;


    @GetMapping
    public String findAll() {

        Tracer tracer = GlobalOpenTelemetry.getTracer("my-java-app");
        Span span = tracer.spanBuilder("exampleSpan").startSpan();
        try (Scope scope = span.makeCurrent()) {
            logger.info("test api");
        } finally {
            span.end();
        }

        return viaCep.viaCep();
    }




}

