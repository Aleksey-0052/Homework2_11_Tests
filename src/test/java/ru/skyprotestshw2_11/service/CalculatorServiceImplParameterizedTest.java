package ru.skyprotestshw2_11.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    private static final int POSITIV_VALUE = 50;
    private static final int NEGATIV_VALUE = -5;
    private static final int ZERO = 0;

    public static Stream<Arguments> sumCases() {
        return Stream.of(
                Arguments.of(POSITIV_VALUE, POSITIV_VALUE, POSITIV_VALUE + POSITIV_VALUE),
                Arguments.of(NEGATIV_VALUE, NEGATIV_VALUE, NEGATIV_VALUE + NEGATIV_VALUE),
                Arguments.of(POSITIV_VALUE, NEGATIV_VALUE, POSITIV_VALUE + NEGATIV_VALUE),
                Arguments.of(ZERO, POSITIV_VALUE, ZERO + POSITIV_VALUE),
                Arguments.of(ZERO, NEGATIV_VALUE, ZERO + NEGATIV_VALUE)
        );
    }

    public static Stream<Arguments> subtractCases() {
        return Stream.of(
                Arguments.of(POSITIV_VALUE, POSITIV_VALUE, POSITIV_VALUE - POSITIV_VALUE),
                Arguments.of(NEGATIV_VALUE, NEGATIV_VALUE, NEGATIV_VALUE - NEGATIV_VALUE),
                Arguments.of(POSITIV_VALUE, NEGATIV_VALUE, POSITIV_VALUE - NEGATIV_VALUE),
                Arguments.of(ZERO, POSITIV_VALUE, ZERO - POSITIV_VALUE),
                Arguments.of(NEGATIV_VALUE, ZERO, NEGATIV_VALUE - ZERO)
        );

    }

    public static Stream<Arguments> multiplyCases() {
        return Stream.of(
                Arguments.of(POSITIV_VALUE, POSITIV_VALUE, POSITIV_VALUE * POSITIV_VALUE),
                Arguments.of(NEGATIV_VALUE, NEGATIV_VALUE, NEGATIV_VALUE * NEGATIV_VALUE),
                Arguments.of(POSITIV_VALUE, NEGATIV_VALUE, POSITIV_VALUE * NEGATIV_VALUE),
                Arguments.of(ZERO, POSITIV_VALUE, ZERO * POSITIV_VALUE),
                Arguments.of(ZERO, NEGATIV_VALUE, ZERO * NEGATIV_VALUE)
        );
    }

    public static Stream<Arguments> divideCases() {
        return Stream.of(
                Arguments.of(POSITIV_VALUE, POSITIV_VALUE, POSITIV_VALUE / POSITIV_VALUE),
                Arguments.of(NEGATIV_VALUE, NEGATIV_VALUE, NEGATIV_VALUE / NEGATIV_VALUE),
                Arguments.of(POSITIV_VALUE, NEGATIV_VALUE, POSITIV_VALUE / NEGATIV_VALUE),
                Arguments.of(ZERO, POSITIV_VALUE, ZERO / POSITIV_VALUE),
                Arguments.of(ZERO, NEGATIV_VALUE, ZERO / NEGATIV_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("sumCases")
    void sumParams(int num1, int num2, int expected) {
        int result = calculatorService.sum(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("subtractCases")
    void subtractParams(int num1, int num2, int expected) {
        int result = calculatorService.subtract(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("multiplyCases")
    void multiplyParams(int num1, int num2, int expected) {
        int result = calculatorService.multiply(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("divideCases")
    void divideParams(int num1, int num2, int expected) {
        int result = calculatorService.divide(num1, num2);
        assertEquals(expected, result);
    }
}