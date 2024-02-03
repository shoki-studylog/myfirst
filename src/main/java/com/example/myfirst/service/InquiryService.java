package com.example.myfirst.service;

import java.util.List;

import com.example.myfirst.entity.Inquiry;

public interface InquiryService {

    void save(Inquiry inquiry);

    void update(Inquiry inquiry);

    List<Inquiry> geAll();
}
