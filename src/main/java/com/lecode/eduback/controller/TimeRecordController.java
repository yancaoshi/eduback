package com.lecode.eduback.controller;

import com.lecode.eduback.service.TimeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class TimeRecordController {

    @Autowired
    private TimeRecordService timeRecordService;

    @GetMapping(path = "/timerecords", produces = "application/json")
    public ResponseEntity<?> getTimeRecords() {
        return ResponseEntity.ok(timeRecordService.getTimeRecords());
    }

}
