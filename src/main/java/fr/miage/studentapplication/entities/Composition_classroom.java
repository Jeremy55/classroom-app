package fr.miage.studentapplication.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Composition_classroom {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Classroom classRoom;
}
