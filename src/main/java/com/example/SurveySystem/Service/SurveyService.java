package com.example.SurveySystem.Service;

import com.example.SurveySystem.Model.Survey;

public interface SurveyService {
    Survey getSurveyByName(String name);
    Survey getSurveyById(Integer id);
    int saveSurvey(Survey survey);
}
