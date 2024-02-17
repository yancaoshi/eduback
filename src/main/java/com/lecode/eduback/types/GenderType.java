package com.lecode.eduback.types;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GenderType {

  MALE("M"),
  FEMALE("F"),
  EMPTY("");

  @EnumValue
  private final String code;

  GenderType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public static GenderType fromCode(String code) {
    for (GenderType gender : GenderType.values()) {
      if (gender.getCode().equals(code)) {
        return gender;
      }
    }
    return GenderType.EMPTY;
  }

}
