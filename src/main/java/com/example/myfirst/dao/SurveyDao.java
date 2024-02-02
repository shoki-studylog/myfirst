package com.example.myfirst.dao;

import java.util.List;

import com.example.myfirst.entity.Survey;

public interface SurveyDao {

    void insertSurvey(Survey survey);

    List<Survey> getAll();
}
