package com.example.SurveySystem.Mapper;

import com.example.SurveySystem.Model.Question;
import com.example.SurveySystem.Model.QuestionType;
import com.example.SurveySystem.Model.Survey;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setLabel(rs.getString("question_label"));
        question.setQuestionType(QuestionType.valueOf(rs.getString("question_type")));
        question.setSurvey(new Survey(rs.getInt("id"),null,null));
        return question;
    }
}
