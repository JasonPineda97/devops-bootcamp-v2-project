package models;

import helpers.Grade;
import helpers.Score;

import java.util.List;

public class Student {
    private String code;
    private String name;
    private int age;
    private Grade grade;
    private Score score;

    private List<Subject> subjects;

    public Student(String name, int age, Grade grade) {
        this.code = "ST" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName(){return name;}

    public int getAge(){return age;}

    public Score getScore() {return score;}

    public void setGrade(Grade grade){this.grade = grade;}

    public Grade getGrade(){return grade;}

    public List<Subject> getSubjects(){return subjects;}
}
