package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
// Nurodoma klasėje, turinčioje pagrindinį (main) metodą.
@SpringBootApplication
// WEB Kontroleris. Pažymi MVC valdiklį. Leidžia viduje naudoti @RequestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turėtų būti išspausdinamas klientui toks koks yra.
@RestController
public class WebCalculatorApplication {

    public static void main(String[] args) {
// Programos kontrolė deleguojama statiniam klasės metodui "run", nurodant aplikacijos šakninį komponentą "root".
// Spring karkasas paleis aplikaciją, tai reiškia, kad bus paleistas Tomcat serveris.
        SpringApplication.run(WebCalculatorApplication.class, args);
    }
}
