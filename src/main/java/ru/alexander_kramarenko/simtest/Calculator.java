package ru.alexander_kramarenko.simtest;

public class Calculator {

    @TestAdd
    public static int add(int a, int b) {
        return a + b; }

    @TestDiv
    public static int div(int a, int b) {
        return a / b; }

    @TestMul
    public static int mult(int a, int b) {
        return a * b;
    }

    @TestSub
    public static int sub(int a, int b) {
        return a - b;
    }
}
