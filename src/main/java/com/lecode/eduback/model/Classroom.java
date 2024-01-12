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
@TableName("classroom")
public class Classroom {


    @TableId(value = "crid", type = IdType.AUTO)
    private Integer crid;

    private String crname;
    private String crcapacity;
    private Character crstatus;
    private String crnote;

}
