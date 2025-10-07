package com.github.jbence1994.calendarium.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.jbence1994.calendarium.user.UserTestConstants.HASHED_PASSWORD;
import static com.github.jbence1994.calendarium.user.UserTestObject.user;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {

    @Mock
    private PasswordManager passwordManager;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void registerUserTest_HappyPath() {
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(passwordManager.encode(any())).thenReturn(HASHED_PASSWORD);
        when(userRepository.save(any())).thenReturn(user());

        assertDoesNotThrow(() -> userService.registerUser(user()));

        verify(userRepository, times(1)).existsByEmail(any());
        verify(passwordManager, times(1)).encode(any());
        verify(userRepository, times(1)).save(any());
    }

    @Test
    public void registerUserTest_UnhappyPath_EmailAlreadyExistsException() {
        when(userRepository.existsByEmail(any())).thenReturn(true);

        var result = assertThrows(
                EmailAlreadyExistsException.class,
                () -> userService.registerUser(user())
        );

        assertThat(result.getMessage(), equalTo("Email address 'juhasz.bence.zsolt@gmail.com' is already in use. Please use a different."));

        verify(userRepository, times(1)).existsByEmail(any());
        verify(userRepository, never()).existsByPhoneNumber(any());
        verify(passwordManager, never()).encode(any());
        verify(userRepository, never()).save(any());
    }

    @Test
    public void registerUserTest_UnhappyPath_PhoneNumberAlreadyExistsException() {
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(userRepository.existsByPhoneNumber(any())).thenReturn(true);

        var result = assertThrows(
                PhoneNumberAlreadyExistsException.class,
                () -> userService.registerUser(user())
        );

        assertThat(result.getMessage(), equalTo("Phone number '+36501323566' is already registered. Please use a different."));

        verify(userRepository, times(1)).existsByEmail(any());
        verify(userRepository, times(1)).existsByPhoneNumber(any());
        verify(passwordManager, never()).encode(any());
        verify(userRepository, never()).save(any());
    }
}
