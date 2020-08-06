package com.example.ee_exam;

public class Result {
    private String student_name;
    private String subject_access_code;
    private  int marks;

    public Result( String subject_access_code, int marks) {
        this.subject_access_code = subject_access_code;
        this.marks = marks;
    }

    public Result(String student_name, String subject_access_code, int marks) {
        this.student_name = student_name;
        this.subject_access_code = subject_access_code;
        this.marks = marks;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_name;
    }

    public void setStudent_id(String student_id) {
        this.student_name = student_id;
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


                "student_id=" + student_name +
                ", subject_access_code='" + subject_access_code + '\'' +
                ", marks=" + marks +
                '}';
    }
}
