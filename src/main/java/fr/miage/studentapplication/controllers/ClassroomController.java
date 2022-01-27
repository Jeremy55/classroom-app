package fr.miage.studentapplication.controllers;

import fr.miage.studentapplication.entities.Classroom;
import fr.miage.studentapplication.services.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/classrooms", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService crService;

    @GetMapping
    public ResponseEntity<?> getAllClassrooms(){
        Iterable<Classroom> allClasses = crService.findAll();

        return ResponseEntity.ok(allClasses);
    }
}
