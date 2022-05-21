package com.example.SurveySystem.Mapper;

import com.example.SurveySystem.Model.Survey;
import com.example.SurveySystem.Model.Users;
import com.example.SurveySystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyMapper implements RowMapper<Survey> {
    @Override
    public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
        Survey survey = new Survey();
        survey.setId(rs.getInt("id"));
        survey.setName(rs.getString("name"));
        survey.setUser(new Users(rs.getInt("user_id"),null,null,null,null));
        return null;
    }
}
