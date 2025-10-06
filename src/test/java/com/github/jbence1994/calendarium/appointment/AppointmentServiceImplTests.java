package com.github.jbence1994.calendarium.appointment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestObject.appointmentWithId;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestObject.appointmentWithoutId;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceImplTests {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Test
    public void createProductTest() {
        when(appointmentRepository.save(any())).thenReturn(appointmentWithId());

        assertDoesNotThrow(() -> appointmentService.createAppointment(appointmentWithoutId()));

        verify(appointmentRepository, times(1)).save(any());
    }
}