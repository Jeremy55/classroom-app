package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.TeacherCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeacherHibernateAdapter implements TeacherCatalog {
    private final TeacherRepository repository;

    @Override
    @Transactional(readOnly = false)
    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }
}
