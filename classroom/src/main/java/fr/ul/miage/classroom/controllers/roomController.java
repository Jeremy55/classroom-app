package fr.ul.miage.classroom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import fr.ul.miage.classroom.entities.Room;
import fr.ul.miage.classroom.repository.roomRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rooms")
@RequiredArgsConstructor
public class roomController {
    private final roomRepository roomRepository;

    @GetMapping
    public ResponseEntity<?> getAllRooms(){
        Iterable<Room> allClasses = roomRepository.findAll();
        return ResponseEntity.ok(allClasses);
    }

}
