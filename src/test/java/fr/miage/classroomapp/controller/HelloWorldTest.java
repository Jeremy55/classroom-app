package fr.miage.classroomapp.controller;

import fr.miage.classroomapp.controller.HelloWord;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldTest {

    private HelloWord helloWord;

    @LocalServerPort
    int port;

    @BeforeEach
    public void setupContext(){
        RestAssured.port = port;
    }

    @Test
    void helloworld(){
        Response r = when().get("/greetings").then().statusCode(HttpStatus.SC_OK).extract().response();
        assertThat(r.asPrettyString(),containsString("Quentin"));
    }

    @Test
    void helloworldFail(){
        when().get("/sqdqs").then().statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
    }

    @Test
    void helloworldSpecific(){
        Response r = when().get("/greetings/Tristan").then().statusCode(HttpStatus.SC_OK).extract().response();
        assertThat(r.asPrettyString(),containsString("Tristan"));
    }

    @Test
    void helloworldSpecificFail(){
        Response r = when().get("/greetings/Tristan").then().statusCode(HttpStatus.SC_OK).extract().response();
        assertThat(r.asPrettyString(),not(containsString("Quentin")));
    }
}
