package fr.univlorraine.miage.revolutmiage.classroom.infra.rest;

import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.ClassroomCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.infra.mapper.ClassroomMapper;
import fr.univlorraine.miage.revolutmiage.utils.infra.rest.DefaultResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classrooms")
@RequiredArgsConstructor
public class ClassroomResource extends DefaultResource {
    private final ClassroomCatalog catalog;
    private final ClassroomMapper classroomMapper;

    @GetMapping("{name}")
    public ResponseEntity<?> getClassroom(@PathVariable final String name) {
        return ResponseEntity.of(catalog.getById(name).map(classroomMapper::toDto));
    }
}
