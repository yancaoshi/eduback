package com.lecode.eduback.model;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lecode.eduback.types.GenderType;
import com.lecode.eduback.types.StudentStatus;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Slf4j
@TableName("student")
public class Student {


  @TableId(value = "sid", type = IdType.AUTO)
  private Integer sid;

  @TableField("sno")
  private String sno;

  @TableField("sname")
  private String sname;

  @TableField("snick")
  private String snick;

  @TableField("sbirth")
  private LocalDate sbirth;

  @TableField("sgender")
  private GenderType sgender;

  @TableField("sschool")
  private String sschool;

  @TableField("saddress")
  private String saddress;

  @TableField("sfamily")
  private String sfamily;

  @TableField("sfname")
  private String sfname;

  @TableField("sfmobile")
  private String sfmobile;

  @TableField("ssource")
  private String ssource;

  @TableField("sstatus")
  private StudentStatus sstatus;

  @TableField("snote")
  private String snote;

  @TableLogic
  private Integer deleted;

}
