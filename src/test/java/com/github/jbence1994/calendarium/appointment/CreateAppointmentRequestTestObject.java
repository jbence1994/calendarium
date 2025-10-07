package com.github.jbence1994.calendarium.appointment;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_DESCRIPTION;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;

public final class CreateAppointmentRequestTestObject {
    public static CreateAppointmentRequest notSanitizedCreateAppointmentRequestWithoutIdAndDescription() {
        return new CreateAppointmentRequest(
                " " + APPOINTMENT_NAME + " ",
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                null
        );
    }

    public static CreateAppointmentRequest notSanitizedCreateAppointmentRequestWithoutId() {
        return new CreateAppointmentRequest(
                " " + APPOINTMENT_NAME + " ",
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                " " + APPOINTMENT_DESCRIPTION + " "
        );
    }

    public static CreateAppointmentRequest createAppointmentRequestWithoutId() {
        return new CreateAppointmentRequest(
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION
        );
    }

    public static CreateAppointmentRequest createAppointmentRequestWithId() {
        return new CreateAppointmentRequest(
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION
        );
    }

    public static CreateAppointmentRequest createAppointmentRequestWithNullStartDate() {
        return new CreateAppointmentRequest(
                APPOINTMENT_NAME,
                null,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION
        );
    }

    public static CreateAppointmentRequest createAppointmentRequestWithNullEndDate() {
        return new CreateAppointmentRequest(
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                null,
                APPOINTMENT_DESCRIPTION
        );
    }
}
