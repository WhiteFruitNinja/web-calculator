package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

// Web kontroleris leidžia naudoti @RequestMapping anotaciją.
// @RestController anotacija nurodo, pavyzdžiui: String tipo rezultatas turėtų būti tiesiogiai išspausdinamas klientui.
@RestController
// @EnableAutoConfiguration įgalina automatinę konfigūraciją, žyminti konfigūracijos komponentą viduje,
// leidžiantį kurti Bean'us per metodus su @Bean anotacija.
// Ši klasės lygio anotacija nurodo Spring karkasui "atspėti konfigūraciją".
// Remiantis priklausomybėmis (jar bibliotekomis), kurios yra įtrauktos į projektą (pom.xml).
// Šiuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration
public class WebCalculatorController {
    // Pavyzdis URL: http://localhost:8080/hello?name=Egidijus&surname=Jakimovas
    // Metodo pavadinimas yra "hello", raktas - "name", o jo reikšmė gaunama iš lygybės ženklo.
    // Norint gauti daugiau reikšmių, naudoti simbolį "&".
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/index")
    public String index() {
        return "<h1> Web calculator </h1>" +
                "<h3> Possible operations: </h3>" +
                "&nbsp;&nbsp; Add </br>" +
                "&nbsp;&nbsp; Subtract </br>" +
                "&nbsp;&nbsp; Multiply </br>" +
                "&nbsp;&nbsp; Divide </br>";
    }
}
