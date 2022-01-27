package fr.miage.classroomapp.controller;


import fr.miage.classroomapp.services.StudentsService;
import fr.miage.classroomapp.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class ClassroomController {

    private final StudentsService studentsService;
    private final TeacherService teacherService;

    @GetMapping
    public String getClass(Model model){
            model.addAttribute("students",studentsService.createStudents());
            model.addAttribute("teacher",teacherService.createTeacher());
            return "classroom";
        }
}
