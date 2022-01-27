package fr.ul.miage.classroomapp.repositories;

import fr.ul.miage.classroomapp.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
