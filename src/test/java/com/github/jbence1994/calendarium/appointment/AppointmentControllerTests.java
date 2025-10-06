package com.github.jbence1994.calendarium.appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.appointmentDtoWithId;
import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.appointmentDtoWithoutId;
import static com.github.jbence1994.calendarium.appointment.AppointmentDtoTestObject.notSanitizedAppointmentDtoWithoutId;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestObject.appointmentWithoutId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentControllerTests {

    @Mock
    private AppointmentDtoSanitizer appointmentDtoSanitizer;

    @Mock
    private AppointmentService appointmentService;

    @Mock
    private AppointmentMapper appointmentMapper;

    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    public void createProductTest() {
        when(appointmentDtoSanitizer.sanitize(any())).thenReturn(appointmentDtoWithoutId());
        when(appointmentMapper.toEntity(any())).thenReturn(appointmentWithoutId());
        doNothing().when(appointmentService).createAppointment(any());

        var result = appointmentController.createAppointment(notSanitizedAppointmentDtoWithoutId());

        assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody(), allOf(
                hasProperty("name", equalTo(appointmentDtoWithId().getName())),
                hasProperty("startDate", equalTo(appointmentDtoWithId().getStartDate())),
                hasProperty("endDate", equalTo(appointmentDtoWithId().getEndDate()))
        ));

        verify(appointmentMapper, times(1)).toEntity(any());
        verify(appointmentService, times(1)).createAppointment(any());
    }
}
