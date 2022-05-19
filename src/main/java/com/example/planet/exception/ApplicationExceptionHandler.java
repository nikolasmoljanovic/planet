package com.example.planet.exception;

import com.example.planet.exception.badrequest.ResourceBadRequestException;
import com.example.planet.exception.notfound.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ResourceNotFoundException.class})
  public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest webRequest) {
    return handleExceptionInternal(
        e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
  }

  @ExceptionHandler({ResourceBadRequestException.class})
  public ResponseEntity<Object> handleBadRequestException(Exception e, WebRequest webRequest) {
    return handleExceptionInternal(
        e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
  }
}
