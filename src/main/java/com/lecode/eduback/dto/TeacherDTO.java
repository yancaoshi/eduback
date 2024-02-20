package com.lecode.eduback.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TeacherDTO {

    private Integer tid;

    @NotNull
    private String tno;

    @Size(max = 16)
    private String tname;

    private String tnick;
    private LocalDate tbirth;
    private Character tgender;
    private String tavatar;
    private LocalDate tjoindate;
    private LocalDate tresigndate;
    private Character tstatus;
    private String tnote;

}
