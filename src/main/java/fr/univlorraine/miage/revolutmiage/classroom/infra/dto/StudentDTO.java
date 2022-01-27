package fr.univlorraine.miage.revolutmiage.classroom.infra.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class StudentDTO {
    private String numero;
    private String nom;
    private String prenom;
}
