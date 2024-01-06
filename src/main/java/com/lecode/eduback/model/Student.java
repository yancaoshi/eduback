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
@TableName("student")
public class Student {


	@TableId(value = "sid", type = IdType.AUTO)
	private Integer sid;

	private String sno;
	private String sname;
	private String snick;
	private Date sbirth;
	private Character sgender;
	private String sschool;
	private String saddress;
	private String sfamily;
	private String sfname;
	private String sfmobile;
	private String ssource;
	private Character sstatus;
	private String snote;

}
