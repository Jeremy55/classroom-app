package fr.miage.studentapplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Student {
    private int id;

    private String name;
    private String firstName;
}
