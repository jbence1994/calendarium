package com.github.jbence1994.calendarium.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static com.github.jbence1994.calendarium.user.RegistrationRequestTestObject.notSanitizedRegistrationRequest;
import static com.github.jbence1994.calendarium.user.RegistrationRequestTestObject.registrationRequest;
import static com.github.jbence1994.calendarium.user.RegistrationResponseTestObject.registrationResponse;
import static com.github.jbence1994.calendarium.user.UserTestObject.user;
import static com.github.jbence1994.calendarium.user.UserTestObject.userAfterMappingFromDto;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Mock
    private RegistrationRequestSanitizer registrationRequestSanitizer;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserController userController;

    @Test
    public void registerUserTest() {
        when(registrationRequestSanitizer.sanitize(any())).thenReturn(registrationRequest());

        when(userMapper.toEntity(any())).thenReturn(userAfterMappingFromDto());
        when(userService.registerUser(any())).thenReturn(user());

        var result = userController.registerUser(notSanitizedRegistrationRequest());

        assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(result.getBody(), not(nullValue()));
        assertThat(result.getBody().id(), equalTo(registrationResponse().id()));
        assertThat(result.getBody().email(), equalTo(registrationResponse().email()));

        verify(registrationRequestSanitizer, times(1)).sanitize(any());
        verify(userMapper, times(1)).toEntity(any());
    }
}
