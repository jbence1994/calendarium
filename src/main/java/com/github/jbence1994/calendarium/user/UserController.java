package com.github.jbence1994.calendarium.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final RegistrationRequestSanitizer registrationRequestSanitizer;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody RegistrationRequest request) {
        var sanitizedRequest = registrationRequestSanitizer.sanitize(request);

        var user = userMapper.toEntity(sanitizedRequest);

        var registeredUser = userService.registerUser(user);

        var response = new RegistrationResponse(registeredUser.getId(), registeredUser.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
