package com.lecode.eduback.controller;

import com.lecode.eduback.dto.ClassroomDTO;
import com.lecode.eduback.service.ClassroomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;


    @GetMapping(path = "classrooms", produces = "application/json")
    public ResponseEntity<?> getClassrooms() {
        log.info("Request to get all classrooms");
        return ResponseEntity.ok(classroomService.getClassrooms());
    }

    @GetMapping(path = "/classroom/{crid}", produces = "application/json")
    public ResponseEntity<?> getClassroom(@PathVariable("crid") String crid) throws Exception {
        log.info("Request to get Classroom with crid: {}", crid);

        return ResponseEntity.ok(classroomService.getClassroomById(Integer.parseInt(crid)));
    }

    // method to create a new Classroom
    @PostMapping(path = "/Classroom", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createClassroom(@RequestBody ClassroomDTO classroomDTO) {
        log.info("Request to create a new Classroom: {}", classroomDTO);
        ClassroomService.createClassroom(classroomDTO);
        return ResponseEntity.ok("Classroom created");
    }

    @PatchMapping(path = "/classroom/{crid}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateClassroom(@PathVariable("crid") String crid, @RequestBody ClassroomDTO classroomDTO) {
        log.info("Request to update Classroom with crid: {}", crid);
        classroomService.updateClassroom(classroomDTO);
        return ResponseEntity.ok("classroom updated");
    }

    @DeleteMapping(path = "/Classroom/{crid}", produces = "application/json")
    public ResponseEntity<?> deleteClassroom(@PathVariable("crid") String crid) {
        log.info("Request to delete Classroom with crid: {}", crid);
        classroomService.deleteClassroom(Integer.parseInt(crid));
        return ResponseEntity.ok("Classroom deleted");
    }


}

