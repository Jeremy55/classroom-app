package ul.miage.classroom.ressource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ul.miage.classroom.entite.Photo;

@RepositoryRestResource(collectionResourceRel = "photos")
public interface PhotoRessource  extends JpaRepository<Photo, String> {
}
