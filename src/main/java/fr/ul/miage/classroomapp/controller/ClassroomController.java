package fr.ul.miage.classroomapp.controller;

import fr.ul.miage.classroomapp.entity.*;
import fr.ul.miage.classroomapp.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClassroomController {
    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping("/classrooms")
    public List<Classroom> getAllClassrooms() {

        long teacherId = 121;
        long studentId = 121;
        long galleryId = 121;
        long classRoomId = 121;

        // New teacher
        Teacher teacher = new Teacher(teacherId,"Roman","Archi scripts");
        // New student
        Student student = new Student(studentId,"Nicolas");
        List<Student> students = new ArrayList<>();
        students.add(student);
        // New picture
        GalerieLink galerieLink = new GalerieLink(galleryId,"https://image.shutterstock.com/image-photo/cat-medical-mask-protective-antiviral-260nw-1684423789.jpg");
        List<GalerieLink> gallery = new ArrayList<>();
        gallery.add(galerieLink);
        // New classroom
        Classroom classroom = new Classroom(classRoomId,"103",teacher.getId(),students,gallery);
        classroomRepository.save(classroom);
        return classroomRepository.findAll();
    }
}
