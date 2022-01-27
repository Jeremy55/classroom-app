package fr.miage.choquert.services;

import fr.miage.choquert.dto.ClassroomView;
import fr.miage.choquert.dto.NewClassroom;
import fr.miage.choquert.entities.Classroom;
import fr.miage.choquert.mappers.ClassroomMapper;
import fr.miage.choquert.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository repo;
    private final ClassroomMapper mapper;

    public List<ClassroomView> findAll() {
        return mapper.toDto(repo.findAll());
    }

    public ClassroomView create(NewClassroom classroom) {
        Classroom classroom2save = mapper.toEntity(classroom);
        classroom2save.setUuid(UUID.randomUUID().toString());
        classroom2save = repo.save(classroom2save);
        return mapper.toDto(classroom2save);
    }
}
