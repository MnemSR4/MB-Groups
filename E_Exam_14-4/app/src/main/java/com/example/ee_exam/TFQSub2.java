package com.example.ee_exam;

public class TFQSub2 {

    private int id;
    private String question;
    private String answer;

    public TFQSub2(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public TFQSub2 (String question, String answer) {
        this.question = question;
        this.answer = answer;
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
