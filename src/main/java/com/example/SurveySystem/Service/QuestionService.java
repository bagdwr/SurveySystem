package com.example.SurveySystem.Service;

import com.example.SurveySystem.Model.Question;

import java.util.List;

public interface QuestionService {
    Question findQuestionById(Integer id);
    List<Question> findAll();
    Question saveQuestion(Question question);
}
