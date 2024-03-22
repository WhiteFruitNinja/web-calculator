package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

// Naršyklės valdiklis leidžia naudoti RequestMapping
// @RestController nurodo, kad String tipo reikšmė turi būti spausdinama tiksliai taip, kaip yra
@RestController
// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration, @ComponentScan.
// Ši anotacija naudojama klasėje su Main metodu
@SpringBootApplication
public class WebCalculatorApplication {

    public static void main(String[] args) {
        // Spring paleis programą, kuri pradeda tomcat serverį
        SpringApplication.run(WebCalculatorApplication.class, args);
    }

}
