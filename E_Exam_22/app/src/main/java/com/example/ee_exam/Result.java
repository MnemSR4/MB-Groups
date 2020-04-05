package com.example.ee_exam;

public class Result {
    private int student_id;
    private String subject_access_code;
    private  int marks;

    public Result( String subject_access_code, int marks) {
        this.subject_access_code = subject_access_code;
        this.marks = marks;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSubject_access_code() {
        return subject_access_code;
    }

    public void setSubject_access_code(String subject_access_code) {
        this.subject_access_code = subject_access_code;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Result{" +
                "student_id=" + student_id +
                ", subject_access_code='" + subject_access_code + '\'' +
                ", marks=" + marks +
                '}';
    }
}
