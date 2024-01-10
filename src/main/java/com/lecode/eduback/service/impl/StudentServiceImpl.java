package com.lecode.eduback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lecode.eduback.dto.StudentDTO;
import com.lecode.eduback.mapper.StudentMapper;
import com.lecode.eduback.model.Student;
import com.lecode.eduback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;

		@Override
		@Transactional
		public void createStudent(StudentDTO studentDTO) {
				studentMapper.insert(StudentDTO.toEntity(studentDTO));
		}

		@Override
		public List<StudentDTO> getStudents() {
				return studentMapper.selectList(null)
								.stream()
								.map(StudentDTO::fromEntity)
								.collect(Collectors.toList());
		}

		@Override
		public StudentDTO getStudentById(Integer sid) {
			Student student = studentMapper.selectById(sid);
			return StudentDTO.fromEntity(student);
		}

		@Override
		public StudentDTO getStudentBySno(String sno) {
			QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>()
							.eq("sno", sno);
			return Optional.ofNullable(studentMapper.selectOne(queryWrapper))
							.map(StudentDTO::fromEntity)
							.orElse(null);
		}

		@Override
		public void updateStudent(StudentDTO studentDTO) {
			studentMapper.updateById(StudentDTO.toEntity(studentDTO));
		}

		@Override
		public void deleteStudent(Integer sid) {
			studentMapper.deleteById(sid);
		}


}
