package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.ClassroomCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Classroom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClassroomHibernateAdapter implements ClassroomCatalog {
    private final ClassroomRepository repository;

    @Override
    public Optional<Classroom> getById(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Classroom save(Classroom classroom) {
        return repository.save(classroom);
    }
}
