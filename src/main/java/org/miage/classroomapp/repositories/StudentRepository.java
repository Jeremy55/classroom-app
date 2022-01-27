package org.miage.classroomapp.repositories;

import org.miage.classroomapp.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
