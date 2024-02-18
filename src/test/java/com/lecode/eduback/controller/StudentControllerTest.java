package com.lecode.eduback.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import java.util.Optional;
import com.lecode.eduback.common.MessageService;
import com.lecode.eduback.model.DummyStudent;
import com.lecode.eduback.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MessageService messageService;

  @MockBean
  private StudentService studentService;

  private StudentController studentController;


//  static Stream<Arguments> getStudentProvider() {
//    return Stream.of(
//        Arguments.of(1, HttpStatus.OK, Student.builder()
//                                                .sid(200).build()),
//        Arguments.of(2, HttpStatus.OK, null)
//        ) ;
//  }
//
//  @ParameterizedTest
//  @MethodSource("getStudentProvider")
////  @MethodSource("com.lecode.eduback.TestDataProvider#argStudents")
//  void getStudentTest(int sid, HttpStatus expectedStatus, Student expectedStudent) throws Exception {
//      when(studentService.getOptById(sid)).thenReturn(Optional.ofNullable(expectedStudent));
//      when(messageService.getProperty("student.not_found")).thenReturn("Student not found");
//
//    mockMvc.perform(get("/api/v1/students/{sid}", sid))
//        .andExpect(status().is(expectedStatus.value()));
//  }


  @Test
  void getStudentById_ValidId_ReturnOK() throws Exception {
    Integer sid = 1;
    when(studentService.getOptById(sid)).thenReturn(DummyStudent.dummyStudentOptional());
    mockMvc.perform(get("/api/v1/students/" + sid))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.status", is("OK")));
  }

  @Test
  void getStudentById_NonexistId_ReturnOK() throws Exception {
    Integer sid = 1;
    when(studentService.getOptById(sid)).thenReturn(Optional.empty());
    when(messageService.getProperty("student.not_found")).thenReturn("Student not found");
    mockMvc.perform(get("/api/v1/students/" + sid))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.status", is("OK")))
           .andExpect(jsonPath("$.message", is("Student not found")));
  }

  @Test
  void getStudentById_InvalidId_ReturnBadRequest() throws Exception {
    String sid = "invalid";

    mockMvc.perform(get("/api/v1/students/" + sid))
           .andExpect(status().isBadRequest());
  }

//  @Test
//  public void testCreateStudent() {
//    StudentDTO studentDTO = DummyStudentDTO.dummyStudentDTO()
//                                           .get();
//    // Set properties for studentDTO as needed
//
//    Student student = StudentDTO.toEntity(studentDTO);
//
//    when(studentService.save(any(Student.class))).thenReturn(true);
//    when(messageService.getProperty("success")).thenReturn("Success");
//
//    ResponseEntity<?> response = studentController.createStudent(studentDTO);
//
//    assertEquals(HttpStatus.OK, response.getStatusCode());
//    verify(studentService, times(1)).save(student);
//    verify(messageService, times(1)).getProperty("success");
//  }
//
//  @Test
//  public void testCreateStudentFailure() {
//    StudentDTO studentDTO = DummyStudentDTO.dummyStudentDTO()
//                                           .get();
//    Student student = StudentDTO.toEntity(studentDTO);
//
//    when(studentService.save(any(Student.class))).thenReturn(false);
//    when(messageService.getProperty("failure")).thenReturn("Failure");
//
//    ResponseEntity<?> response = studentController.createStudent(studentDTO);
//
//    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//    verify(studentService, times(1)).save(StudentDTO.toEntity(studentDTO));
//    verify(messageService, times(1)).getProperty("failure");
//  }
}