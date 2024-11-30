package com.example.demo.service;
import com.example.demo.model.GameSettings;
import com.example.demo.model.IPrepareQuestion;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameSetup {
    private List<Question> questionsSet = new ArrayList<Question>();
    private List<IPrepareQuestion> prepareQuestion = new ArrayList<>();
    private GameSettings testSettings;

    public GameSetup() {
    }
    public void generateQuestions(GameSettings testSettings) {
        this.testSettings = testSettings;
        for (int i = 0; i < testSettings.getQuestionAmount(); i++) {
            prepareQuestion.add(randomOperationPrepareQuestion());
        }
        for (var prepareQuestion : prepareQuestion) {
            questionsSet.add(prepareQuestion.prepareQuestion(testSettings.getMinNumber(), testSettings.getMaxNumber()));
        }
    }
    public List<Question> getQuestionSet(){
            return questionsSet;
        }
        public void setGameSettings(GameSettings gameSettings){
        this.testSettings = gameSettings;
        }
        public GameSettings getGameSettings(){
        return testSettings;
        }
private IPrepareQuestion randomOperationPrepareQuestion() {
       var randomGenerator = new Random();
       var randomNumber = randomGenerator.nextInt(0,testSettings.getAllowedOperations().size()); //it's an array containg all options
        return QuestionFactory.getOperation(testSettings.getAllowedOperations().get(randomNumber));
    }

}
