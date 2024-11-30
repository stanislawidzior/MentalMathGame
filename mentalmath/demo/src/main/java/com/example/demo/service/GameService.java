package com.example.demo.service;

import com.example.demo.model.GameSettings;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameSetup testSetup;

    public GameService(GameSetup testSetup) {
        this.testSetup = testSetup;
    }

    public String generateResponse(GameSettings testSettings) {
        //validation
        testSetup.setGameSettings(testSettings);
        //testSetup.generateQuestions(testSettings);
        return "success";
    }


}
