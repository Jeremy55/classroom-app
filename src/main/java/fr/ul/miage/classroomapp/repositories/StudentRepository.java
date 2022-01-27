package fr.ul.miage.classroomapp.repositories;

import fr.ul.miage.classroomapp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
