package org.miage.classroomapp;

import org.miage.classroomapp.entities.Student;
import org.miage.classroomapp.entities.Teacher;
import org.miage.classroomapp.repositories.ClassRepository;
import org.miage.classroomapp.repositories.StudentRepository;
import org.miage.classroomapp.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.miage.classroomapp.entities.Class;

@SpringBootApplication
public class ClassroomAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassroomAppApplication.class, args);
    }
    @Bean
    CommandLineRunner run(ClassRepository classRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        return args -> {
            Student student1 = new Student();
            student1.setName("Jérémy");
            student1.setSurname("Picard");
            Student student2 = new Student();
            student2.setName("Chloé");
            student2.setSurname("Soquet");
            Teacher teacher = new Teacher();
            teacher.setName("Sandu");
            teacher.setSurname("Ionut-Mihai");
            Class classroom = new Class();
            classroom.setName("Miage");
            classroom.getStudents().add(student1);
            classroom.getStudents().add(student2);
            classroom.setTeacher(teacher);
            studentRepository.save(student1);
            studentRepository.save(student2);
            teacherRepository.save(teacher);
            classRepository.save(classroom);
        };
    }
}
