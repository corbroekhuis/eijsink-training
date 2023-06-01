package org.eijsink.annotations.testing.service;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static boolean isPositive(int a) {
        return a >= 0;
    }

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

}
