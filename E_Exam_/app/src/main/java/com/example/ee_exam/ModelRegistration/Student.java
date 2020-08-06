package com.example.ee_exam.ModelRegistration;

public class Student {



    public String id;
    public String userName;
    public String email;
    public String password;
    public String option_level;
    public String option_depatment;

    public Student() {
    }

    public Student(String id, String userName, String email, String password, String option_level, String option_depatment) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.option_level = option_level;
        this.option_depatment = option_depatment;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOption_level() {
        return option_level;
    }

    public void setOption_level(String option_level) {
        this.option_level = option_level;
    }

    public String getOption_depatment() {
        return option_depatment;
    }

    public void setOption_depatment(String option_depatment) {
        this.option_depatment = option_depatment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", option_level='" + option_level + '\'' +
                ", option_depatment='" + option_depatment + '\'' +
                '}';
    }
}
