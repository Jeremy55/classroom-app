package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.StudentCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentHibernateAdapter implements StudentCatalog {
    private final StudentRepository repository;

    @Override
    @Transactional(readOnly = false)
    public Student save(Student student) {
        return repository.save(student);
    }
}
