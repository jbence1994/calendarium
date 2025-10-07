package com.github.jbence1994.calendarium.common;

import com.github.jbence1994.calendarium.user.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static com.github.jbence1994.calendarium.common.FieldErrorTestObject.fieldError;
import static com.github.jbence1994.calendarium.common.ObjectErrorTestObject.objectError1;
import static com.github.jbence1994.calendarium.common.ObjectErrorTestObject.objectError2;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTests {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    public void handleValidationErrorsTest_WithFieldError() {
        var bindingResult = mock(BindingResult.class);
        var exception = mock(MethodArgumentNotValidException.class);

        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError()));
        when(exception.getBindingResult()).thenReturn(bindingResult);

        var result = globalExceptionHandler.handleValidationErrors(exception);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody().size(), equalTo(1));
        assertThat(result.getBody().stream().toList().getFirst().field(), equalTo("name"));
        assertThat(result.getBody().stream().toList().getFirst().message(), equalTo("Name must be not empty."));
    }

    @Test
    public void handleValidationErrorsTest_WithObjectError_1() {
        var bindingResult = mock(BindingResult.class);
        var exception = mock(MethodArgumentNotValidException.class);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(exception.getAllErrors()).thenReturn(List.of(objectError1()));

        var result = globalExceptionHandler.handleValidationErrors(exception);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody().size(), equalTo(1));
        assertThat(result.getBody().stream().toList().getFirst().field(), equalTo("appointment.startDate"));
        assertThat(result.getBody().stream().toList().getFirst().message(), equalTo("Start date must before end date."));
    }

    @Test
    public void handleValidationErrorsTest_WithObjectError_2() {
        var bindingResult = mock(BindingResult.class);
        var exception = mock(MethodArgumentNotValidException.class);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(exception.getAllErrors()).thenReturn(List.of(objectError2()));

        var result = globalExceptionHandler.handleValidationErrors(exception);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody().size(), equalTo(1));
        assertThat(result.getBody().stream().toList().getFirst().field(), equalTo("objectError"));
        assertThat(result.getBody().stream().toList().getFirst().message(), equalTo("ObjectError message."));
    }

    @Test
    public void handleUserNotFoundExceptionTest() {
        var result = globalExceptionHandler.handleUserNotFoundException(new UserNotFoundException(1L));

        assertThat(result.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody().error(), equalTo("No user was found with the given ID: #1."));
    }
}
