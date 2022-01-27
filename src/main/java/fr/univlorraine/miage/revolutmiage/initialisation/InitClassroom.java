package fr.univlorraine.miage.revolutmiage.initialisation;

import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.ClassroomCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.PhotoCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.StudentCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.catalog.TeacherCatalog;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Classroom;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Photo;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Student;
import fr.univlorraine.miage.revolutmiage.classroom.domain.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class InitClassroom {
    Logger logger = LoggerFactory.getLogger(InitClassroom.class);
    final ClassroomCatalog classroomCatalog;
    final StudentCatalog studentCatalog;
    final TeacherCatalog teacherCatalog;
    final PhotoCatalog photoCatalog;

    @EventListener(ApplicationReadyEvent.class)
    public void initialisation() {
        final Student student1 = new Student().setNumero("SDF094JTR").setNom("Lassini").setPrenom("Asma");
        final Teacher teacher1 = new Teacher().setNumero("ZSE666ETR").setNom("Perrin").setPrenom("Olivier");
        final Photo photo1 = new Photo().setUrl("https://www.univ-lorraine.fr/wp-content/uploads/2020/12/logo-ul-10ans.png.webp");
        final Classroom classroom1 = new Classroom().setName("language-de-script").setTeacher(teacher1).setStudents(new ArrayList<>() {{
            add(student1);
        }}).setPhotos(new ArrayList<>(){{
            add(photo1);
        }});

        photoCatalog.save(photo1);
        studentCatalog.save(student1);
        teacherCatalog.save(teacher1);
        classroomCatalog.save(classroom1);

        logger.info("Initialisation des données terminée");
    }
}
