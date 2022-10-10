package ua.bizbiz.springpractise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.bizbiz.springpractise.ActionType;

@Controller
@RequestMapping("/first")
public class FirstController {
    private double result;
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);
//        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator/{action}")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @PathVariable(value = "action", required = false) ActionType action,
                             Model model) {

        switch (action) {
            case MULTIPLICATION:
                result = a * b;
                break;
            case ADDITION:
                result = a + b;
                break;
            case SUBTRACTION:
                result = a - b;
                break;
            case DIVISION:
                result = a / (double) b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("Value", "Result of operation: " + result);
        return "first/calculator";
    }
}
