package com.github.jbence1994.calendarium.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateAppointmentResponse(
        UUID id,
        String name,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String description,
        String organizer
) {
}
