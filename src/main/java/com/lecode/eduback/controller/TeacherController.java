package com.lecode.eduback.controller;

import com.lecode.eduback.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class TeacherController {


    @GetMapping(path = "teachers", produces = "application/json")
    public ResponseEntity<?> getTeachers() {
        log.info("Request to get all teachers");
        return ResponseEntity.ok("Return list of teachers");
    }

    @GetMapping(path = "/teacher/{tid}", produces = "application/json")
    public Teacher getTeacher(@PathVariable("tid") String sid) {
        log.info("Request to get student with sid: {}", sid);

        return Teacher.builder()
                .tid(Integer.parseInt(sid))
                .tno("S001")
                .tname("John Doe")
                .tnick("John")
                .build();
    }

    // method to create a new student
    @PostMapping(path = "/teacher", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {
        log.info("Request to create a new teacher: {}", teacher);
        return ResponseEntity.ok("teacher created");
    }

}
