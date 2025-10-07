package com.github.jbence1994.calendarium.appointment;

import org.springframework.stereotype.Component;

@Component
public class CreateAppointmentRequestSanitizer {

    public CreateAppointmentRequest sanitize(CreateAppointmentRequest request) {
        return new CreateAppointmentRequest(
                request.getName().trim(),
                request.getStartDate(),
                request.getEndDate(),
                request.getDescription() != null ? request.getDescription().trim() : null
        );
    }
}
