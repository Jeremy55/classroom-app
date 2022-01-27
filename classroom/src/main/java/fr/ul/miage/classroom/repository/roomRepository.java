package fr.ul.miage.classroom.repository;


import fr.ul.miage.classroom.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roomRepository extends JpaRepository<Room, Long> {
}