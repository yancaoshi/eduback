package com.lecode.eduback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@Builder
@Slf4j
@TableName("teacher")
public class Teacher {


    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    private String tno;
    private String tname;
    private String tnick;
    private Date tbirth;
    private Character tgender;
    private String tavatar;
    private Date tjoindate;
    private Date tresigndate;
    private String sfname;
    private Character tstatus;
    private String tnote;

}
