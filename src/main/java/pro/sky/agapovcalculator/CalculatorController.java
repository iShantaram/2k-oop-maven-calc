package pro.sky.agapovcalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(path = "/calculator")
@RestController
public class CalculatorController {
    private final String PRIVETSTVIE = "Добро пожаловать в калькулятор!";
    private final String DIVIDE_BY_ZERO = "Ошибка! Деление на 0 невозможно!";
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return PRIVETSTVIE;
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + " + " + b + " = " + calculatorService.plus(a, b);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        if (b == 0) {
            return DIVIDE_BY_ZERO;
        } else {
            return a + " / " + b + " = " + calculatorService.divide(a, b);
        }
    }
}
