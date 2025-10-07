package com.github.jbence1994.calendarium.user;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.github.jbence1994.calendarium.user.UserTestConstants.EMAIL;
import static com.github.jbence1994.calendarium.user.UserTestConstants.FIRST_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.HASHED_PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestConstants.LAST_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.MIDDLE_NAME;
import static com.github.jbence1994.calendarium.user.UserTestConstants.PHONE_NUMBER;

public final class UserTestObject {
    public static User user() {
        return buildUser(1L);
    }

    public static User userAfterMappingFromDto() {
        return buildUser(null);
    }

    private static User buildUser(Long id) {
        return new User(
                id,
                EMAIL,
                HASHED_PASSWORD,
                FIRST_NAME,
                MIDDLE_NAME,
                LAST_NAME,
                PHONE_NUMBER,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new ArrayList<>()
        );
    }
}
