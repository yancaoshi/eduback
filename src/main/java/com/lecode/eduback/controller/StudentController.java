package com.lecode.eduback.controller;

import com.lecode.eduback.dto.StudentDTO;
import com.lecode.eduback.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class StudentController {

	@Autowired
	private StudentService studentService;


	@GetMapping(path = "students", produces = "application/json")
	public ResponseEntity<?> getStudents() {
		log.info("Request to get all students");
		return ResponseEntity.ok(studentService.getStudents());
	}

	@GetMapping(path = "/student/{sid}", produces = "application/json")
	public ResponseEntity<?> getStudent(@PathVariable("sid") String sid) throws Exception {
		log.info("Request to get student with sid: {}", sid);

		return ResponseEntity.ok(studentService.getStudentById(Integer.parseInt(sid)));
	}

// method to create a new student
	@PostMapping(path = "/student", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
		log.info("Request to create a new student: {}", studentDTO);
		studentService.createStudent(studentDTO);
		return ResponseEntity.ok("student created");
	}

	@PatchMapping(path = "/student/{sid}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateStudent(@PathVariable("sid") String sid, @RequestBody StudentDTO studentDTO) {
		log.info("Request to update student with sid: {}", sid);
		studentService.updateStudent(studentDTO);
		return ResponseEntity.ok("student updated");
	}

	@DeleteMapping(path = "/student/{sid}", produces = "application/json")
	public ResponseEntity<?> deleteStudent(@PathVariable("sid") String sid) {
		log.info("Request to delete student with sid: {}", sid);
		studentService.deleteStudent(Integer.parseInt(sid));
		return ResponseEntity.ok("student deleted");
	}


}
