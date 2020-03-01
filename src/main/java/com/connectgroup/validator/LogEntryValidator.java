package com.connectgroup.validator;

import com.connectgroup.exception.InvalidLogEntryException;
import com.connectgroup.exception.ValidatorException;
import com.connectgroup.model.CountryCode;

public class LogEntryValidator implements Validator {

  @Override
  public void validate(String subject) throws ValidatorException {
    String[] parts = subject.split(" *, *");

    String exceptionMessage = "Expected format: {requestedTimestamp},{countryCode},{responseTime}";

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
