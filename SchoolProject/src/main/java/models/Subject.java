package models;

import helpers.Grade;

public class Subject {
    private String name;
    private String teacher;
    private Grade grade;

    public Subject(String name, String teacher, Grade grade) {
        this.name = name;
        this.teacher = teacher;
        this.grade = grade;
    }

    public String getName(){return this.name;}

    public Grade getGrade(){return this.grade;}
}
