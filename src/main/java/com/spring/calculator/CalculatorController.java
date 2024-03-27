package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// Web kontroleris leidžia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turi būti išspausdintas klientui toks koks yra
//@RestController

//@RestController grąžina ne vaizdą
//Kadangi mums reikia grąžinti vaizdą naudojant Spring MVC, naudojame @Controller
@Controller
// Žymi konfigūracijos komponentą viduje, leidžia kurti bean'us per metodus su @Bean anotacija.
// Ši klasės lygio anotacija nurodo Spring karkasui, kad turėtų "atpažinti" konfigūraciją.
// Remiasi priklausomybėmis (JAR bibliotekomis), kurias programuotojas įtraukia į projektą (pom.xml)
// Šiuo atveju ji veikia kartu su main metodu.
//@EnableAutoConfiguration
public class CalculatorController {
    // Maršrutizavimo informacija. Šiuo atveju ji nurodo Spring karkasui,
    // kad visos HTTP užklausos, kurių kelias yra "/", bus apdorotos metodo home().
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(Model model) {
        // Jeigu modelis "number" nepavyksta praeiti validacijos - per jį grąžinamos validacijos klaidos į vaizdą (view).
        model.addAttribute("number", new Number());
        // Grąžiname JSP failą, jis turi būti talpinamas 'webapp -> WEB-INF -> jsp' kataloge
        return "calculator";
    }

    // Kadangi skaičiuotuvo forma naudoja POST metodą, čia taip pat nurodome POST.
//    @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    // Trumpesnis POST variantas
    @PostMapping("/calculate")
    // Naudotis @RequestParam reikia, kai raktai skiriasi nuo frontendo ir backend'o
    String calculate(@Valid @ModelAttribute("number") Number e, BindingResult br,
                     @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        if (br.hasErrors()) {
            return "calculator";
        } else {

            int number1 = Integer.parseInt(numbers.get("number1"));
            int number2 = Integer.parseInt(numbers.get("number2"));
            String operation = numbers.get("operation");

            System.out.println("Results: " + numbers.entrySet());
//    String calculate(int number1, int number2, String operation, ModelMap modelMap) {
            int result = switch (operation) {
                case "+" -> number1 + number2;
                case "-" -> number1 - number2;
                case "*" -> number1 * number2;
                case "/" -> number1 / number2;
                default -> 0;
            };

            // ModelMap objektas naudojamas siųsti reikšmes iš Spring MVC kontrolerio į JSP
            modelMap.put("number1", number1);
            modelMap.put("number2", number2);
            modelMap.put("operation", operation);
            modelMap.put("result", result);

            // prefiksas + jsp failo pavadinimas + sufiksas
            return "calculate";
        }
    }
}
