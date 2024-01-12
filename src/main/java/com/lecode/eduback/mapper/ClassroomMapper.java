package com.lecode.eduback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lecode.eduback.model.Classroom;
public interface ClassroomMapper extends BaseMapper<Classroom> {

    void getClassroomById(Integer crid);
}
