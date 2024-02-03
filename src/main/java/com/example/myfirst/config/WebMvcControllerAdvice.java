package com.example.myfirst.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.myfirst.service.InquiryNotFoundException;

/**
 * 全てのControllerで共通処理を定義（各メソッドを読み込む前のタイミングで共通処理は実行される）
 */
@ControllerAdvice
public class WebMvcControllerAdvice {

    /*
     * This method changes empty character to null
     * こちらのメソッドを用意しておくと送信された空文字はnullに変換されます
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    // @ExceptionHandlerアノテーションを付与すると、引数に指定した例外が発生した場合にメソッドが実行される
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleException(EmptyResultDataAccessException e, Model model) {
        model.addAttribute("message", e);
        return "error/CustomPage";
    }

    // 全てのコントローラーで例外が発生した時に下記メソッドが実行される。
    @ExceptionHandler(InquiryNotFoundException.class)
    public String hadleException(InquiryNotFoundException e, Model model) {
        model.addAttribute("message", e);
        return "error/CustomPage";
    }

}