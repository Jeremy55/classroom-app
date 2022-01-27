package ul.miage.classroom.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ul.miage.classroom.entite.Photo;
import ul.miage.classroom.ressource.PhotoRessource;

@RestController
@RequestMapping(value="photos", produces = MediaType.APPLICATION_JSON_VALUE)
@ExposesResourceFor(Photo.class)
@AllArgsConstructor
public class PhotoController {

    private PhotoRessource photoRessource;

    @GetMapping
    public ResponseEntity<?> getAllPhoto() {
        return ResponseEntity.ok(photoRessource.findAll());
    }
}
