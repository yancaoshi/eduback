package com.lecode.eduback.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lecode.eduback.model.Student;
import com.lecode.eduback.types.GenderType;
import com.lecode.eduback.types.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

  @JsonProperty("StudentId")
  private Integer sid;

  @JsonProperty("StudentNo")
  @NotNull
  @Size(max = 10, message = "{student.no.length}")
  private String sno;

  @JsonProperty("Name")
  @Size(max = 16)
  private String sname;

  @JsonProperty("Nick")
  private String snick;

  @JsonProperty("Birthday")
  private LocalDate sbirth;

  @JsonProperty("Gender")
  private GenderType sgender;

  @JsonProperty("School")
  @Size(max = 20)
  private String sschool;

  @JsonProperty("Address")
  @Size(max = 45)
  private String saddress;

  @JsonProperty("GuardianType")
  @Size(max = 10)
  private String sfamily;

  @JsonProperty("ParentName")
  @Size(max = 20)
  private String sfname;

  @JsonProperty("ParentPhone")
  @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "{student.mobile.malformed}")
  private String sfmobile;

  @JsonProperty("Source")
  @Size(max = 10)
  private String ssource;

  @JsonProperty("Status")
  private StudentStatus sstatus;

  @JsonProperty("Note")
  @Size(max = 100, message = "")
  private String snote;

  // create method fromEntity to map Student to StudentDTO
  public static StudentDTO fromEntity(Student student) {
    return StudentDTO.builder()
                     .sid(student.getSid())
                     .sno(student.getSno())
                     .sname(student.getSname())
                     .snick(student.getSnick())
                     .sbirth(student.getSbirth())
                     .sgender(student.getSgender())
                     .sschool(student.getSschool())
                     .saddress(student.getSaddress())
                     .sfamily(student.getSfamily())
                     .sfname(student.getSfname())
                     .sfmobile(student.getSfmobile())
                     .ssource(student.getSsource())
                     .sstatus(student.getSstatus())
                     .snote(student.getSnote())
                     .build();
  }

  public static Student toEntity(StudentDTO studentDTO) {
    return Student.builder()
                  .sid(studentDTO.getSid())
                  .sno(studentDTO.getSno())
                  .sname(studentDTO.getSname())
                  .snick(studentDTO.getSnick())
                  .sbirth(studentDTO.getSbirth())
                  .sgender(studentDTO.getSgender())
                  .sschool(studentDTO.getSschool())
                  .saddress(studentDTO.getSaddress())
                  .sfamily(studentDTO.getSfamily())
                  .sfname(studentDTO.getSfname())
                  .sfmobile(studentDTO.getSfmobile())
                  .ssource(studentDTO.getSsource())
                  .sstatus(studentDTO.getSstatus())
                  .snote(studentDTO.getSnote())
                  .build();
  }

}
