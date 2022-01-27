package fr.univlorraine.miage.revolutmiage.classroom.infra.hibernate;

import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.PhotoCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.TeacherCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Photo;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhotoHibernateAdapter implements PhotoCatalog {
    private final PhotoRepository repository;

    @Override
    @Transactional(readOnly = false)
    public Photo save(Photo photo) {
        return repository.save(photo);
    }
}
