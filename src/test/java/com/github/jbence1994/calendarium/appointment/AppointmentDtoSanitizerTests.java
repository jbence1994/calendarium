package com.github.jbence1994.calendarium.appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.notSanitizedAppointmentDtoWithoutId;
import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.notSanitizedAppointmentDtoWithoutIdAndDescription;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_DESCRIPTION;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@ExtendWith(MockitoExtension.class)
public class AppointmentDtoSanitizerTests {

    @InjectMocks
    private AppointmentDtoSanitizer appointmentDtoSanitizer;

    @Test
    public void sanitizeTest_AppointmentDtoWithDescription() {
        var result = appointmentDtoSanitizer.sanitize(notSanitizedAppointmentDtoWithoutId());

        assertThat(result.getName(), equalTo(APPOINTMENT_NAME));
        assertThat(result.getDescription(), equalTo(APPOINTMENT_DESCRIPTION));
    }

    @Test
    public void sanitizeTest_AppointmentDtoWithoutDescription() {
        var result = appointmentDtoSanitizer.sanitize(notSanitizedAppointmentDtoWithoutIdAndDescription());

        assertThat(result.getName(), equalTo(APPOINTMENT_NAME));
        assertThat(result.getDescription(), is(nullValue()));
    }
}
