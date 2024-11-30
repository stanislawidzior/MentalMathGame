package com.example.demo.controller;


import com.example.demo.model.Question;
import com.example.demo.model.GameSettings;
import com.example.demo.model.QuestionsSet;
import com.example.demo.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
    public class GameController {

        private final GameService testService;

        public GameController(GameService testService) {
            this.testService = testService;
        }
        @GetMapping("/hello")
        public String hello() {
            return "Hello World";
        }

        @GetMapping("/set")
        public ResponseEntity<?> startTest() {
            // You can configure TestSettings here based on user input
            GameSettings testSettings = new GameSettings();
            var operations = new ArrayList<String>();
            operations.add("addition");
            testSettings.setQuestionAmount(10,2,19);
            testSettings.setAllowedOperations(operations);
            return ResponseEntity.ok(testService.generateResponse(testSettings));
        }
    }

