package com.lecode.eduback.exception;

import com.lecode.eduback.common.ApiResponse;
import com.lecode.eduback.common.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageService messageService;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers,
                                                                HttpStatusCode status,
                                                                WebRequest request) {
    ApiResponse apiResponse = ApiResponse.builder()
                                         .status(HttpStatus.BAD_REQUEST)
                                         .message(
                                             messageService.getProperty("response.bad_request"))
//                                         .data(log.isDebugEnabled() ? ex.getMessage() :
//                                             request.getParameterMap())
                                         .data(request.getParameterMap())
                                         .build();
    return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
  }


}
