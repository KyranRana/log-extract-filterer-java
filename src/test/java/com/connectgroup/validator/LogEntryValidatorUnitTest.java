package com.connectgroup.validator;

import com.connectgroup.exception.InvalidLogEntryException;
import org.junit.Test;

public class LogEntryValidatorUnitTest {

  private LogEntryValidator logEntryValidator;

  public LogEntryValidatorUnitTest() {
    this.logEntryValidator = new LogEntryValidator();
  }

  @Test(expected = InvalidLogEntryException.class)
  public void shouldThrowException_WhenRequestedTimeIsInvalid() {
    logEntryValidator.validate("INVALID,US,415");
  }

  @Test(expected = InvalidLogEntryException.class)
  public void shouldThrowException_WhenCountryCodeIsInvalid() {
    logEntryValidator.validate("1432364076,INVALID,415");
  }

  @Test(expected = InvalidLogEntryException.class)
  public void shouldThrowException_WhenResponseTimeIsInvalid() {
    logEntryValidator.validate("1432364076,US,INVALID");
  }

  @Test
  public void shouldValidate_WhenFormatIsValid() {
    logEntryValidator.validate("1433190845,US,539");
    logEntryValidator.validate("1432917066,GB,37");
    logEntryValidator.validate("1432364076,DE,415");
  }
}
