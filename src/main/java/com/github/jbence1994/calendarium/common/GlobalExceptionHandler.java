package com.github.jbence1994.calendarium.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<Set<ValidationErrorDto>> handleValidationErrors(MethodArgumentNotValidException exception) {
        var validationErrors = new HashSet<ValidationErrorDto>();

        exception.getBindingResult().getFieldErrors().forEach(error ->
                validationErrors.add(new ValidationErrorDto(error.getField(), error.getDefaultMessage()))
        );

        return ResponseEntity.badRequest().body(validationErrors);
    }
}
