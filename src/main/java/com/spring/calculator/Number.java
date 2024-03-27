package com.spring.calculator;

import jakarta.validation.constraints.Min;

public class Number {
    @Min(value = 0, message = "Validation error: Number cannot be negative.")
    private int number1;
    @Min(value = 0, message = "Validation error: Number cannot be negative")
    private int number2;
    private String operation;
    private int result;

    public Number(int number1, int number2, String operation, int result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    public Number() {
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
