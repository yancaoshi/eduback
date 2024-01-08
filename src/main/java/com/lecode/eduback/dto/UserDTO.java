package com.lecode.eduback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
public class UserDTO {

    private Integer uid;

    @NotNull
    private String uno;

    @Size(max = 16)
    private String uname;

    private String upassword;
    private String uwechatid;
    private String uwechatopenid;
    private String uphone;
    private Character ustatus;
    private String unote;

}
