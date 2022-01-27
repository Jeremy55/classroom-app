package fr.miage.choquert.mappers;

import fr.miage.choquert.dto.ClassroomView;
import fr.miage.choquert.entities.Classroom;
import fr.miage.choquert.dto.NewClassroom;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    default List<ClassroomView> toDto(Page<Classroom> page) {
        return page.map(this::toDto).getContent();
    }

    ClassroomView toDto(Classroom dto);

    Classroom toEntity(NewClassroom dto);

    default List<ClassroomView> toDto(Iterable<Classroom> classrooms){
        var result = new ArrayList<ClassroomView>();
        classrooms.forEach(classroom -> result.add(toDto(classroom)));
        return result;
    }

}
