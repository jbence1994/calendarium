package com.github.jbence1994.calendarium.common;

import com.github.jbence1994.calendarium.appointment.CreateAppointmentRequest;
import com.github.jbence1994.calendarium.appointment.StartDateBeforeEndDateValidation;
import com.github.jbence1994.calendarium.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
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

        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                validationErrors.add(new ValidationErrorDto(fieldError.getField(), fieldError.getDefaultMessage()))
        );

        exception.getAllErrors().forEach(objectError -> {
            var defaultMessage = CreateAppointmentRequest.class.getAnnotation(StartDateBeforeEndDateValidation.class).message();

            if (defaultMessage.equals(objectError.getDefaultMessage())) {
                validationErrors.add(new ValidationErrorDto("appointment.startDate", objectError.getDefaultMessage()));
            } else {
                validationErrors.add(new ValidationErrorDto(objectError.getObjectName(), objectError.getDefaultMessage()));
            }
        });

        return ResponseEntity.badRequest().body(validationErrors);
    }

    @ExceptionHandler(exception = {UserNotFoundException.class})
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(exception.getMessage()));
    }
}
