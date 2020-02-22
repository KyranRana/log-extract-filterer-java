package com.connectgroup.model;

import java.util.Objects;

/**
 * Represents a log entry.
 *
 * @author kyranrana
 */
public class LogEntry {

  private long requestTime;
  private CountryCode countryCode;
  private long responseTime;

  public LogEntry(long requestTime, CountryCode countryCode, long responseTime) {
    this.requestTime = requestTime;
    this.countryCode = countryCode;
    this.responseTime = responseTime;
  }

  public long getRequestTime() {
    return requestTime;
  }

  public CountryCode getCountryCode() {
    return countryCode;
  }

  public long getResponseTime() {
    return responseTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogEntry logEntry = (LogEntry) o;
    return requestTime == logEntry.requestTime &&
        responseTime == logEntry.responseTime &&
        countryCode == logEntry.countryCode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestTime, countryCode, responseTime);
  }

  @Override
  public String toString() {
    return String.format("%d,%s,%d", requestTime, countryCode, responseTime);
  }
}
