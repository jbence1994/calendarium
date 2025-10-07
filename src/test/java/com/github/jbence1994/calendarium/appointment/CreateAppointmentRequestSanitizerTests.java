package com.github.jbence1994.calendarium.appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_DESCRIPTION;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.notSanitizedCreateAppointmentRequestWithoutId;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.notSanitizedCreateAppointmentRequestWithoutIdAndDescription;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@ExtendWith(MockitoExtension.class)
public class CreateAppointmentRequestSanitizerTests {

    @InjectMocks
    private CreateAppointmentRequestSanitizer createAppointmentRequestSanitizer;

    @Test
    public void sanitizeTest_WithDescription() {
        var result = createAppointmentRequestSanitizer.sanitize(notSanitizedCreateAppointmentRequestWithoutId());

        assertThat(result.getName(), equalTo(APPOINTMENT_NAME));
        assertThat(result.getDescription(), equalTo(APPOINTMENT_DESCRIPTION));
    }

    @Test
    public void sanitizeTest_WithoutDescription() {
        var result = createAppointmentRequestSanitizer.sanitize(notSanitizedCreateAppointmentRequestWithoutIdAndDescription());

        assertThat(result.getName(), equalTo(APPOINTMENT_NAME));
        assertThat(result.getDescription(), is(nullValue()));
    }
}
