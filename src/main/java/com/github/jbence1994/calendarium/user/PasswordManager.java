package com.github.jbence1994.calendarium.user;

public interface PasswordManager {
    String encode(String rawPassword);

    boolean verify(String rawPassword, String hashedPassword);
}
