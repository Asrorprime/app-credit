package com.example.credit.controller;

import com.example.credit.model.Credit;
import com.example.credit.repository.CreditRepository;
import com.example.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    @Autowired
    RestTemplate restTemplate;
    private final CreditService creditService;
    private final CreditRepository creditRepository;

    @Autowired
    public CreditController(CreditService creditService, CreditRepository creditRepository) {
        this.creditService = creditService;
        this.creditRepository = creditRepository;
    }

    @RequestMapping(value = "/get-passport-list")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:7040/api/passport/get-passport", HttpMethod.GET, entity, String.class).getBody();
    }
    @RequestMapping(value = "/get-passport-with-pinfl", method = RequestMethod.POST)
    public ResponseEntity getPassport(@RequestBody Credit credit){
        Long pinfl =  credit.getPinfl();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Long> entity = new HttpEntity<Long>(pinfl, headers);
        return ResponseEntity.ok(restTemplate.exchange("http://localhost:7040/api/passport/get-pinfl/" +pinfl, HttpMethod.POST,entity,String.class).getBody());

    }


    public Double creditWithSalary(Long salary){
        long yearSalary = salary * 12;
        Double tax =  yearSalary * 0.3;
        Double credits = yearSalary - tax;
        return credits;
    }
}
