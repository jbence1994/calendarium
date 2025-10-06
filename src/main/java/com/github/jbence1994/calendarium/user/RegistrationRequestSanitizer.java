package com.github.jbence1994.calendarium.user;

import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestSanitizer {

    public RegistrationRequest sanitize(RegistrationRequest request) {
        return new RegistrationRequest(
                request.getEmail().trim(),
                request.getPassword().trim(),
                request.getConfirmPassword().trim(),
                request.getFirstName().trim(),
                request.getMiddleName() != null ? request.getMiddleName().trim() : null,
                request.getLastName().trim(),
                request.getPhoneNumber().trim()
        );
    }
}
