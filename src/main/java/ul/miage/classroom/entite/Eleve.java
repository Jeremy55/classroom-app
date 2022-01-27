package ul.miage.classroom.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eleve implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String nom;
    private String prenom;
}
