package org.system.control.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.system.control.dto.entity.User;
import org.system.control.dto.repository.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public boolean isAccessGranted(Long roomId, Long userId) {
        return (userId % roomId) == 0 ;
    }
}
