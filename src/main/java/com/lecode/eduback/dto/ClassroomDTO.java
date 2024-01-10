package com.lecode.eduback.dto;

import com.lecode.eduback.model.Classroom;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@Getter
@Setter
public class ClassroomDTO {

    private Integer crid;

    @NotNull
    private String sno;

    @Size(max = 16)
    private String crname;

    private String crcapacity;
    private Character crstatus;
    private String crnote;


    // create method fromEntity to map Classroom to ClassroomDTO
    public static ClassroomDTO fromEntity(Classroom classroom) {
        return ClassroomDTO.builder()
                .crid(Classroom.getCrid())
                .crname(Classroom.getCrname())
                .crcapacity(Classroom.getCrcapacity())
                .crstatus(Classroom.getCrstatus())
                .crnote(Classroom.getCrnote())
                .build();
    }

    public static Classroom toEntity(ClassroomDTO ClassroomDTO) {
        return Classroom.builder()
                .crid(ClassroomDTO.getCrid())
                .crname(ClassroomDTO.getCrname())
                .crcapacity(ClassroomDTO.getCrcapacity())
                .crstatus(ClassroomDTO.getCrstatus())
                .crnote(ClassroomDTO.getCrnote())
                .build();
    }

}
