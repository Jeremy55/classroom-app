package org.miage.classroomapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.miage.classroomapp.entities.Class;

public interface ClassRepository extends CrudRepository<Class,Long> {
}
