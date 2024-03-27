package com.spring.calculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Servletas yra Java programa, veikianti WEB serverio aplinkoje.
// Servletas paleidžiamas, kai vartotojas spustelėja nuorodą, pateikia formą ar atlieka kitokio tipo veiksmus svetainėje.
// Kiekvienas kliento užklausa praeina per servletą, kuris ją perduoda kontroleriui, turinčiam RequestMapping atributą.
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CalculatorApplication.class);
    }

}
