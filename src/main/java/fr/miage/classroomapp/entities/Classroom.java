package fr.miage.classroomapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    private String name;
    private Person teacher;
    private List<Person> students;
    private Photo galleria;
}
