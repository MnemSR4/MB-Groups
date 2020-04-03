package com.example.ee_exam.Model;

public class Professor {

    public String id;
    public String userName;
    public String email;
    public String subjectName;
    public String password;

    public Professor() {
    }

    public Professor(String id, String userName, String email, String subjectName, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.subjectName = subjectName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
