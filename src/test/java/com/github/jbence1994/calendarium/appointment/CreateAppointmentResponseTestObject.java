package com.github.jbence1994.calendarium.appointment;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_DESCRIPTION;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ID;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ORGANIZER;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;

public final class CreateAppointmentResponseTestObject {
    public static CreateAppointmentResponse createAppointmentResponse() {
        return new CreateAppointmentResponse(
                APPOINTMENT_ID,
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION,
                APPOINTMENT_ORGANIZER
        );
    }
}
