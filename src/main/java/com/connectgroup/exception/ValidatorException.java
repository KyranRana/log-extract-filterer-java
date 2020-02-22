package com.connectgroup.exception;

/**
 * Represents an unchecked exception thrown by a validator class.
 *
 * @author kyranrana
 */
public class ValidatorException extends RuntimeException {

  public ValidatorException(String message) {
    super(message);
  }
}
