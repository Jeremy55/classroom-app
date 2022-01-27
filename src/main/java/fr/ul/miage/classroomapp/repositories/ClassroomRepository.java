package fr.ul.miage.classroomapp.repositories;

import fr.ul.miage.classroomapp.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {
}
