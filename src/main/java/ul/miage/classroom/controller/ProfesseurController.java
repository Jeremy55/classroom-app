package ul.miage.classroom.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ul.miage.classroom.entite.Professeur;
import ul.miage.classroom.ressource.ProfesseurRessource;

@RestController
@RequestMapping(value="professeurs", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Professeur.class)
@AllArgsConstructor
public class ProfesseurController {

    private ProfesseurRessource professeurRessource;

    @GetMapping
    public ResponseEntity<?> getAllCarte() {
        return ResponseEntity.ok(professeurRessource.findAll());
    }
}
