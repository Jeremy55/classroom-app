package ul.miage.classroom.ressource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ul.miage.classroom.entite.Eleve;

@RepositoryRestResource(collectionResourceRel = "eleves")
public interface EleveRessource extends JpaRepository<Eleve, String> {
}
