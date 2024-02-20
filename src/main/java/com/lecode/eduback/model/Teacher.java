package com.lecode.eduback.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
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

  @TableLogic
  @Builder.Default
  private Boolean deleted = false;


}
