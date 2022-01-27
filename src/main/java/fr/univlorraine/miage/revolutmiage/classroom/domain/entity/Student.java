package fr.univlorraine.miage.revolutmiage.classroom.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
public class Student implements Person {
    @Id
    private String numero;
    private String nom;
    private String prenom;
}
