package org.system.control.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
  private final ErrorCode errorCode;

  public ApiException(ErrorCode errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public ApiException(String s, ErrorCode errorCode) {
    super(s);
    this.errorCode = errorCode;
  }
}