package services;

import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

public class AccessValidator {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public AccessValidator(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public Student verifyStudentAccess(String code) {
        System.out.println("size: " + this.studentRepository.getAllStudents().size());
        return this.studentRepository.getStudentByCode(code);
    }

    public Teacher verifyTeacherAccess(String code) {
        System.out.println("size: " + this.teacherRepository.getAllTeachers().size());
        return this.teacherRepository.getTeacherByCode(code);
    }
}
