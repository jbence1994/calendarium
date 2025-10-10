package com.github.jbence1994.calendarium.appointment;

import com.github.jbence1994.calendarium.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_DESCRIPTION;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ID;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;
import static com.github.jbence1994.calendarium.user.UserTestObject.user;

public final class AppointmentTestObject {
    public static Appointment appointmentWithoutId() {
        return buildAppointment(null, null);
    }

    public static Appointment appointmentWithId() {
        return buildAppointment(APPOINTMENT_ID, user());
    }

    private static Appointment buildAppointment(UUID id, User user) {
        return new Appointment(
                id,
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION,
                user,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new ArrayList<>()
        );
    }
}
