package com.connectgroup.converter;

import com.connectgroup.model.CountryCode;
import com.connectgroup.model.LogEntry;

public class StringToLogEntryConverter implements Converter<String, LogEntry> {

  @Override
  public LogEntry convert(String subject) {
    String[] parts = subject.split(" *, *");

    long requestedTimestamp = Long.parseLong(parts[0]);
    CountryCode countryCode = CountryCode.valueOf(parts[1]);
    long responseTime = Long.parseLong(parts[2]);

    return new LogEntry(requestedTimestamp, countryCode, responseTime);
  }
}
