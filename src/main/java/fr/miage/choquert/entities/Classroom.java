package fr.miage.choquert.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classroom")
public class Classroom {

    @Id
    private String uuid;
    private String name;

}
