package com.example.e_exam_database;

public class Department {
    private int department_id;
    private String department_name;
    private int level_id;

    public Department(String department_name, int level_id) {
        this.department_name = department_name;
        this.level_id = level_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", level_id=" + level_id +
                '}';
    }
}
