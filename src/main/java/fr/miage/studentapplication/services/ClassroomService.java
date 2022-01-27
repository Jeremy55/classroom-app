package fr.miage.studentapplication.services;

import fr.miage.studentapplication.entities.Classroom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    public final ClassroomService crService;

    public Iterable<Classroom> findAll(){
        return crService.findAll();
    }

    public Optional<Classroom> findById(long id){
        return crService.findById(id);
    }
}
