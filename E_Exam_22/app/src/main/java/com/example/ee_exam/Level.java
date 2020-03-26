package com.example.ee_exam;

public class Level {
    private int level_id;
    private String name;

    public Level(String name) {
        this.name = name;
    }

    public Level(int level_id, String name) {
        this.level_id = level_id;
        this.name = name;
    }

    public int getLevel_id() {
        return level_id;
    }

    public String getName() {
        return name;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Level{" +
                "level_id=" + level_id +
                ", name='" + name + '\'' +
                '}';
    }
}
