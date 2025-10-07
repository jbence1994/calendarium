package com.github.jbence1994.calendarium.appointment;

import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_DESCRIPTION;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_END_DATE;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_ID;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_NAME;
import static com.github.jbence1994.calendarium.appointment.AppointmentTestConstants.APPOINTMENT_START_DATE;

public final class AppointmentDtoTestObject {
    public static AppointmentDto notSanitizedAppointmentDtoWithoutIdAndDescription() {
        return new AppointmentDto(
                null,
                " " + APPOINTMENT_NAME + " ",
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                null
        );
    }

    public static AppointmentDto notSanitizedAppointmentDtoWithoutId() {
        return new AppointmentDto(
                null,
                " " + APPOINTMENT_NAME + " ",
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                " " + APPOINTMENT_DESCRIPTION + " "
        );
    }

    public static AppointmentDto appointmentDtoWithoutId() {
        return new AppointmentDto(
                null,
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION
        );
    }

    public static AppointmentDto appointmentDtoWithId() {
        return new AppointmentDto(
                APPOINTMENT_ID,
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION
        );
    }

    public static AppointmentDto appointmentDtoWithNullStartDate() {
        return new AppointmentDto(
                null,
                APPOINTMENT_NAME,
                null,
                APPOINTMENT_END_DATE,
                APPOINTMENT_DESCRIPTION
        );
    }

    public static AppointmentDto appointmentDtoWithNullEndDate() {
        return new AppointmentDto(
                APPOINTMENT_ID,
                APPOINTMENT_NAME,
                APPOINTMENT_START_DATE,
                null,
                APPOINTMENT_DESCRIPTION
        );
    }
}
