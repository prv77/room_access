package org.system.control.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.system.control.dto.entity.Key;
import org.system.control.dto.repository.KeyRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class KeyService {
    private final KeyRepository keyRepository;

    public Key findKeyById(Long id) {
        return keyRepository.findById(id).orElse(null);
    }
}
