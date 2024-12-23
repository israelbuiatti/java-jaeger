package com.example.springbootcrudwithsplunkintegration.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCep {

    private final RestTemplate restTemplate = new RestTemplate();

    public String viaCep() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://viacep.com.br/ws/60140200/json/", String.class);
        return responseEntity.getBody();
    }

}
