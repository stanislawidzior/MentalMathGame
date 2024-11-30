package com.example.demo.model;

import java.time.LocalDateTime;

public class Question {
    private double numberA;
    private double numberB;
    private LocalDateTime timeSeen;
    private LocalDateTime timeAnswered;
    private Operations operation;


    public Question(double numberA, double numberB){
        this.numberA = numberA;
        this.numberB = numberB;
    }
    public void setOperation(Operations operation) {
        this.operation = operation;
    }


    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public LocalDateTime getTimeSeen() {
        return timeSeen;
    }

    public void setTimeSeen(LocalDateTime timeSeen) {
        this.timeSeen = timeSeen;
    }

    public LocalDateTime getTimeAnswered() {
        return timeAnswered;
    }

    public void setTimeAnswered(LocalDateTime timeAnswered) {
        this.timeAnswered = timeAnswered;
    }

    public Operations getOperation() {
        return operation;
    }
}
