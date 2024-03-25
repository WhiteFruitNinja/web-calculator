package com.spring.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

// Valdiklis skirtas interneto sąsajai (Web Controller), leidžia naudoti @RequestMapping
// Jis sudaro vartotojo įvestį su mūsų turimais ištekliais
// @RestController anotacija leidžia pvz.: String tipo rezultatą reikia atspausdinti tiksliai kaip yra.
// Tačiau, reikia gauti vaizdą, todėl naudojame @Controller

// Apibrėžia konfigūracijos komponentą. Viduje leidžia sukurti pupelę iš metodų su @Beans anotacija.
// Šio lygio klasės anotacija leidžia Spring "atspėti" konfigūraciją
// Pagrįsta priklausomybėmis (.jar bibliotekomis), kurias programuotojas įdeda į projektą (pom.xml)
// Šiuo atveju tai veikia kartu su pagrindiniu metodu

@Controller
public class WebCalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        // Grąžina jsp failą, kuris turi būti webapp -> WEB-INF -> jsp
        return "calculator";
    }

    // Kadangi skaičiuotuvo forma naudoja POST metodą, turime naudoti POST čia taip pat

    @PostMapping("/calculate")
    // Galima tai padaryti su @RequestParam
    public String calculate(@RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        int number1 = Integer.parseInt(numbers.get("number1"));
        int number2 = Integer.parseInt(numbers.get("number2"));
        String symbol = numbers.get("symbol");
        System.out.println(numbers.entrySet());

        // Arba galima tai padaryti be, jei priekyje ir gale vertės yra tokios pačios

        int result;

        switch (symbol) {
            case "+" -> result = number1 + number2;
            case "-" -> result = number1 - number2;
            case "*" -> result = number1 * number2;
            case "/" -> {
                // Patikrinti, ar number2 nėra nulis, kad išvengti dalijimo iš nulio klaidos
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    // Apibrėžti dalijimo iš nulio klaidą
                    modelMap.put("error", "Negalima dalinti iš nulio");
                    // Priešdėlis + failo pavadinimas + priesaga
                    return "calculator";
                }
            }
            default -> {
                return "calculator";
            }
        }

        // Modelio žemėlapis naudojamas siųsti reikšmes iš Spring MVC valdiklio į JSP
        modelMap.put("number1", number1);
        modelMap.put("number2", number2);
        modelMap.put("symbol", symbol);
        modelMap.put("result", result);

        return "calculate";
    }

}
