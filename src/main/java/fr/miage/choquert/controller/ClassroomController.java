package fr.miage.choquert.controller;

import fr.miage.choquert.dto.ClassroomView;
import fr.miage.choquert.dto.NewClassroom;
import fr.miage.choquert.services.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassroomView create(@RequestBody NewClassroom classroom) {
        return gamesService.create(classroom);
    }
}

