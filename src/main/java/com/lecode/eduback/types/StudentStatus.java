package com.lecode.eduback.types;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StudentStatus {

  ACTIVE("A"),
  CHURNED("C"),
  EMPTY("");

  @EnumValue
  private final String code;

  StudentStatus(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public static StudentStatus fromCode(String code) {
    for (StudentStatus status : StudentStatus.values()) {
      if (status.getCode()
                .equals(code)) {
        return status;
      }
    }
    return StudentStatus.EMPTY;
  }

}
