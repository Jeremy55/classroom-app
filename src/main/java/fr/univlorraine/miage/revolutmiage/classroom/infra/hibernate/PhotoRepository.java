package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Photo;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhotoRepository extends CrudRepository<Photo, String> {
    Optional<Photo> findById(String id);
}
