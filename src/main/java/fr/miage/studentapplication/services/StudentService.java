package fr.miage.studentapplication.services;

import fr.miage.studentapplication.entities.Student;
import fr.miage.studentapplication.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    public final StudentRepository sRepository;

    public Iterable<Student> findAll(){
        return sRepository.findAll();
    }

    public Optional<Student> findById(Long id){
        return sRepository.findById(id);
    }

    public Student getById(Long id){
        return sRepository.getById(id);
    }
}
