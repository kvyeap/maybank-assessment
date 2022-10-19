package com.maybank.assessment.controllers;

import com.maybank.assessment.controllers.form.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/country")
@Transactional(Transactional.TxType.SUPPORTS)
public class NestedApiController {

    @GetMapping
    public ResponseEntity<?> getCountry() {

        RestTemplate restTemplate = new RestTemplate();

        Country[] response = restTemplate.getForObject("https://api.sampleapis.com/countries/countries", Country[].class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
