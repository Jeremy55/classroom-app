package fr.ul.miage.classroomapp.controllers;

import fr.ul.miage.classroomapp.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("class")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomRepository classroomRepository;

    @GetMapping("/{classroomID}")
    public String getClassroom(@PathVariable String classroomID, Model model) {
        model.addAttribute("classroom", classroomRepository.findById(UUID.fromString(classroomID)));
        return "classroom";
    }

}
