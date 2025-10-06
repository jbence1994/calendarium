package com.github.jbence1994.calendarium.user;

import static com.github.jbence1994.calendarium.user.UserTestConstants.CONFIRM_PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestConstants.EMAIL;
import static com.github.jbence1994.calendarium.user.UserTestConstants.FIRST_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.INVALID_CONFIRM_PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestConstants.LAST_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.MIDDLE_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestConstants.PHONE_NUMBER;

public final class RegistrationRequestTestObject {
    public static RegistrationRequest registrationRequest() {
        return new RegistrationRequest(
                EMAIL,
                PASSWORD,
                CONFIRM_PASSWORD,
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER
        );
    }

    public static RegistrationRequest notSanitizedRegistrationRequest() {
        return new RegistrationRequest(
                " " + EMAIL + " ",
                " " + PASSWORD + " ",
                " " + CONFIRM_PASSWORD + " ",
                " " + FIRST_NAME + " ",
                " " + MIDDLE_NAME + " ",
                " " + LAST_NAME + " ",
                " " + PHONE_NUMBER + " "
        );
    }

    public static RegistrationRequest notSanitizedRegistrationRequestWithNullMiddleName() {
        return new RegistrationRequest(
                " " + EMAIL + " ",
                " " + PASSWORD + " ",
                " " + CONFIRM_PASSWORD + " ",
                " " + FIRST_NAME + " ",
                null,
                " " + LAST_NAME + " ",
                " " + PHONE_NUMBER + " "
        );
    }

    public static RegistrationRequest registrationRequestWithInvalidConfirmPassword() {
        return new RegistrationRequest(
                EMAIL,
                PASSWORD,
                INVALID_CONFIRM_PASSWORD,
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER
        );
    }

    public static RegistrationRequest registrationRequestWithNullPassword() {
        return new RegistrationRequest(
                EMAIL,
                null,
                INVALID_CONFIRM_PASSWORD,
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER
        );
    }

    public static RegistrationRequest registrationRequestWithNullConfirmPassword() {
        return new RegistrationRequest(
                EMAIL,
                PASSWORD,
                null,
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER
        );
    }

    public static RegistrationRequest registrationRequestWithBlankPassword() {
        return new RegistrationRequest(
                EMAIL,
                " ",
                CONFIRM_PASSWORD,
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER
        );
    }

    public static RegistrationRequest registrationRequestWithBlankConfirmPassword() {
        return new RegistrationRequest(
                EMAIL,
                PASSWORD,
                " ",
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER
        );
    }
}
