package fr.miage.classroomapp.services;

import fr.miage.classroomapp.entities.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeacherService {

    public Teacher createTeacher(){
        Teacher t = Teacher.builder().firstname("Ionut-Mihai").lastname("Sandu").build();
        return t;
    }
}
