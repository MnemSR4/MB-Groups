package com.example.ee_exam;

public class Subject {

    private int subject_id;
    private String name;
    private String access_code;
    private int department_id;

    public Subject(int subject_id, String name, String access_code, int department_id) {
        this.subject_id = subject_id;
        this.name = name;
        this.access_code = access_code;
        this.department_id = department_id;
    }

    public Subject(String name, String access_code, int department_id) {
        this.name = name;
        this.access_code = access_code;
        this.department_id = department_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getAccess_code() {
        return access_code;
    }

    public void setAccess_code(String access_code) {
        this.access_code = access_code;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subject_id +
                ", name='" + name + '\'' +
                ", access_code='" + access_code + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
