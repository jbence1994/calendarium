package com.github.jbence1994.calendarium.appointment;

import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoSanitizer {

    public AppointmentDto sanitize(AppointmentDto appointmentDto) {
        return new AppointmentDto(
                appointmentDto.getId(),
                appointmentDto.getName().trim(),
                appointmentDto.getDescription() != null ? appointmentDto.getDescription().trim() : null,
                appointmentDto.getStartDate(),
                appointmentDto.getEndDate()
        );
    }
}
