package com.connectgroup.converter;

import com.connectgroup.model.CountryCode;
import com.connectgroup.model.LogEntry;

/**
 * Converts {@link String} to {@link LogEntry}.
 *
 * @author kyranrana
 */
public class StringToLogEntryConverter implements Converter<String, LogEntry> {

  /**
   * Converts {@link String} to {@link LogEntry}
   *
   * @param subject Subject as {@link String}.
   * @return Subject as {@link LogEntry}
   */
  @Override
  public LogEntry convert(String subject) {
    String[] parts = subject.split(" *, *");

    long requestTime = Long.parseLong(parts[0]);
    CountryCode countryCode = CountryCode.valueOf(parts[1]);
    long responseTime = Long.parseLong(parts[2]);

    return new LogEntry(requestTime, countryCode, responseTime);
  }
}
