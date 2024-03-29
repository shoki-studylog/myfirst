package com.example.myfirst.app.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myfirst.entity.Survey;
import com.example.myfirst.service.SurveyService;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyService service;

    @Autowired
    public SurveyController(SurveyService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {

        List<Survey> list = service.geAll();
        model.addAttribute("title", "survey list");
        model.addAttribute("surveylist", list);

        return "survey/index";

    }

    // formにGETリクエストした場合（初期遷移時）
    @GetMapping("/form")
    public String form(SurveyForm surveyform, Model model, @ModelAttribute("complete") String complete) {

        model.addAttribute("title", "Survey Form");
        return "/survey/form";

    }

    // formにPOSTリクエストした時（戻るボタンクリック時）
    @PostMapping("/form")
    public String formGoBack(SurveyForm surveyForm, Model model) {
        model.addAttribute("title", "Survey Form");
        return "/survey/form";
    }

    // confirmにPOSTリクエストした時（formから確認ボタンクリック時）
    @PostMapping("/confirm")
    public String confirm(@Validated SurveyForm surveyForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Survey Form");
            return "/survey/form";
        }
        model.addAttribute("title", "Survey Form");
        return "/survey/confirm";
    }

    @PostMapping("/complete")
    public String complete(@Validated SurveyForm surveyForm, BindingResult result,
            RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Survey Form");
            return "/survey/form";
        }
        Survey survey = new Survey();
        survey.setAge(surveyForm.getAge());
        survey.setSatisfaction(survey.getSatisfaction());
        survey.setComment(surveyForm.getComment());
        survey.setCreated(surveyForm.getCreated());

        service.save(survey);

        redirectAttributes.addFlashAttribute("complete", "Registered!");

        return "redirect:/survey/form";
    }

}
