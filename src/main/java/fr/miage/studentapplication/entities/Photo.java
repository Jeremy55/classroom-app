package fr.miage.studentapplication.entities;

import lombok.*;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String path;
}
