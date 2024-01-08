package com.lecode.eduback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    private Date tbirth;
    private Character tgender;
    private String tavatar;
    private Date tjoindate;
    private Date tresigndate;
    private Character tstatus;
    private String tnote;

}
