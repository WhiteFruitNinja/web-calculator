package com.spring.calculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Servletas yra Java programa, kuri veikia WEB serveryje
// Servletas inicializuojamas, kai vartotojas spustelėja nuorodą arba atlieka bet kokio tipo veiksmą
// Klientų kiekvienas užklausimas eina per Servletą, kuris jį perduoda valdikliams su RequestMapping atributu
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebCalculatorApplication.class);
    }

}
