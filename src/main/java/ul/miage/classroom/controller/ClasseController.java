package ul.miage.classroom.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ul.miage.classroom.entite.Classe;
import ul.miage.classroom.ressource.ClasseRessource;

@RestController
@RequestMapping(value="classes", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Classe.class)
@AllArgsConstructor
public class ClasseController {

    private ClasseRessource classeRessource;

    @GetMapping
    public ResponseEntity<?> getAllCarte() {
        return ResponseEntity.ok(classeRessource.findAll());
    }



}
