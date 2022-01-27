package fr.miage.classroomapp.services;

import fr.miage.classroomapp.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentsService {

    public List<Student> createStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(Student.builder().firstname("Quentin").lastname("Noirot").build());
        students.add(Student.builder().firstname("Tristan").lastname("Luc").build());
        return students;
    }
}
