package com.lecode.eduback.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {

  @JsonProperty("status")
  @Builder.Default
  private HttpStatus status = HttpStatus.OK;

  @JsonProperty("message")
  @Builder.Default
  private String message = "成功";

  @JsonProperty("data")
  private Object data;

}
