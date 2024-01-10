package com.lecode.eduback.model;

import java.util.Optional;

public class DummyStudent {

	public static Optional<Student> dummyStudent() {
		// create a dummy studentDTO by calling builder methods. Fill each field with sample data.
		Student student = Student.builder().sid(1).sname("John").saddress("123 Main St").build();
		return Optional.of(student);

	}

}
