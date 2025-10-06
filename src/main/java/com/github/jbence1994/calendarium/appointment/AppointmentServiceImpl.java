package com.github.jbence1994.calendarium.appointment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Override
    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
