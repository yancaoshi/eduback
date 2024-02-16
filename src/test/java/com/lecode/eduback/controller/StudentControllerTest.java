package com.lecode.eduback.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.lecode.eduback.dto.DummyStudentDTO;
import com.lecode.eduback.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MessageSource messageSource;

	@MockBean
	private StudentService studentService;

	private StudentController studentController;


	@Test
	void getStudentById_ValidId_ReturnOK() throws Exception {
		String sid = "1";
		when(studentService.getStudentById(Integer.parseInt(sid))).thenReturn(DummyStudentDTO.dummyStudentDTO());
		mockMvc.perform(get("/api/v1/student/" + sid))
						.andExpect(status().isOk());
	}

	@Test
	void getStudentById_InvalidId_ReturnBadRequest() throws Exception {
		String sid = "-1";
//		when(messageSource.getMessage("student.sid.invalid", null, LocaleContextHolder.getLocale())).thenReturn("Invalid ID");
		when(studentService.getStudentById(Integer.parseInt(sid))).thenReturn(DummyStudentDTO.dummyStudentDTO());

		mockMvc.perform(get("/api/v1/student/" + sid))
						.andExpect(status().isBadRequest());
	}

}