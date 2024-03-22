package com.spring.calculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Servletas yra Java programa, veikianti WEB serveryje
// Servletas inicializuojamas, kai vartotojas paspaudžia nuorodą arba atlieka bet kokį veiksmą
// Visos kliento užklausos eina per Servletą, kuris jas perduoda Valdiklio RequestMapping atributui
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebCalculatorApplication.class);
    }

}
