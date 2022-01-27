package ul.miage.classroom.ressource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ul.miage.classroom.entite.Classe;

@RepositoryRestResource(collectionResourceRel = "classes")
public interface ClasseRessource extends JpaRepository<Classe, String> {
}
