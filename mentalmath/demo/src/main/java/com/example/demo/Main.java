package com.example.demo;

import com.example.demo.model.GameSettings;
import com.example.demo.service.GameSetup;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameSettings testSettings = new GameSettings();
        List<String> operations = new ArrayList<>();
        operations.add("addition");
        testSettings.setAllowedOperations(operations);
        testSettings.setQuestionAmount(10,2,19);
        GameSetup testSetup = new GameSetup();
        testSetup.generateQuestions(testSettings);

    }
}
