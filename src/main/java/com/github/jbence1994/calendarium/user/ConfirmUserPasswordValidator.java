package com.github.jbence1994.calendarium.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConfirmUserPasswordValidator implements ConstraintValidator<ConfirmUserPassword, RegistrationRequest> {

    @Override
    public void initialize(ConfirmUserPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(RegistrationRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (
                request == null ||
                        request.getPassword() == null ||
                        request.getConfirmPassword() == null
        ) {
            return false;
        }

        if (request.getPassword().isBlank() || request.getConfirmPassword().isBlank()) {
            return false;
        }

        return request.getPassword().equals(request.getConfirmPassword());
    }
}
