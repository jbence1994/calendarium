package com.github.jbence1994.calendarium.appointment;

import java.util.UUID;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ID;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;

public final class AppointmentTestObject {
    public static Appointment appointmentWithoutId() {
        return buildAppointment(null);
    }

    public static Appointment appointmentWithId() {
        return buildAppointment(APPOINTMENT_ID);
    }

    private static Appointment buildAppointment(UUID id) {
        return new Appointment(id, APPOINTMENT_NAME, APPOINTMENT_START_DATE, APPOINTMENT_END_DATE, null, null);
    }
}
