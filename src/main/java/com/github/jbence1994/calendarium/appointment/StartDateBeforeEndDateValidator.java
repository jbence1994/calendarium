package com.github.jbence1994.calendarium.appointment;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartDateBeforeEndDateValidator implements ConstraintValidator<StartDateBeforeEndDateValidation, AppointmentDto> {

    @Override
    public void initialize(StartDateBeforeEndDateValidation startDateBeforeEndDateValidation) {
    }

    @Override
    public boolean isValid(AppointmentDto appointmentDto, ConstraintValidatorContext constraintValidatorContext) {
        if (appointmentDto == null || appointmentDto.getStartDate() == null || appointmentDto.getEndDate() == null) {
            return false;
        }

        return appointmentDto.getStartDate().isBefore(appointmentDto.getEndDate());
    }
}
