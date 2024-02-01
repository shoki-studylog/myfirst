package com.example.myfirst.app.inquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InquiryForm {

    @Size(min = 1, max = 20, message = "Please input 20characters or less")
    private String name;

    @NotNull
    @Email(message = "Invalid E-mail Format")
    private String email;

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
