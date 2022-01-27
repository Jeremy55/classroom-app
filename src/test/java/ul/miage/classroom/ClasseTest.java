package ul.miage.classroom;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import ul.miage.classroom.entite.Classe;
import ul.miage.classroom.entite.Eleve;
import ul.miage.classroom.entite.Professeur;
import ul.miage.classroom.ressource.ClasseRessource;
import ul.miage.classroom.ressource.EleveRessource;
import ul.miage.classroom.ressource.ProfesseurRessource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClasseTest {

    @LocalServerPort
    int port;

    @Autowired
    ClasseRessource classeRessource;
    @Autowired
    EleveRessource eleveRessource;
    @Autowired
    ProfesseurRessource professeurRessource;

    @BeforeEach
    public void setupContext() {
        classeRessource.deleteAll();
        RestAssured.port = port;
    }

    @Test
    public void getAllClasse() {

        Eleve eleve = new Eleve(UUID.randomUUID().toString(), "picard", "jeremy");
        eleveRessource.save(eleve);
        Eleve eleve2 = new Eleve(UUID.randomUUID().toString(), "couroux", "gabriel");
        eleveRessource.save(eleve2);
        ArrayList<Eleve> arrayList = new ArrayList();
        arrayList.add(eleve);
        arrayList.add(eleve2);
        Collection collection = arrayList;

        Professeur professeur = new Professeur(UUID.randomUUID().toString(), "benali", "khalid");
        professeurRessource.save(professeur);


        Classe classe = new Classe(UUID.randomUUID().toString(), "miage", professeur, collection, null);
        classeRessource.save(classe);

        when().get("/classes/")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .assertThat()
                .body("size()",equalTo(1));
    }




}
