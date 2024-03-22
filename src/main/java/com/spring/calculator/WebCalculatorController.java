package com.spring.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

// Naršyklės valdiklis, leidžiantis naudoti @RequestMapping
// Jis sujungia vartotojo įvestį su mūsų turimais ištekliais
// @RestController anotacija leidžia pavyzdžiui: rezultatas tipo String turi būti spausdinamas tiksliai taip, kaip yra.
// Tačiau mums reikia gauti peržiūrą, todėl naudojame @Controller

// Apibrėžia konfigūracijos komponentą. Viduje leidžia kurti pupelės iš metodų su @Beans anotacija.
// Ši klasės lygmens anotacija leidžia Spring "atmesti" konfigūraciją
// Remiantis priklausomybėmis (.jar bibliotekomis), kurių programuotojas deda į projektą (pom.xml)
// Šiuo atveju tai veikia kartu su pagrindiniu metodu
@Controller
public class WebCalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        // Grąžinti jsp failą, jis turi būti webapp -> WEB-INF -> jsp
        return "calculator";
    }

    @PostMapping("/calculate")
    // Galite tai padaryti su @RequestParam
    public String calculate(@RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        int num1 = Integer.parseInt(numbers.get("num1"));
        int num2 = Integer.parseInt(numbers.get("num2"));
        String symbol = numbers.get("symbol");
        System.out.println(numbers.entrySet());

        int result;

        switch (symbol) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                // Patikrinkite, ar num2 nėra nulis, kad išvengtumėte dalybos iš nulio
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    // Tvarkyti dalybos iš nulio klaidą
                    modelMap.put("error", "Negalima dalinti iš nulio");
                    // Priesaga + failo pavadinimas + priesaga
                    return "calculator";
                }
            }
            default -> {
                return "calculator";
            }
        }

        // Modelio žemėlapis naudojamas siųsti vertes iš Spring MVC valdiklio į JSP
        modelMap.put("num1", num1);
        modelMap.put("num2", num2);
        modelMap.put("symbol", symbol);
        modelMap.put("result", result);

        return "calculate";
    }

}
