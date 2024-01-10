package com.lecode.eduback.dto;

import java.util.Optional;

public class DummyStudentDTO {

	public static Optional<StudentDTO> dummyStudentDTO() {
		StudentDTO studentDTO = StudentDTO.builder()
						.sid(1)
						.sno("1234567890")
						.sname("John")
						.saddress("123 Main St")
						.snick("John")
						.sbirth(null)
						.sgender('M')
						.sschool("ABC School")
						.sfamily("Doe")
						.sfname("John Doe")
						.sfmobile("1234567890")
						.snote("This is a note")
						.ssource("This is a source")
						.sstatus('A')
						.build();
		return Optional.of(studentDTO);

	}
}
