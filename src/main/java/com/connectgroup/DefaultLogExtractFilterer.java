package com.connectgroup;

import com.connectgroup.converter.StringToLogEntryConverter;
import com.connectgroup.model.CountryCode;
import com.connectgroup.model.LogEntry;
import com.connectgroup.validator.LogEntryValidator;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default log extract filterer.
 *
 * @author kyranrana
 */
public class DefaultLogExtractFilterer implements LogExtractFilterer {

  private final DataReader dataReader;
  private final StringToLogEntryConverter stringToLogEntryConverter;
  private final LogEntryValidator logEntryValidator;

  public DefaultLogExtractFilterer(
      DataReader dataReader,
      StringToLogEntryConverter stringToLogEntryConverter,
      LogEntryValidator logEntryValidator) {

    this.dataReader = dataReader;
    this.stringToLogEntryConverter = stringToLogEntryConverter;
    this.logEntryValidator = logEntryValidator;
  }

  @Override
  public Collection<?> filterByCountry(Reader source, String country) {
    return getLogEntries(source).stream()
        .filter(entry -> entry.getCountryCode().equals(CountryCode.valueOf(country)))
        .map(LogEntry::toString)
        .collect(Collectors.toList());
  }

  @Override
  public Collection<?> filterByCountryWithResponseTimeAboveLimit(
      Reader source, String country, long limit) {
    return getLogEntries(source).stream()
        .filter(
            entry ->
                entry.getCountryCode().equals(CountryCode.valueOf(country))
                    && entry.getResponseTime() > limit)
        .map(LogEntry::toString)
        .collect(Collectors.toList());
  }

  @Override
  public Collection<?> filterByResponseTimeAboveAverage(Reader source) {
    List<LogEntry> logEntries = getLogEntries(source);

    long averageResponseTime =
        logEntries.stream().mapToLong(LogEntry::getResponseTime).sum() / logEntries.size();

    return logEntries.stream()
        .filter(entry -> entry.getResponseTime() < averageResponseTime)
        .map(LogEntry::toString)
        .collect(Collectors.toList());
  }

  /**
   * Gets log entries from {@code source}.
   *
   * @param source Source.
   * @return Log entries.
   */
  private List<LogEntry> getLogEntries(Reader source) {
    return dataReader.readAllLines(source).stream()
        .skip(1)
        .peek(logEntryValidator::validate)
        .map(stringToLogEntryConverter::convert)
        .collect(Collectors.toList());
  }
}
