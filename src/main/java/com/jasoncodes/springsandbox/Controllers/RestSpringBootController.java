package com.jasoncodes.springsandbox.Controllers;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jasoncodes.springsandbox.Api.Keys.APIK;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestSpringBootController {



    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient(){
        String url = "http://localhost:8080/hello";                             //   API Address
                                                                                // Will add key
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);           //   Combine all for URL
        return result;
    }

    @GetMapping(value = "/people")
    @JsonBackReference
    private String getPeople(){
        String url = "https://swapi.dev/api/people";
        // Will add key
        RestTemplate restTemplate = new RestTemplate();
        String people = restTemplate.getForObject(url, String.class);
        return people;
    }

    @GetMapping(value = "/p1")
    @JsonBackReference
    private String getPersonIndex1(){
        String url = "https://swapi.dev/api/people/1";
        // Will add key
        RestTemplate restTemplate = new RestTemplate();
        String people = restTemplate.getForObject(url, String.class);
        return people;
    }

    @GetMapping(value = "/r1")
    @JsonBackReference
    private String getRecipe(){

        String api01 = APIK.getKey01();
        String url = "https://api.spoonacular.com/recipes/complexSearchquery=pasta/information?apiKey=" + api01;
        // Will add key
        RestTemplate restTemplate = new RestTemplate();
        String r1 = restTemplate.getForObject(url, String.class);
        return r1;
    }

}
