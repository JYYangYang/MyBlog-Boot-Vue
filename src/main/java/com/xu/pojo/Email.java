package com.xu.pojo;

public class Email {
    private String name;
    private String TheEmail;
    private String content;

    public Email(String name, String theEmail, String content) {
        this.name = name;
        TheEmail = theEmail;
        this.content = content;
    }

    public Email() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTheEmail() {
        return TheEmail;
    }

    public void setTheEmail(String theEmail) {
        TheEmail = theEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Email{" +
                "name='" + name + '\'' +
                ", title='" +
                ", TheEmail='" + TheEmail + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
