package com.lecode.eduback.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lecode.eduback.mapper.StudentMapper;
import com.lecode.eduback.model.Student;
import com.lecode.eduback.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
