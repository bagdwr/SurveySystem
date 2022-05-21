package com.example.SurveySystem.Service.Impl;

import com.example.SurveySystem.Model.Question;
import com.example.SurveySystem.Repository.QuestionRepository;
import com.example.SurveySystem.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question findQuestionById(Integer id) {
        return questionRepository.findQuestionById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question saveQuestion(Question question) {
        if(question!=null){
            return questionRepository.save(question);
        }
        return null;
    }

    @PostConstruct
    void addFakeData(){

    }
}
