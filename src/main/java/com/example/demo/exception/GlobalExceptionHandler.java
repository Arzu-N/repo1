package com.example.demo.exception;

import com.example.demo.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(NotFound.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDto>notValid(NotFound exp){
    ExceptionDto exceptionDto = new ExceptionDto(HttpStatus.NOT_FOUND,exp.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
}

}
