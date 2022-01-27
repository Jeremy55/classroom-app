package fr.miage.choquert.controller;

import fr.miage.choquert.dto.ClassroomView;
import fr.miage.choquert.services.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService gamesService;

    @GetMapping
    public List<ClassroomView> findAll() {
        return gamesService.findAll();
    }

}

