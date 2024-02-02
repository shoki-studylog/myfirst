package com.example.myfirst.app.survey;

import java.sql.Timestamp;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class SurveyForm {

    @Min(0)
    @Max(150)
    private int age;

    @Min(0)
    @Max(5)
    private int satisfaction;

    @Size(min = 1, max = 200)
    private String comment;

    private Timestamp created;

    public SurveyForm() {

    }

    public int getAge() {
        return age;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
