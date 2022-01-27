package org.miage.classroomapp.controllers;

import lombok.RequiredArgsConstructor;
import org.miage.classroomapp.services.ClassService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="classes",produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Class.class)
@RequiredArgsConstructor
public class ClassController{

    private final ClassService classService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(classService.getAll(), HttpStatus.OK);
    }
}
