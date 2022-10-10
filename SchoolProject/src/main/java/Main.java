import helpers.Grade;
import models.School;
import models.Student;
import models.Subject;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.AccessValidator;
import services.ReadDataService;
import services.WriteDataService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();

        ReadDataService readDataService = new ReadDataService();
        var students = readDataService.readStudentsDataFromJson();
        var teachers = readDataService.readTeachersDataFromJson();
        WriteDataService writeDataService = new WriteDataService(studentRepository, teacherRepository);
        writeDataService.writeStudentsDataToRepository(students);
        writeDataService.writeTeacherDataToRepository(teachers);

        Scanner scanner = new Scanner(System.in);
        var school = new School("American School");

        System.out.println("=============================");
        System.out.println("Welcome to " + school.getName());
        System.out.println("=============================");

        System.out.println("Select your role please: ");
        System.out.println("1. Teacher");
        System.out.println("2. Student");

        String option = scanner.nextLine();
        boolean access = false;

        while (!access) {
            System.out.println("Please enter your code");
            AccessValidator accessValidator = new AccessValidator(studentRepository, teacherRepository);

            String code = scanner.nextLine();

            switch (option) {
                case "1":
                    var teacher = accessValidator.verifyTeacherAccess(code);
                    if (teacher != null) {
                        access = true;
                        System.out.println("********************************************");
                        System.out.println("There are the options available for teachers");
                        System.out.println("********************************************");

                        System.out.println("Select the option");
                        System.out.println("a. List the students of ELEMENTARY_SCHOOL grade");
                        System.out.println("b. Enter a grade for a student");
                        System.out.println("c. Exit");

                        String optionTeacher = scanner.nextLine();

                        switch(optionTeacher){
                            case "a":
                                try{
                                    students = studentRepository.readStudentsDataFromJsonByGrade(Grade.ELEMENTARY_SCHOOL);
                                    System.out.println("There are the students of ELEMENTARY_SCHOOL grade");
                                    int index = 1;
                                    for (Student student : students) {
                                        System.out.println(index+":");
                                        System.out.println("Code : "+student.getCode());
                                        System.out.println("Name : "+student.getName());
                                        System.out.println("Age : "+student.getAge());
                                        System.out.println("Grade : "+student.getGrade());
                                        System.out.println("Score : "+student.getScore());
                                        index++;
                                    }
                                }catch (Exception ex){
                                    System.out.println("Error :"+ex.getMessage());
                                }
                            break;
                            case "b":
                                System.out.println("There are all the students registered in the platform");
                                students = studentRepository.getAllStudents();
                                for (Student student : students) {
                                    System.out.println(student.getCode());
                                }
                                System.out.println("Enter the code of the student you wish to modify");
                                String codeStudent = scanner.nextLine();
                                var student = studentRepository.getStudentByCode(codeStudent);
                                System.out.println("Please select the grade");
                                System.out.println("A. ELEMENTARY_SCHOOL, B. MIDDLE_SCHOOL, C. HIGH_SCHOOL");
                                String grade = scanner.nextLine();
                                switch (grade){
                                    case "A":
                                        student.setGrade(Grade.ELEMENTARY_SCHOOL);
                                        break;
                                    case "B":
                                        student.setGrade(Grade.MIDDLE_SCHOOL);
                                        break;
                                    case "C":
                                        student.setGrade(Grade.HIGH_SCHOOL);
                                        break;
                                }
                                System.out.println("Code : "+student.getCode());
                                System.out.println("Name : "+student.getName());
                                System.out.println("Age : "+student.getAge());
                                System.out.println("Grade : "+student.getGrade());
                                System.out.println("Score : "+student.getScore());
                            break;
                            case "c":
                                System.exit(0);
                        }
                        break;
                    }
                case "2":
                    var student = accessValidator.verifyStudentAccess(code);
                    if (student != null) {
                        access = true;
                        List<Subject> subjects= student.getSubjects();
                        System.out.println("There are the subjects of the student with respective grades");
                        int index = 1;
                        for (Subject subject : subjects) {
                            System.out.println(index);
                            System.out.println(subject.getName());
                            System.out.println(subject.getGrade());
                            index ++;
                        }
                        break;
                    }
            }
        }
    }
}
