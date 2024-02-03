package com.example.myfirst.service;

//独自例外（selectで一件も返ってこなかったら例外
public class InquiryNotFoundException extends RuntimeException {

    private static final long serialVersonUID = 1L;

    public InquiryNotFoundException(String message) {
        super(message);
    }
}
