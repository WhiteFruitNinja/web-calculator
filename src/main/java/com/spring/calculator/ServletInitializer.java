package com.spring.calculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


// Servlet is a java program that works in a WEB server
// Servlet is initialized when the user clicks a link or does any kind of operation
// Clients every request goes through the Servlet which gives it to the Controllers RequestMapping attribute
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebCalculatorApplication.class);
    }

}
