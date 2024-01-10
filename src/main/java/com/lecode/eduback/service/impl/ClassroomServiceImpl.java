package com.lecode.eduback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lecode.eduback.dto.ClassroomDTO;
import com.lecode.eduback.mapper.ClassroomMapper;
import com.lecode.eduback.model.Classroom;
import com.lecode.eduback.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    @Transactional
    public void createClassroom(ClassroomDTO classroomDTO) {classroomMapper.insert(ClassroomDTO.toEntity(classroomDTO));}

    @Override
    public List<ClassroomDTO> getClassrooms(){
        return classroomMapper.selectList(null)
                .stream()
                .map(ClassroomDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomDTO getClassroomById(int crid) throws Exception {
        return null;
    }

    @Override
    public ClassroomDTO getClassroomByCrno(String crno) {
        return null;
    }

    @Override
    public ClassroomDTO getClassroomById(Integer crid) throws Exception{
        Classroom classroom = classroomMapper.selectById(crid);
        if(classroom == null){
            throw new Exception("Student not found");
        }else{
            return ClassroomDTO.fromEntity(classroom);
        }
    }

    @Override
    public void updateClassroom(ClassroomDTO classroomDTO){classroomMapper.updateById(ClassroomDTO.toEntity(classroomDTO));}

    @Override
    public void deleteClassroom(Integer crid){classroomMapper.deleteById(crid);}
}
