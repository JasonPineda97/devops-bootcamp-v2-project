package repositories;

import models.Subject;
import models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private List<Subject> subjects;

    public SubjectRepository() {
        this.subjects = new ArrayList<>();
    }

    public List<Subject> getAllSubjects() {
        return this.subjects;
    }

    public void addSubject(Subject s) {this.subjects.add(s);}
}
