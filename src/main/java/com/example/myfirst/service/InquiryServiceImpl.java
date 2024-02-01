package com.example.myfirst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myfirst.dao.InquiryDao;
import com.example.myfirst.entity.Inquiry;

//@Serviceアノテーションを付与することで、DIコンテナで自動的にシングルトンとしてインスタンスを生成してくれる
@Service
public class InquiryServiceImpl implements InquiryService {

    private final InquiryDao dao;

    @Autowired
    public InquiryServiceImpl(InquiryDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Inquiry inquiry) {
        dao.insertInquiry(inquiry);
    }

    @Override
    public List<Inquiry> geAll() {
        return dao.getAll();
    }

}
