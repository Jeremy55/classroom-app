package fr.miage.choquert.services;

import fr.miage.choquert.dto.ClassroomView;
import fr.miage.choquert.mappers.ClassroomMapper;
import fr.miage.choquert.repositories.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository repo;
    private final ClassroomMapper mapper;

    public List<ClassroomView> findAll() {
        return mapper.toDto(repo.findAll());
    }
}
