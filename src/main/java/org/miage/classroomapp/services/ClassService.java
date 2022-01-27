package org.miage.classroomapp.services;

import lombok.RequiredArgsConstructor;
import org.miage.classroomapp.repositories.ClassRepository;
import org.springframework.stereotype.Service;
import org.miage.classroomapp.entities.Class;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository classRepository;

    public Iterable<? extends Class> getAll() {
        return classRepository.findAll();
    }

}
