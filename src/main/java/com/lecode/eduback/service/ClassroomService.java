package com.lecode.eduback.service;

import com.lecode.eduback.dto.ClassroomDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClassroomService {

    static void createClassroom(ClassroomDTO classroomDTO);

    List<ClassroomDTO> getClassrooms();

    ClassroomDTO getClassroomById(int crid) throws Exception;

    ClassroomDTO getClassroomByCrno(String crno);

    ClassroomDTO getClassroomById(Integer crid) throws Exception;

    void updateClassroom(ClassroomDTO ClassroomDTO);

    void deleteClassroom(Integer crid);
}
