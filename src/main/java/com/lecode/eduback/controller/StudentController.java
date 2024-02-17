package com.lecode.eduback.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import com.lecode.eduback.common.ApiResponse;
import com.lecode.eduback.common.MessageService;
import com.lecode.eduback.dto.StudentDTO;
import com.lecode.eduback.model.Student;
import com.lecode.eduback.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/students", produces = "application/json")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private MessageService messageService;


  @GetMapping(produces = "application/json")
  public ResponseEntity<?> getStudents() {
    log.debug("Request to get all students");
    List<Student> studentList = studentService.list();
    List<StudentDTO> studentDTOList = studentList.stream()
                                                 .map(StudentDTO::fromEntity)
                                                 .collect(Collectors.toList());
    ApiResponse apiResponse = ApiResponse.builder()
                                         .data(studentDTOList)
                                         .build();
    return ResponseEntity.ok(apiResponse);
  }

  @GetMapping(path = "/{sid}", produces = "application/json")
  public ResponseEntity<?> getStudent(@PathVariable("sid") int sid) {
    log.debug("Request to get student with sid: {}", sid);
    ApiResponse apiResponse = studentService.getOptById(sid)
                                            .map(student -> ApiResponse.builder()
                                                                       .data(StudentDTO.fromEntity(
                                                                           student))
                                                                       .build())
                                            .orElseGet(() -> ApiResponse.builder()
                                                                        .message(
                                                                            messageService.getProperty(
                                                                                "student.not_found"))
                                                                        .data(new HashMap<>())
                                                                        .build());
    return ResponseEntity.ok(apiResponse);
  }

  // method to create a new student
  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> createStudent(@Validated @RequestBody StudentDTO studentDTO) {
    log.debug("Request to create a new student: {}", studentDTO);
    Student student = StudentDTO.toEntity(studentDTO);

    try {
      studentService.save(student);
      ApiResponse apiResponse = ApiResponse.builder()
                                           .status(HttpStatus.CREATED)
                                           .message(messageService.getProperty("success"))
                                           .data(StudentDTO.fromEntity(student))
                                           .build();
      URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                .path("/{sid}")
                                                .buildAndExpand(student.getSid())
                                                .toUri();
      return ResponseEntity.created(location).body(apiResponse);

    } catch (Exception e) {
      ApiResponse apiResponse = ApiResponse.builder()
                                           .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                           .message(messageService.getProperty("failure"))
                                           .data(e.getMessage())
                                           .build();
      return ResponseEntity.internalServerError().body(apiResponse);
    }

  }

  @PatchMapping(path = "/{sid}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<?> updateStudent(@PathVariable("sid") Integer sid,
                                         @RequestBody StudentDTO studentDTO) {
    log.debug("Request to update a student by sid: {}", studentDTO);
    Student student = StudentDTO.toEntity(studentDTO);

    try {
      studentService.updateById(student);
      ApiResponse apiResponse = ApiResponse.builder()
                                           .status(HttpStatus.OK)
                                           .message(messageService.getProperty("success"))
                                           .data(StudentDTO.fromEntity(student))
                                           .build();
      return ResponseEntity.ok(apiResponse);
    } catch (Exception e) {
      ApiResponse apiResponse = ApiResponse.builder()
                                           .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                           .message(messageService.getProperty("failure"))
                                           .data(e.getMessage())
                                           .build();
      return ResponseEntity.internalServerError().body(apiResponse);
    }

  }

  @DeleteMapping(path = "/{sid}", produces = "application/json")
  public ResponseEntity<?> deleteStudent(@PathVariable("sid") Integer sid) {
    log.info("Request to delete student by sid: {}", sid);
    try{
      studentService.removeById(sid);
      ApiResponse apiResponse = ApiResponse.builder()
                                           .status(HttpStatus.OK)
                                           .message(messageService.getProperty("success"))
                                           .data(new HashMap<>())
                                           .build();
      return ResponseEntity.ok(apiResponse);
    } catch (Exception e) {
      ApiResponse apiResponse = ApiResponse.builder()
                                           .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                           .message(messageService.getProperty("failure"))
                                           .data(e.getMessage())
                                           .build();
      return ResponseEntity.internalServerError().body(apiResponse);
    }
  }


}
