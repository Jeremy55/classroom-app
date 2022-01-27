package fr.univlorraine.miage.revolutmiage.classroom.domain.catalog;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Classroom;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Photo;

import java.util.Optional;

public interface PhotoCatalog {
    Photo save(Photo photo);
}
