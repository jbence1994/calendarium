package com.github.jbence1994.calendarium.appointment;

import com.github.jbence1994.calendarium.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AuthService authService;

    @Override
    public void createAppointment(Appointment appointment) {
        var currentUser = authService.getCurrentUser();

        appointment.setOrganizer(currentUser);

        appointmentRepository.save(appointment);
    }
}
