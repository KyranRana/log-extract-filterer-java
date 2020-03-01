package com.connectgroup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LogEntry {

  private long requestedTimestamp;
  private CountryCode countryCode;
  private long responseTime;

  @Override
  public String toString() {
    return String.format("%d,%s,%d", requestedTimestamp, countryCode, responseTime);
  }
}
