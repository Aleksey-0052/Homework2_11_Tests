package ru.skyprotestshw2_11.service;

import org.springframework.stereotype.Service;
import ru.skyprotestshw2_11.exception.DivideByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int sum(int num1, int num2) {

        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {

        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {

        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {

        if (num2 == 0) {
            throw new DivideByZeroException ("Деление на 0 невозможно");
        }
        return num1 / num2;
    }
}
