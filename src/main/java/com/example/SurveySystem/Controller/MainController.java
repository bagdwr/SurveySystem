package com.example.SurveySystem.Controller;

import com.example.SurveySystem.Model.Survey;
import com.example.SurveySystem.Service.QuestionService;
import com.example.SurveySystem.Service.SurveyService;
import com.example.SurveySystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final UserService userService;

    @Autowired
    public MainController(SurveyService surveyService, QuestionService questionService, UserService userService) {
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.userService = userService;
    }

    @GetMapping(value = "/getSurveyById/{id}")
    public ResponseEntity getSurveyById(
            @PathVariable(name = "id") Integer id
    ){
        Survey survey = surveyService.getSurveyById(id);
        if (survey!=null){
            return new ResponseEntity(survey, HttpStatus.OK);
        }
        return new ResponseEntity("Null",HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/getSurveyByName")
    public ResponseEntity getSurveyById(
            @RequestParam(name = "name") String name
    ){
        Survey survey = surveyService.getSurveyByName(name);
        if (survey!=null){
            return new ResponseEntity(survey, HttpStatus.OK);
        }
        return new ResponseEntity("Null",HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/createSurvey")
    public ResponseEntity createSurvey(
            @RequestParam(name = "name")String name,
            @RequestParam(name = "user_id") Integer user_id
    ){
        Survey survey = new Survey(null,name,userService.getUserById(user_id));
        int k = surveyService.saveSurvey(survey);
        if (k!=-1){
            return new ResponseEntity("created",HttpStatus.OK);
        }
        return new ResponseEntity("not done",HttpStatus.BAD_REQUEST);
    }
}
