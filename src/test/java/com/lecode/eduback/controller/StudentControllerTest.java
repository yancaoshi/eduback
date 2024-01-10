package com.lecode.eduback.controller;

import com.lecode.eduback.dto.DummyStudentDTO;
import com.lecode.eduback.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	void givenValidId_WhenGetStudentById_thenRetur200() throws Exception {
		String sid = "1";
		when(studentService.getStudentById(Integer.parseInt(sid))).thenReturn(DummyStudentDTO.dummyStudentDTO().get());
		mockMvc.perform(get("/api/v1/student/" + sid))
						.andExpect(status().isOk());
	}

	@Test
	void givenInalidId_WhenGetStudentById_thenReturn400() throws Exception {
		String sid = "abc";
//		when(messageSource.getMessage("student.sid.invalid", null, LocaleContextHolder.getLocale())).thenReturn("Invalid ID");

		mockMvc.perform(get("/api/v1/student/" + sid))
						.andExpect(status().isBadRequest());
	}

}