package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Classroom;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClassroomRepository extends CrudRepository<Classroom, String> {
    Optional<Classroom> findById(String id);
}
