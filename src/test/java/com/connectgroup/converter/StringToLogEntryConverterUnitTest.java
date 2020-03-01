package com.connectgroup.converter;

import static junit.framework.TestCase.assertEquals;

import com.connectgroup.model.CountryCode;
import com.connectgroup.model.LogEntry;
import org.junit.Test;

public class StringToLogEntryConverterUnitTest {

  private StringToLogEntryConverter stringToLogEntryConverter;

  public StringToLogEntryConverterUnitTest() {
    this.stringToLogEntryConverter = new StringToLogEntryConverter();
  }

  @Test
  public void shouldConvert_WhenStringIsInCorrectFormat() {
    LogEntry actualLogEntry = stringToLogEntryConverter.convert("1433190845,US,539");

    assertEquals(1433190845L, actualLogEntry.getRequestedTimestamp());
    assertEquals(CountryCode.US, actualLogEntry.getCountryCode());
    assertEquals(539L, actualLogEntry.getResponseTime());
  }
}
