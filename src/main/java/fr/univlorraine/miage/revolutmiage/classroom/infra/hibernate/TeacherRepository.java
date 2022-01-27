package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
    Optional<Teacher> findById(String id);
}
