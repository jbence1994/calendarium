package com.github.jbence1994.calendarium.appointment;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.createAppointmentRequestWithNullEndDate;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.createAppointmentRequestWithNullStartDate;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.createAppointmentRequestWithoutId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class StartDateBeforeEndDateValidatorTests {

    @Mock
    private ConstraintValidatorContext context;

    @InjectMocks
    private StartDateBeforeEndDateValidator startDateBeforeEndDateValidator;

    @BeforeEach
    public void setUp() {
        startDateBeforeEndDateValidator.initialize(mock(StartDateBeforeEndDateValidation.class));
    }

    private static Stream<Arguments> isNotValidParams() {
        return Stream.of(
                Arguments.of("CreateAppointmentRequest is null", null),
                Arguments.of("Start date is null", createAppointmentRequestWithNullStartDate()),
                Arguments.of("End date is null", createAppointmentRequestWithNullEndDate())
        );
    }

    @Test
    public void isValidTest_HappyPath() {
        var result = startDateBeforeEndDateValidator.isValid(createAppointmentRequestWithoutId(), context);

        assertThat(result, is(true));
    }

    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("isNotValidParams")
    public void isValidTest_UnhappyPaths(
            String testCase,
            CreateAppointmentRequest request
    ) {
        var result = startDateBeforeEndDateValidator.isValid(request, context);

        assertThat(result, is(false));
    }
}
