package com.example.SurveySystem.Service.Impl;

import com.example.SurveySystem.Mapper.SurveyMapper;
import com.example.SurveySystem.Model.Survey;
import com.example.SurveySystem.Repository.SurveyRepository;
import com.example.SurveySystem.Service.SurveyService;
import com.example.SurveySystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final JdbcTemplate jdbcTemplate;
    private final UserService userService;
    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(JdbcTemplate jdbcTemplate, UserService userService, SurveyRepository surveyRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userService = userService;
        this.surveyRepository = surveyRepository;
    }


    @Override
    public Survey getSurveyByName(String name) {
        return surveyRepository.getSurveyByName(name);
    }

    @Override
    public Survey getSurveyById(Integer id) {
        return surveyRepository.getSurveyById(id);

    }

    @Override
    public int saveSurvey(Survey survey) {
        if (Objects.equals(survey.getUser().getId(),(userService.getUserById(survey.getUser().getId())).getId())){
            return jdbcTemplate.update("INSERT INTO Survey(name,user_id) values (?,?)",survey.getName(),survey.getUser().getId());
        }

        return -1;
    }

    @PostConstruct
    void addTestValues(){
        List<Survey> surveyList = new ArrayList<>();
        surveyList.add(new Survey(null,"Java test", userService.getUserById(1)));
        surveyList.add(new Survey(null,"Math test", userService.getUserById(2)));
        surveyList.add(new Survey(null,"Contest", userService.getUserById(3)));

        for (Survey survey : surveyList) {
            saveSurvey(survey);
        }
    }
}
