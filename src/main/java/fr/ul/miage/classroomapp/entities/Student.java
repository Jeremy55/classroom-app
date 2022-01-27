package fr.ul.miage.classroomapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

}
