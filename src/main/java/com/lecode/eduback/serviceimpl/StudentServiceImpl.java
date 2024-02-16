package com.lecode.eduback.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lecode.eduback.dto.StudentDTO;
import com.lecode.eduback.mapper.StudentMapper;
import com.lecode.eduback.model.Student;
import com.lecode.eduback.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class StudentServiceImpl implements StudentService {

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
		public Optional<StudentDTO> getStudentById(Integer sid)
				throws HttpClientErrorException.BadRequest {
			Student student = studentMapper.selectById(sid);
			return Optional.ofNullable(student).map(StudentDTO::fromEntity);
		}

		@Override
		public Optional<StudentDTO> getStudentBySno(String sno) {
			QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>()
							.eq("sno", sno);
			Student student = studentMapper.selectOne(queryWrapper);
			return Optional.ofNullable(student).map(StudentDTO::fromEntity);
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
