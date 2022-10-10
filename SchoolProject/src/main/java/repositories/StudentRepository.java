package repositories;

import helpers.Grade;
import models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public List<Student> getAllStudents() {
        return this.students;
    }

    public Student getStudentByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findAny().orElse(null);
    }

    public List<Student> readStudentsDataFromJsonByGrade(Grade grade) {
        return students.stream().filter(student -> student.getGrade() == grade).collect(Collectors.toList());
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public void modifyStudent(String code) {

    }
}
