package com.spring.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

// Web Controller that lets use @RequestMapping
// It combines what the user inputs with our available resources
// @RestController annotation lets for example: String type result needs to be printed exactly as is.
// However, we need to get a view, so we use @Controller

// Defines the configuration component. Inside lets create bean from methods with @Beans annotation.
// This class level annotation lets Spring "guess"" the configuration
// Based on dependencies (.jar library's) witch the programmer puts in the project (pom.xml)
// In this case it works together with the main method
@Controller
public class WebCalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        // Return the jsp file must be in webapp -> WEB-INF -> jsp
        return "calculator";
    }

    // Because the calculator form uses POST method we need to use POST here as well

    /*@RequestMapping(method = RequestMethod.POST, value = "/calculate")*/

    @PostMapping("/calculate")
    // You can do it with @RequestParam
    public String calculate(@RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        int number1 = Integer.parseInt(numbers.get("number1"));
        int number2 = Integer.parseInt(numbers.get("number2"));
        String symbol = numbers.get("symbol");
        System.out.println(numbers.entrySet());

        // Or you can do it without if the values of frontend and backend are the same

        /*public String calculate(int number1, int number2, String symbol, ModelMap modelMap) {*/
        /*int number1 = Integer.parseInt(numbers.get("number1"));
        int number2 = Integer.parseInt(numbers.get("number2"));*/

        int result;

        switch (symbol) {
            case "+" -> result = number1 + number2;
            case "-" -> result = number1 - number2;
            case "*" -> result = number1 * number2;
            case "/" -> {
                // Check if number2 is not zero to avoid division by zero
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    // Handle division by zero error
                    modelMap.put("error", "Can't divide by zero");
                    // Prefix + file name + suffix
                    return "calculator";
                }
            }
            default -> {
                return "calculator";
            }
        }

        // Model map is used to send values from Spring MVC controller to JSP
        modelMap.put("number1", number1);
        modelMap.put("number2", number2);
        modelMap.put("symbol", symbol);
        modelMap.put("result", result);

        return "calculate";
    }

}
