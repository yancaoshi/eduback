package com.lecode.eduback.controller;

import com.lecode.eduback.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class UserController {


    @GetMapping(path = "users", produces = "application/json")
    public ResponseEntity<?> getUsers() {
        log.info("Request to get all students");
        return ResponseEntity.ok("Return list of students");
    }

    @GetMapping(path = "/user/{uid}", produces = "application/json")
    public User getUser(@PathVariable("uid") String uid) {
        log.info("Request to get user with uid: {}", uid);

        return User.builder()
                .uid(Integer.parseInt(uid))
                .uno("S001")
                .uname("John Doe")
                .build();
    }

    // method to create a new student
    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        log.info("Request to create a new user: {}", user);
        return ResponseEntity.ok("user created");
    }

}
