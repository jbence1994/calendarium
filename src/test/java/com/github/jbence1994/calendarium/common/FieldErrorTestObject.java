package com.github.jbence1994.calendarium.common;

import org.springframework.validation.FieldError;

public final class FieldErrorTestObject {
    public static FieldError fieldError() {
        return new FieldError("CreateAppointmentRequest", "name", "Name must be not empty.");
    }
}
