package com.example.myfirst.dao;

import java.util.List;

import com.example.myfirst.entity.Inquiry;

public interface InquiryDao {

    void insertInquiry(Inquiry inquiry);

    List<Inquiry> getAll();
}
