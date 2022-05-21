package com.example.SurveySystem.Service.Impl;

import com.example.SurveySystem.Model.Question;
import com.example.SurveySystem.Model.QuestionType;
import com.example.SurveySystem.Repository.QuestionRepository;
import com.example.SurveySystem.Repository.SurveyRepository;
import com.example.SurveySystem.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, SurveyRepository surveyRepository, JdbcTemplate jdbcTemplate) {
        this.questionRepository = questionRepository;
        this.surveyRepository = surveyRepository;
        this.jdbcTemplate = jdbcTemplate;
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
    public int saveQuestion(Question question) {
        if(question!=null){
            return jdbcTemplate.update("INSERT INTO question(question_label, question_type, survey_id) values (?,?,?)",question.getLabel(),question.getQuestionType().getLabel(),question.getSurvey().getId());
//            try(Connection connection = jdbcTemplate.getDataSource().getConnection()) {
//                connection.setAutoCommit(false);
//                    try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO question(question_label, question_type, survey_id) values(?,?,?)")) {
//                        if(Batch.count< Batch.batchSize) {
//                            preparedStatement.setString(1,question.getLabel());
//                            preparedStatement.setString(2,question.getQuestionType().toString());
//                            preparedStatement.setInt(3,question.getSurvey().getId());
//                            preparedStatement.addBatch();
//                            Batch.count++;
//                        }else {
//                            preparedStatement.executeBatch();
//                            connection.commit();
//                            Batch.count=0;
//                        }}
//                connection.setAutoCommit(true);

//                try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO question(question_label, question_type, survey_id) values(?,?,?)")) {
//                        preparedStatement.setString(1,question.getLabel());
//                        preparedStatement.setString(2,question.getQuestionType().toString());
//                        preparedStatement.setInt(3,question.getSurvey().getId());
//                        preparedStatement.executeUpdate();
//                }
//            }catch (Exception ex){
//                throw new RuntimeException(ex);
//            }
        }
        return -1;
    }

    @PostConstruct
    void addFakeData(){
//            List<Question> questions = new ArrayList<>();
//            questions.add(new Question(null,"Сколько вам лет?", QuestionType.ONE_ANSWER,surveyRepository.getSurveyById(1)));
//            questions.add(new Question(null,"Как вас зовут?", QuestionType.OPEN_QUESTION,surveyRepository.getSurveyById(1)));
//
//        for (Question question : questions) {
//            saveQuestion(question);
//        }
    }
}
