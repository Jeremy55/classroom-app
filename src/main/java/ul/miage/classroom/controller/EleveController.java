package ul.miage.classroom.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ul.miage.classroom.entite.Eleve;
import ul.miage.classroom.ressource.EleveRessource;

@RestController
@RequestMapping(value="eleves", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Eleve.class)
@AllArgsConstructor
public class EleveController {

    private EleveRessource eleveRessource;


    @GetMapping
    public ResponseEntity<?> getAllEleve() {
        return ResponseEntity.ok(eleveRessource.findAll());
    }
}
