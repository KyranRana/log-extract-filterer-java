package com.connectgroup.validator;

import com.connectgroup.exception.InvalidLogEntryException;
import com.connectgroup.exception.ValidatorException;
import com.connectgroup.model.CountryCode;

/**
 * Validates a log entry.
 *
 * @author kyranrana
 */
public class LogEntryValidator implements Validator {

  /**
   * Validates log entry is in the correct format.
   *
   * @param subject Subject.
   */
  @Override
  public void validate(String subject) throws ValidatorException {
    String[] parts = subject.split(" *, *");

    String exceptionMessage = "A log entry must be in the format: {requestedTime},{countryCode},{responseTime}";

    if (parts.length != 3) {
      throw new InvalidLogEntryException(exceptionMessage);
    }

    try {
      Long.parseLong(parts[0]);
      CountryCode.valueOf(parts[1]);
      Long.parseLong(parts[2]);
    } catch (IllegalArgumentException e) {
      throw new InvalidLogEntryException(exceptionMessage);
    }
  }
}
