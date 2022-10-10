package repositories;

import models.Student;
import models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    public List<Teacher> getAllTeachers() {
        return this.teachers;
    }

    public Teacher getTeacherByCode(String code) {
        return teachers.stream().filter(teacher -> teacher.getCode().equals(code)).findAny().orElse(null);
    }

    public void addTeacher(Teacher t) {this.teachers.add(t);}
}
