package ru.skyprotestshw2_11.service;

import org.junit.jupiter.api.Test;
import ru.skyprotestshw2_11.exception.DivideByZeroException;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    private final int POSITIV_VALUE = 20;
    private final int NEGATIV_VALUE = -5;
    private final int ZERO = 0;



    @Test
    void sum1() {
        int result = calculatorService.sum(POSITIV_VALUE, POSITIV_VALUE);
        assertEquals(POSITIV_VALUE + POSITIV_VALUE, result);
    }

    @Test
    void sum2() {
        int result = calculatorService.sum(NEGATIV_VALUE, POSITIV_VALUE);
        assertEquals(NEGATIV_VALUE + POSITIV_VALUE, result);
    }

    @Test
    void subtract1() {
        int result = calculatorService.subtract(NEGATIV_VALUE, NEGATIV_VALUE);
        assertEquals(NEGATIV_VALUE - NEGATIV_VALUE, result);
    }

    @Test
    void subtract2() {
        int result = calculatorService.subtract(NEGATIV_VALUE, POSITIV_VALUE);
        assertEquals(NEGATIV_VALUE - POSITIV_VALUE, result);
    }

    @Test
    void multiply1() {
        int result = calculatorService.multiply(POSITIV_VALUE, NEGATIV_VALUE);
        assertEquals(POSITIV_VALUE * NEGATIV_VALUE, result);
    }

    @Test
    void multiply2() {
        int result = calculatorService.multiply(NEGATIV_VALUE, NEGATIV_VALUE);
        assertEquals(NEGATIV_VALUE * NEGATIV_VALUE, result);
    }

    @Test
    void divide1() {
        int result = calculatorService.divide(NEGATIV_VALUE, NEGATIV_VALUE);
        assertEquals(NEGATIV_VALUE / NEGATIV_VALUE, result);
    }

    @Test
    void divide2() {
        int result = calculatorService.divide(ZERO, NEGATIV_VALUE);
        assertEquals(ZERO / NEGATIV_VALUE, result);
    }

    @Test
    void divideByZero() {
        assertThrows(DivideByZeroException.class,                        // ожидаем получить исключение
                () -> calculatorService.divide(POSITIV_VALUE, ZERO));    // при выполнении этого кода
    }
    
}