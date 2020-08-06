package com.example.ee_exam;

import java.security.PrivateKey;

public class TrueFalseQuestion {
    private int id;
    private String subject_access_code;
    private String question;
    private String answer;

    public TrueFalseQuestion(int id,String subject_access_code, String question, String answer) {
        this.id = id;
        this.subject_access_code = subject_access_code;
        this.question = question;
        this.answer = answer;
    }

    public TrueFalseQuestion(String subject_access_code,String question, String answer) {
        this.subject_access_code = subject_access_code;
        this.question = question;
        this.answer = answer;
    }

    public TrueFalseQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getSubject_access_code() {
        return subject_access_code;
    }

    public void setSubject_access_code(String subject_access_code) {
        this.subject_access_code = subject_access_code;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "TrueFalseQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
