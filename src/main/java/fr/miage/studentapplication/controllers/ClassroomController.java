package fr.miage.studentapplication.controllers;

import fr.miage.studentapplication.entities.Classroom;
import fr.miage.studentapplication.services.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @GetMapping(value = "/{classroomId}")
    public ResponseEntity<?> getOneClassroomById(@PathVariable("classroomId") Long classroomId) {
        return Optional.ofNullable(crService.findById(classroomId)).filter(Optional::isPresent)
                .map(i -> ResponseEntity.ok(i.get()))
                .orElse(ResponseEntity.notFound().build());
    }

}
