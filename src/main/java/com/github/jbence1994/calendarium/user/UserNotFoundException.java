package com.github.jbence1994.calendarium.user;

public final class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("No user was found with the given ID: #%d.", id));
    }
}
