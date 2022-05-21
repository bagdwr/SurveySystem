package com.example.SurveySystem.Repository;

import com.example.SurveySystem.Model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Integer> {
    Survey getSurveyByName(String name);
    Survey getSurveyById(Integer id);
}
