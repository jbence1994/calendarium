package com.github.jbence1994.calendarium.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordManager passwordManager;
    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new PhoneNumberAlreadyExistsException(user.getPhoneNumber());
        }

        user.setPassword(passwordManager.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }
}
