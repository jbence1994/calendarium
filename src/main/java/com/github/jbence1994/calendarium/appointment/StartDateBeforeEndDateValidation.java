package com.github.jbence1994.calendarium.appointment;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = StartDateBeforeEndDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartDateBeforeEndDateValidation {
    String message() default "Start date must before end date.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
