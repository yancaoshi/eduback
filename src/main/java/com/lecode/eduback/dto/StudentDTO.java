package com.lecode.eduback.dto;

import com.lecode.eduback.model.Student;
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

	// create method fromEntity to map Student to StudentDTO
	public static StudentDTO fromEntity(Student student) {
		return StudentDTO.builder()
				.sid(student.getSid())
				.sno(student.getSno())
				.sname(student.getSname())
				.snick(student.getSnick())
				.sbirth(student.getSbirth())
				.sgender(student.getSgender())
				.sschool(student.getSschool())
				.saddress(student.getSaddress())
				.sfamily(student.getSfamily())
				.sfname(student.getSfname())
				.sfmobile(student.getSfmobile())
				.ssource(student.getSsource())
				.sstatus(student.getSstatus())
				.snote(student.getSnote())
				.build();
	}

	public static Student toEntity(StudentDTO studentDTO) {
		return Student.builder()
				.sid(studentDTO.getSid())
				.sno(studentDTO.getSno())
				.sname(studentDTO.getSname())
				.snick(studentDTO.getSnick())
				.sbirth(studentDTO.getSbirth())
				.sgender(studentDTO.getSgender())
				.sschool(studentDTO.getSschool())
				.saddress(studentDTO.getSaddress())
				.sfamily(studentDTO.getSfamily())
				.sfname(studentDTO.getSfname())
				.sfmobile(studentDTO.getSfmobile())
				.ssource(studentDTO.getSsource())
				.sstatus(studentDTO.getSstatus())
				.snote(studentDTO.getSnote())
				.build();
	}

}
