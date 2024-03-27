package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
// Nurodoma klasėje, turinčioje pagrindinį (main) metodą.
@SpringBootApplication
// WEB Kontroleris. Pažymi MVC valdiklį. Leidžia viduje naudoti @RequestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turėtų būti išspausdinamas klientui toks koks yra.
@RestController

public class CalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
        System.out.println("Woohoo first Spring Boot application");
    }

    // Metodo pavadinimas klaustukas (?) raktas, lygybe, reiksme. Optional jeigu daugiau nori reiksmiu simbolis & (and)
    // Pvz: http://localhost:8080/hello?name=Egidijus
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return " Hello, " + name;
    }

    @GetMapping("/index")
    public String index() {
        return "<h1>Online calculator. Will perform operations:</h1><br>" +
                "<h3> &nbsp;&nbsp; Add <br>" +
                "&nbsp;&nbsp; Multiply <br>" +
                "&nbsp;&nbsp; Divide <br>" +
                "&nbsp;&nbsp; Subtract <br> </h3>";
    }
}
