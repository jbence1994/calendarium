package com.github.jbence1994.calendarium.appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestObject.appointmentWithId;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestObject.appointmentWithoutId;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.createAppointmentRequestWithoutId;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentRequestTestObject.notSanitizedCreateAppointmentRequestWithoutId;
import static com.github.jbence1994.calendarium.appointment.CreateAppointmentResponseTestObject.createAppointmentResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentControllerTests {

    @Mock
    private CreateAppointmentRequestSanitizer createAppointmentRequestSanitizer;

    @Mock
    private AppointmentService appointmentService;

    @Mock
    private AppointmentMapper appointmentMapper;

    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    public void createAppointmentTest() {
        when(createAppointmentRequestSanitizer.sanitize(any())).thenReturn(createAppointmentRequestWithoutId());
        when(appointmentMapper.toEntity(any())).thenReturn(appointmentWithoutId());
        when(appointmentService.createAppointment(any())).thenReturn(appointmentWithId());
        when(appointmentMapper.toResponse(any())).thenReturn(createAppointmentResponse());

        var result = appointmentController.createAppointment(notSanitizedCreateAppointmentRequestWithoutId());

        assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody().id(), equalTo(appointmentWithId().getId()));
        assertThat(result.getBody().name(), equalTo(appointmentWithId().getName()));
        assertThat(result.getBody().startDate(), equalTo(appointmentWithId().getStartDate()));
        assertThat(result.getBody().endDate(), equalTo(appointmentWithId().getEndDate()));
        assertThat(result.getBody().organizer(), not(nullValue()));

        verify(createAppointmentRequestSanitizer, times(1)).sanitize(any());
        verify(appointmentMapper, times(1)).toEntity(any());
        verify(appointmentService, times(1)).createAppointment(any());
        verify(appointmentMapper, times(1)).toResponse(any());
    }
}
