package com.example.SurveySystem.Mapper;

import com.example.SurveySystem.Model.Question;
import com.example.SurveySystem.Model.Survey;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionInsert implements ConnectionCallback<Void> {
    private Question question;

    public QuestionInsert(Question question) {
        this.question = question;
    }

    @Override
    public Void doInConnection(Connection con) throws SQLException, DataAccessException {
        try(PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO question(question_label, question_type, survey_id) values(?,?,?)")) {
            preparedStatement.setString(1,question.getLabel());
            preparedStatement.setString(2,question.getQuestionType().toString());
            preparedStatement.setInt(3,question.getSurvey().getId());
            preparedStatement.executeUpdate();
        }
        return null;
    }
}
