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
public class StudentDTO {

	private Integer sid;

	@NotNull
	private String sno;

	@Size(max = 16)
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
