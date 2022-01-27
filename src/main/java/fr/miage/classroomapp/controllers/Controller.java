package fr.miage.classroomapp.controllers;

import fr.miage.classroomapp.entities.Classroom;
import fr.miage.classroomapp.entities.Person;
import fr.miage.classroomapp.entities.Photo;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value="/classroom")
public class Controller {


    @GetMapping
    public String get(Model model) {
        List<Person> students = new ArrayList<>();
        students.add(new Person("Noirot", "Quentin"));
        students.add(new Person("Mercier", "Clément"));
        Classroom classroom = new Classroom("SID", new Person("Sandu", "Ionut-Mihai"), students, new Photo("classroomPhoto", "classroom.png"));

        model.addAttribute("classroom", classroom);
        return "classroom";
    }
}
