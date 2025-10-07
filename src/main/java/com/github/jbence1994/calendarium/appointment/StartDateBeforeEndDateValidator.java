package com.github.jbence1994.calendarium.appointment;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartDateBeforeEndDateValidator implements ConstraintValidator<StartDateBeforeEndDateValidation, CreateAppointmentRequest> {

    @Override
    public void initialize(StartDateBeforeEndDateValidation startDateBeforeEndDateValidation) {
    }

    @Override
    public boolean isValid(CreateAppointmentRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (request == null || request.getStartDate() == null || request.getEndDate() == null) {
            return false;
        }

        return request.getStartDate().isBefore(request.getEndDate());
    }
}
