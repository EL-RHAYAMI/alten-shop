package com.alten.shop.handlers;

import com.alten.shop.dots.responses.ErrorDto;
import com.alten.shop.exceptions.EntityAlreadyExistException;
import com.alten.shop.exceptions.FieldNotFoundException;
import com.alten.shop.exceptions.ObjectNotValidException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException e) {
        return ResponseEntity.badRequest().body(ErrorDto.builder()
                .timestamp(new Date())
                .httpCode(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build());
    }

    @ResponseStatus(HttpStatus.FOUND)
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ErrorDto handleException(EntityAlreadyExistException e) {
        return ErrorDto.builder()
                .timestamp(new Date())
                .httpCode(HttpStatus.FOUND)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<?> handleException(ObjectNotValidException e) {
        return ResponseEntity
                .badRequest()
                .body(e.getErrorMessages());
    }


    @ExceptionHandler(FieldNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(FieldNotFoundException e) {
        ErrorDto err = ErrorDto.builder()
                .timestamp(new Date())
                .httpCode(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(err);
    }


}
