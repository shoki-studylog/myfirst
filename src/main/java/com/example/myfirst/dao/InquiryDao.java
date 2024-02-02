package com.example.myfirst.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.myfirst.entity.Inquiry;

@Component
public interface InquiryDao {

    void insertInquiry(Inquiry inquiry);

    List<Inquiry> getAll();
}
