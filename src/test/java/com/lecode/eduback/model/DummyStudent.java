package com.lecode.eduback.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.lecode.eduback.types.GenderType;
import com.lecode.eduback.types.StudentStatus;

public class DummyStudent {

  public static Student dummyStudent() {
    return Student.builder()
                  .sid(1)
                  .sno("1001")
                  .sname("李小明")
                  .snick("明明")
                  .sbirth(LocalDate.of(2020, 1, 1))
                  .sgender(GenderType.MALE)
                  .sschool("实验小学")
                  .saddress("浦东新区新金桥路")
                  .sfamily("父母")
                  .sfname("李白")
                  .sfmobile("13512345678")
                  .ssource("ABC")
                  .sstatus(StudentStatus.ACTIVE)
                  .snote("Note")
                  .build();
  }

  public static Optional<Student> dummyStudentOptional() {
    return Optional.of(dummyStudent());
  }

  public static List<Student> dummyStudentList() {
    List<Student> studentList = new ArrayList<Student>();
    Student student = Student.builder()
                             .sid(1)
                             .sno("1001")
                             .sname("李小明")
                             .snick("明明")
                             .sbirth(LocalDate.of(2020, 1, 1))
                             .sgender(GenderType.MALE)
                             .sschool("实验小学")
                             .saddress("浦东新区新金桥路")
                             .sfamily("父母")
                             .sfname("李白")
                             .sfmobile("13512345678")
                             .ssource("ABC")
                             .sstatus(StudentStatus.ACTIVE)
                             .snote("Note")
                             .build();
    studentList.add(student);

    student = Student.builder()
                     .sid(2)
                     .sno("1002")
                     .sname("王小红")
                     .snick("红红")
                     .sbirth(LocalDate.of(2018, 11, 11))
                     .sgender(GenderType.FEMALE)
                     .sschool("实验小学")
                     .saddress("浦东新区新金桥路")
                     .sfamily("父母")
                     .sfname("王朝")
                     .sfmobile("13512345678")
                     .ssource("ABC")
                     .sstatus(StudentStatus.ACTIVE)
                     .snote("Note")
                     .build();
    studentList.add(student);

    student = Student.builder()
                     .sid(3)
                     .sno("1003")
                     .sname("张小强")
                     .snick("强强")
                     .sbirth(LocalDate.of(2019, 5, 20))
                     .sgender(GenderType.MALE)
                     .sschool("实验小学")
                     .saddress("浦东新区新金桥路")
                     .sfamily("父母")
                     .sfname("张三")
                     .sfmobile("13512345678")
                     .ssource("ABC")
                     .sstatus(StudentStatus.ACTIVE)
                     .snote("Note")
                     .build();

    studentList.add(student);
    return studentList;
  }

  public static Optional<List<Student>> dummyStudentListOptional() {
    return Optional.of(dummyStudentList());
  }


}
