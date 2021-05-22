package org.system.control.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.system.control.exception.ApiException;
import org.system.control.exception.ErrorCode;
import org.system.control.service.AccessService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AccessController {
    private final AccessService accessService;

    @GetMapping(value = "check", produces = "text/plain;charset=UTF-8")
    public String check(@RequestParam String roomId, @RequestParam String entrance, @RequestParam String keyId) throws ApiException {
        try {
            return accessService.process(roomId, Boolean.parseBoolean(entrance), keyId);
        } catch (IllegalArgumentException e) {
            log.error("Internal controller error, cause={}", e.toString());
            return ErrorCode.error.getStringValue();
        }
    }
}
