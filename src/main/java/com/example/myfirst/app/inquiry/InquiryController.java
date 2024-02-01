package com.example.myfirst.app.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @GetMapping("/form")
    public String form(InquiryForm inquiryform, Model model) {
        model.addAttribute("title", "Inquiry Form");
        return "inquiry/form";

    }

    @PostMapping("/form")
    public String formGoBack(InquiryForm inquiryform, Model model) {
        model.addAttribute("title", "Inquiry Form");
        return "inquiry/form";

    }

    @PostMapping("/confirm")
    public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Inquiry Form");
            return "inquiry/form";
        }

        model.addAttribute("title", "Confirm Page");

        return "inquiry/confirm";
    }

}
