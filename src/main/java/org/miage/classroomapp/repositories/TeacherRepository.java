package org.miage.classroomapp.repositories;

import org.miage.classroomapp.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
}
