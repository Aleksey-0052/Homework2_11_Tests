package ru.skyprotestshw2_11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skyprotestshw2_11.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {

        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String showGreetings() {

        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.sum(num1, num2);
        return createRs(num1, num2, '+', result);

    }
    @GetMapping("/minus")
    public String subtract(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.subtract(num1, num2);
        return createRs(num1, num2, '-', result);

    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1, num2);
        return createRs(num1, num2, '*', result);

    }
    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.divide(num1, num2);
        return createRs(num1, num2, '/', result);

    }

    private String createRs(int num1, int num2, char action, int result) {
        return String.format("%d %c %d = %d", num1, action, num2, result);
    }

    // используем String.format, чтобы по определенному паттерну получить ответ
    // формат "%d %c %d = %d", где %d - целое число, %с - char
    // после формата указываем аргументы, которые перейдут в формат в соответствующие символы

}
