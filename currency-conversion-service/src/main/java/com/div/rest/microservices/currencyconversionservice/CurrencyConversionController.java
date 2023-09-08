package com.div.rest.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class CurrencyConversionController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
//        System.out.println("\n\n\n\n\nchlra h");
        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        uriVariables.put("quantity",""+quantity);
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}/quantity/{quantity}", CurrencyConversion.class, uriVariables);
//        ResponseEntity<String> responseEntity=new RestTemplate().getForEntity("https://jsonplaceholder.typicode.com/posts/1",String.class);

//        System.out.println("\n\n\n\nthis"+responseEntity+"\n\n");
        CurrencyConversion currencyConversion = responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(),from,to,currencyConversion.getConversionMultiple(),quantity,quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment() + " " + "rest template");

//        return responseEntity.getBody();
    }
}
