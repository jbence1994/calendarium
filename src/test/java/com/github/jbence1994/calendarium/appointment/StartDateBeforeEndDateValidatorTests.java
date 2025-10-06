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

import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.appointmentDtoWithNullEndDate;
import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.appointmentDtoWithNullStartDate;
import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.appointmentDtoWithoutId;
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
                Arguments.of("AppointmentDto is null", null),
                Arguments.of("Start date is null", appointmentDtoWithNullStartDate()),
                Arguments.of("End date is null", appointmentDtoWithNullEndDate())
        );
    }

    @Test
    public void isValidTest_HappyPath() {
        var result = startDateBeforeEndDateValidator.isValid(appointmentDtoWithoutId(), context);

        assertThat(result, is(true));
    }

    @ParameterizedTest(name = "{index} => {0}")
    @MethodSource("isNotValidParams")
    public void isValidTest_UnhappyPaths(
            String testCase,
            AppointmentDto appointmentDto
    ) {
        var result = startDateBeforeEndDateValidator.isValid(appointmentDto, context);

        assertThat(result, is(false));
    }
}
