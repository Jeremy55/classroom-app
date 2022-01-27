package fr.ul.miage.classroomapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "classrooms")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "fk_teacher_id", nullable = false)
    private long fkTeacherId;

    @OneToMany( targetEntity=Student.class, cascade = CascadeType.ALL )
    private List<Student> students;

    @OneToMany( targetEntity=GalerieLink.class, cascade = CascadeType.ALL )
    private List<GalerieLink> galerie;

}
