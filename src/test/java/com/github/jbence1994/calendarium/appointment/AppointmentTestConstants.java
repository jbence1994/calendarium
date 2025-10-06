package com.github.jbence1994.calendarium.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AppointmentTestConstants {
    UUID APPOINTMENT_ID = UUID.fromString("6198ccd7-c323-4734-b134-051b75120e7c");
    String APPOINTMENT_NAME = "Appointment#1";
    String APPOINTMENT_DESCRIPTION = "Appointment description.";
    LocalDateTime APPOINTMENT_START_DATE = LocalDateTime.of(2025, 10, 6, 10, 0, 0);
    LocalDateTime APPOINTMENT_END_DATE = LocalDateTime.of(2025, 10, 6, 11, 0, 0);
}
