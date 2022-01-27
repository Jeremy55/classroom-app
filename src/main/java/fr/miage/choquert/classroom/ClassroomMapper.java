package fr.miage.choquert.classroom;

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
