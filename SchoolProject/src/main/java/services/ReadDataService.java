package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.Subject;
import models.Teacher;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Signature;
import java.util.List;

public class ReadDataService {
    public ReadDataService() {}

    public List<Student> readStudentsDataFromJson() {
        List<Student> students = null;
                
        try {
            Gson gson = new Gson();
            var path = (Paths.get("students.json"));
            System.out.println(path);
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/students.json"));
            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Teacher> readTeachersDataFromJson(){
        List<Teacher> teachers = null;

        try {
            Gson gson = new Gson();
            var path = (Paths.get("teachers.json"));
            System.out.println(path);
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/teachers.json"));

            teachers = gson.fromJson(reader, new TypeToken<List<Teacher>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }
}
