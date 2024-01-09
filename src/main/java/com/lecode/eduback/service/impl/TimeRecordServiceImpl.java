package com.lecode.eduback.service.impl;

import com.lecode.eduback.dto.TimeRecordDTO;
import com.lecode.eduback.mapper.TimeRecordMapper;
import com.lecode.eduback.service.TimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeRecordServiceImpl implements TimeRecordService {

    @Autowired
    private TimeRecordMapper timeRecordMapper;

    @Override
    public List<TimeRecordDTO> getTimeRecords() {
        List list = new ArrayList();
        list.add("Hello");
        return list;
    }
}
