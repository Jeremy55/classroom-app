package fr.univlorraine.miage.revolutmiage.classroom.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
public class Classroom {
    @Id
    private String name;

    @ManyToMany
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    @OneToMany
    private List<Photo> photos;
}
