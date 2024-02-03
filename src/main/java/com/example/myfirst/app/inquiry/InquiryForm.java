package com.example.myfirst.app.inquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//フォームクラス（HTMLで入力した値をformから送られて、このクラスのインスタンスで受け取る。）
public class InquiryForm {

    // バリデーション（最小値、最大値を制御、messageで独自のエラー文を定義）
    @Size(min = 1, max = 20, message = "Please input 20characters or less")
    private String name;

    // バリデーション（NotNull=nullを制限、Email=メールアドレスの形式かどうかチェックする、messageで独自のエラー文を定）
    @NotNull
    @Email(message = "Invalid E-mail Format")
    private String email;

    @NotNull
    private String contents;

    // Counstructer
    public InquiryForm() {
    }

    // Getter
    public String getContents() {
        return contents;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    // Setter
    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
