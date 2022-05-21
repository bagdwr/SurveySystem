package com.example.SurveySystem.Model;

import lombok.Getter;

@Getter
public enum QuestionType {
    ONE_ANSWER("one answer"),
    MANY_ANSWER("many answer"),
    OPEN_QUESTION("open question");

    private String label;

    QuestionType(String label) {
        this.label = label;
    }
}
