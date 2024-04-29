package com.spring.calculator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "numbers")
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_id")
    private int id;

    @Min(value = 0, message = "Validation error: Number cannot be negative.")
    @Column(name = "number1")
    private int number1;

    @Min(value = 0, message = "Validation error: Number cannot be negative")
    @Column(name = "number2")
    private int number2;

    @Column(name = "operation")
    private String operation;

    @Column(name = "result")
    private int result;

    public Number(int id, int number1, int number2, String operation, int result) {
        this.id = id;
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    public Number(int number1, int number2, String operation, int result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    public Number() {
    }
    // Needed to link numbers from backend to frontend

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", number1=" + number1 +
                ", number2=" + number2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
