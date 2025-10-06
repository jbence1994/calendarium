package com.github.jbence1994.calendarium.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ID;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;

public final class AppointmentDtoTestObject {
    public static AppointmentDto appointmentDtoWithoutId() {
        return buildAppointmentDto(null, APPOINTMENT_START_DATE, APPOINTMENT_END_DATE);
    }

    public static AppointmentDto appointmentDtoWithId() {
        return buildAppointmentDto(APPOINTMENT_ID, APPOINTMENT_START_DATE, APPOINTMENT_END_DATE);
    }

    public static AppointmentDto appointmentDtoWithNullStartDate() {
        return buildAppointmentDto(null, null, APPOINTMENT_END_DATE);
    }

    public static AppointmentDto appointmentDtoWithNullEndDate() {
        return buildAppointmentDto(APPOINTMENT_ID, APPOINTMENT_START_DATE, null);
    }

    private static AppointmentDto buildAppointmentDto(UUID id, LocalDateTime startDate, LocalDateTime endDate) {
        return new AppointmentDto(id, APPOINTMENT_NAME, startDate, endDate);
    }
}
