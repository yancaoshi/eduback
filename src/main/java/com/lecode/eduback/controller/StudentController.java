package com.lecode.eduback.controller;

import com.lecode.eduback.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class StudentController {


	@GetMapping(path = "students", produces = "application/json")
	public ResponseEntity<?> getStudents() {
		log.info("Request to get all students");
		return ResponseEntity.ok("Return list of students");
	}

	@GetMapping(path = "/student/{sid}", produces = "application/json")
	public Student getStudent(@PathVariable("sid") String sid) {
		log.info("Request to get student with sid: {}", sid);

		return Student.builder()
				.sid(Integer.parseInt(sid))
				.sno("S001")
				.sname("John Doe")
				.snick("John")
				.build();
	}

// method to create a new student
	@PostMapping(path = "/student", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		log.info("Request to create a new student: {}", student);
		return ResponseEntity.ok("student created");
	}

}
