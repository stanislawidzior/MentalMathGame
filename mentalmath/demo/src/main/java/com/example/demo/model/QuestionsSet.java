package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class QuestionsSet {
    List<Question> questions;
    public QuestionsSet() {
        questions = new ArrayList<Question>();
    }
    public void addQuestion(Question question) {
        questions.add(question);
    }

}
