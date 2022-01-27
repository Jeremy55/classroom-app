package fr.univlorraine.miage.revolutmiage.classroom.infra.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class PhotoDTO {
    private String url;
}
