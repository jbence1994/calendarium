package com.github.jbence1994.calendarium.common;

import org.springframework.validation.ObjectError;

public final class ObjectErrorTestObject {
    public static ObjectError objectError() {
        return new ObjectError("appointmentDto", "Start date must before end date.");
    }
}
