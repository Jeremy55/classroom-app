package fr.miage.classroomapp.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Student {

    private String firstname;
    private String lastname;
}
