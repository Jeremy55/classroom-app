package fr.miage.choquert.classroom;

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
