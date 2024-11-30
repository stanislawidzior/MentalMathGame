package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameSettings {
    private int QuestionAmount;
    private List<String> allowedOperations = new ArrayList<>();
    private int minNumber;
    private int maxNumber;
    private final int minQuestionNumber = 0;
    private final int maxQuestionNumber = 100;

    public GameSettings() {
    }
    public void setQuestionAmount(int questionAmount, int minNumber, int maxNumber) {
        QuestionAmount = questionAmount;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }
    public void setAllowedOperations(List<String> allowedOperations) {
        this.allowedOperations = allowedOperations;
    }
    private void checkConstraints(int questionAmount) {
        if (questionAmount <= minQuestionNumber || questionAmount >= maxQuestionNumber) {
            throw new IllegalArgumentException("QuestionAmount must be greater than 0");
        }
    }
    public int getMinNumber() {
        return minNumber;
    }
    public int getMaxNumber() {
        return maxNumber;
    }
    public int getQuestionAmount() {
        return QuestionAmount;
    }
    public List<String> getAllowedOperations() {
        return allowedOperations;
    }






}
