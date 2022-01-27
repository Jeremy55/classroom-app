package fr.univlorraine.miage.revolutmiage.classroom.infra.mapper;

import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Classroom;
import fr.univlorraine.miage.revolutmiage.classroom.infra.dto.ClassroomDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    ClassroomDTO toDto(Classroom entity);
}
