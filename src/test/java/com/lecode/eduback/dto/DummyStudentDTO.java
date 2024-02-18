package com.lecode.eduback.dto;

import java.util.Optional;
import com.lecode.eduback.types.GenderType;
import com.lecode.eduback.types.StudentStatus;

public class DummyStudentDTO {

	public static StudentDTO dummyStudentDTO() {
		StudentDTO studentDTO;
		studentDTO = StudentDTO.builder()
							   .sid(1)
							   .sno("1234567890")
							   .sname("John")
							   .saddress("123 Main St")
							   .snick("John")
							   .sbirth(null)
							   .sgender(GenderType.MALE)
							   .sschool("ABC School")
							   .sfamily("Doe")
							   .sfname("John Doe")
							   .sfmobile("1234567890")
							   .snote("This is a note")
							   .ssource("This is a source")
							   .sstatus(StudentStatus.ACTIVE)
							   .build();
		return studentDTO;
	}

	public static Optional<StudentDTO> dummyStudentDTOOptional() {
		return Optional.of(dummyStudentDTO());
	}
}
