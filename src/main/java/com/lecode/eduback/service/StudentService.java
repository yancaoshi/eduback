package com.lecode.eduback.service;

import com.lecode.eduback.dto.StudentDTO;

import java.util.List;

public interface StudentService {

	void createStudent(StudentDTO studentDTO);

	List<StudentDTO> getStudents();

	StudentDTO getStudentById(Integer sid) throws Exception;

	StudentDTO getStudentBySno(String sno);

	void updateStudent(StudentDTO studentDTO);

	void deleteStudent(Integer sid);


}
