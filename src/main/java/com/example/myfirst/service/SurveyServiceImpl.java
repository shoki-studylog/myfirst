package com.example.myfirst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myfirst.dao.SurveyDao;
import com.example.myfirst.entity.Survey;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyDao dao;

    @Autowired
    public SurveyServiceImpl(SurveyDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Survey survey) {

        dao.insertSurvey(survey);
    }

    @Override
    public List<Survey> geAll() {

        return dao.getAll();
    }

}
