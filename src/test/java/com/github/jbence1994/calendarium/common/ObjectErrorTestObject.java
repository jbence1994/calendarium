package com.github.jbence1994.calendarium.common;

import org.springframework.validation.ObjectError;

public final class ObjectErrorTestObject {
    public static ObjectError objectError1() {
        return new ObjectError("appointmentDto", "Start date must before end date.");
    }

    public static ObjectError objectError2() {
        return new ObjectError("objectError", "ObjectError message.");
    }
}
