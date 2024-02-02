package com.example.myfirst.service;

import java.util.List;

import com.example.myfirst.entity.Survey;

public interface SurveyService {

    void save(Survey survey);

    List<Survey> geAll();
}
