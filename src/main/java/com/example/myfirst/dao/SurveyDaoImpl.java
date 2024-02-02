package com.example.myfirst.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.myfirst.entity.Survey;

@Repository
public class SurveyDaoImpl implements SurveyDao {

    private final JdbcTemplate jdbcTemplate;

    public SurveyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertSurvey(Survey survey) {

        String sql = "INSERT INTO survey(age, comment, satisfaction, created) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, survey.getAge(), survey.getComment(), survey.getSatisfaction(), "2019-02-18 22:35:54");
    }

    @Override
    public List<Survey> getAll() {

        String sql = "SELECT id, age, satisfaction, comment, created FROM survey";

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        List<Survey> list = new ArrayList<>();

        for (Map<String, Object> result : resultList) {
            Survey survey = new Survey();

            survey.setId((int) result.get("id"));
            survey.setAge((int) result.get("age"));
            survey.setSatisfaction((int) result.get("satisfaction"));
            survey.setComment((String) result.get("comment"));
            survey.setCreated((Timestamp) result.get("created"));
            list.add(survey);
        }

        return list;

    }

}
