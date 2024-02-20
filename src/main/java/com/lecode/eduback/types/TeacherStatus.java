package com.lecode.eduback.types;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum TeacherStatus {

  ACTIVE("A"),
  LOCKED("L"),
  RESIGNED("R"),
  EMPTY("E");

  @EnumValue
  private final String code;

  TeacherStatus(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public static TeacherStatus fromCode(String code) {
    for (TeacherStatus status : TeacherStatus.values()) {
      if (status.getCode()
                .equals(code)) {
        return status;
      }
    }
    return TeacherStatus.EMPTY;
  }

}
