package com.github.jbence1994.calendarium.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.jbence1994.calendarium.user.RegistrationRequestTestObject.notSanitizedRegistrationRequest;
import static com.github.jbence1994.calendarium.user.RegistrationRequestTestObject.notSanitizedRegistrationRequestWithNullMiddleName;
import static com.github.jbence1994.calendarium.user.UserTestConstants.CONFIRM_PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestConstants.EMAIL;
import static com.github.jbence1994.calendarium.user.UserTestConstants.FIRST_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.LAST_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.MIDDLE_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestConstants.PHONE_NUMBER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@ExtendWith(MockitoExtension.class)
public class RegistrationRequestSanitizerTests {

    @InjectMocks
    private RegistrationRequestSanitizer registrationRequestSanitizer;

    @Test
    public void sanitizeTest_1() {
        var result = registrationRequestSanitizer.sanitize(notSanitizedRegistrationRequest());

        assertThat(result.getEmail(), equalTo(EMAIL));
        assertThat(result.getPassword(), equalTo(PASSWORD));
        assertThat(result.getConfirmPassword(), equalTo(CONFIRM_PASSWORD));
        assertThat(result.getFirstName(), equalTo(FIRST_NAME));
        assertThat(result.getMiddleName(), equalTo(MIDDLE_NAME));
        assertThat(result.getLastName(), equalTo(LAST_NAME));
        assertThat(result.getPhoneNumber(), equalTo(PHONE_NUMBER));
    }

    @Test
    public void sanitizeTest_2() {
        var result = registrationRequestSanitizer.sanitize(notSanitizedRegistrationRequestWithNullMiddleName());

        assertThat(result.getEmail(), equalTo(EMAIL));
        assertThat(result.getPassword(), equalTo(PASSWORD));
        assertThat(result.getConfirmPassword(), equalTo(CONFIRM_PASSWORD));
        assertThat(result.getFirstName(), equalTo(FIRST_NAME));
        assertThat(result.getMiddleName(), is(nullValue()));
        assertThat(result.getLastName(), equalTo(LAST_NAME));
        assertThat(result.getPhoneNumber(), equalTo(PHONE_NUMBER));
    }
}
