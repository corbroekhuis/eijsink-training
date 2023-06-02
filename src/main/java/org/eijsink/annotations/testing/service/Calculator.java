package org.eijsink.annotations.testing.service;

public class Calculator {

    static int power = 100;

    public static void reCharge(){
        System.out.println("Recharging....");
        power = 100;
    }

    public static int add(int a, int b) {
        power = power - 30;
        return a + b;
    }

    public static int subtract(int a, int b) {
        power = power - 30;
        return a - b;
    }

    public static int multiply(int a, int b) {
        power = power - 30;
        return a * b;
    }

    public static boolean isPositive(int a) {
        power = power - 30;
        return a >= 0;
    }

    public static boolean isEven(int a) {
        power = power - 30;
        return a % 2 == 0;
    }

}
