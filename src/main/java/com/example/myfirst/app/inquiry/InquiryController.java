package com.example.myfirst.app.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
// /inquiryにリクエストが来た時にこのクラスに処理を渡す
@RequestMapping("/inquiry")
public class InquiryController {

    // inquiry/formにGETリクエストが来た時にこのメソッドが実行される
    @GetMapping("/form")
    // 引数のInquiryForm inquiryformは、HTMLでの入力値を受け取るために使用する。
    // 引数のModel
    // modelはaddAttributeすることで、HTML側に値を送ることが出来る。（titleというキーでInquiryFormを送っている）
    // 引数の@ModelAttribute("フラッシュスコープで定義したキー") 受け取る型
    // 変数名は、フラッシュスコープの値をHTMLでレンダリングすることができる。
    public String form(InquiryForm inquiryform, Model model, @ModelAttribute("complete") String complete) {
        model.addAttribute("title", "Inquiry Form");
        return "inquiry/form";

    }

    // inquiry/formにPOSTリクエストが来た時にこのメソッドが実行される
    // 引数にInquiryForm
    // inquiryformを取ることで、InquiryFormに値が入っていた場合にフィールド値を使用することができる（ここでは戻るボタン押下時にフォームに入力しておくため）
    @PostMapping("/form")
    public String formGoBack(InquiryForm inquiryform, Model model) {
        model.addAttribute("title", "Inquiry Form");
        return "inquiry/form";

    }

    @PostMapping("/confirm")
    // InquiryForm inquiryformを持っているのは、入力値を確認フォームに表示させるため。
    // @Validatedアノテーションをフォームクラスに付与すると、バリデーションチェック時にエラーが発生したかどうかをBindingResult型で受け取ることができる。（true/falseで入る。）
    public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Inquiry Form");
            return "inquiry/form";
        }

        model.addAttribute("title", "Confirm Page");

        return "inquiry/confirm";
    }

    @PostMapping("/complete")
    public String completeString(@Validated InquiryForm inquiryForm,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Inquiry Form");
            return "inquiry/form";
        }
        // この値が一度使用されると破棄される。→フラッシュスコープ
        redirectAttributes.addFlashAttribute("complete", "Registered!");

        // これは、htmlを指しているわけではなく、URLを表している。（リダイレクト時のURL)
        return "redirect:/inquiry/form";
    }

}
