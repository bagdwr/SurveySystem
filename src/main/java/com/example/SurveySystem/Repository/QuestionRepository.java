package com.example.SurveySystem.Repository;

import com.example.SurveySystem.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question findQuestionById(Integer id);
    List<Question> findAll();
}
