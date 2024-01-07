package com.lecode.eduback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lecode.eduback.model.Student;

public interface StudentMapper extends BaseMapper<Student> {


	void getStudentById(Integer sid);
}
