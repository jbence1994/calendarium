package com.github.jbence1994.calendarium.appointment;

import java.util.UUID;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ID;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;

public final class AppointmentDtoTestObject {
    public static AppointmentDto appointmentDtoWithoutId() {
        return buildAppointmentDto(null);
    }

    public static AppointmentDto appointmentDtoWithId() {
        return buildAppointmentDto(APPOINTMENT_ID);
    }

    private static AppointmentDto buildAppointmentDto(UUID id) {
        return new AppointmentDto(id, APPOINTMENT_NAME, APPOINTMENT_START_DATE, APPOINTMENT_END_DATE);
    }
}
