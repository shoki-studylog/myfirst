package com.example.myfirst.app.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SurveyController {

    // formにGETリクエストした場合（初期遷移時）
    @GetMapping("/survey/form")
    public String form(SurveyForm surveyform, Model model) {

        model.addAttribute("title", "Survey Form");
        return "/survey/form";

    }

    // formにPOSTリクエストした時（戻るボタンクリック時）
    @PostMapping("/survey/form")
    public String formGoBack(SurveyForm surveyForm, Model model) {
        model.addAttribute("title", "Survey Form");
        return "/survey/form";
    }

    // confirmにPOSTリクエストした時（formから確認ボタンクリック時）
    @PostMapping("/survey/confirm")
    public String confirm(@Validated SurveyForm surveyForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Survey Form");
            return "/survey/form";
        }
        model.addAttribute("title", "Survey Form");
        return "/survey/confirm";
    }

    @PostMapping("/survey/complete")
    public String complete(@Validated SurveyForm surveyForm, BindingResult result,
            RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Survey Form");
            return "/survey/form";
        }

        redirectAttributes.addFlashAttribute("complete", "Registered!");

        return "redirect:/survey/form";
    }

}
