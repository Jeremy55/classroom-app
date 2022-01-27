package fr.univlorraine.miage.revolutmiage.classroom.domain.catalog;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Classroom;

import java.util.Optional;

public interface ClassroomCatalog {
    Optional<Classroom> getById(String id);

    Classroom save(Classroom classroom);
}
