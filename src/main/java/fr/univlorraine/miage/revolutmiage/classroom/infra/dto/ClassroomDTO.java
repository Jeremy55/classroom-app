package fr.univlorraine.miage.revolutmiage.classroom.infra.dto;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Teacher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class ClassroomDTO {
    private String name;
    private List<StudentDTO> students;
    private Teacher teacher;
    private List<PhotoDTO> photos;
}
