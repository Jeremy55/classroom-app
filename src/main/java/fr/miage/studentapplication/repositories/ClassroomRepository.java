package fr.miage.studentapplication.repositories;

import fr.miage.studentapplication.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository <Classroom, Long> {
}
