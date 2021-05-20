package org.system.control.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public String handleApiException(ApiException exception) {
        return exception.getErrorCode().getStringValue();
    }
}
