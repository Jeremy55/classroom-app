package fr.miage.studentapplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Class {
    private int id;

    private Teacher teacher;
    private List<Student> students;
}
