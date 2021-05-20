package org.system.control.exception;

import lombok.Getter;

public enum ErrorCode {
  allow("200"),
  deny("403"),
  error("500");

  @Getter
  private final String stringValue;

  ErrorCode(String stringValue) {
    this.stringValue = stringValue;
  }
}
