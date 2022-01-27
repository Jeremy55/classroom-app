package ul.miage.classroom.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String nomClasse;
    @OneToOne(fetch = FetchType.EAGER)
    private Professeur professeur;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Eleve> eleves;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Photo> galerie;




}
