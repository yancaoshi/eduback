package com.lecode.eduback.service;

import java.util.List;
import java.util.Optional;
import com.lecode.eduback.dto.StudentDTO;
import org.springframework.web.client.HttpClientErrorException;

public interface StudentService {

	void createStudent(StudentDTO studentDTO);

	List<StudentDTO> getStudents();

	Optional<StudentDTO> getStudentById(Integer sid) throws HttpClientErrorException.BadRequest;

	Optional<StudentDTO> getStudentBySno(String sno);

	void updateStudent(StudentDTO studentDTO);

	void deleteStudent(Integer sid);


}
