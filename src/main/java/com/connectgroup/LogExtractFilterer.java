package com.connectgroup;

import java.io.Reader;
import java.util.Collection;

/**
 * Contract for log extract filter.
 *
 * @author kyranrana
 */
public interface LogExtractFilterer {

  /**
   * Filters logs in source by country.
   *
   * @param source Source.
   * @param country Country.
   * @return Logs for {@code country}
   */
  Collection<?> filterByCountry(Reader source, String country);

  /**
   * Filters logs in source by country and response time above limit.
   *
   * @param source Source.
   * @param country Country.
   * @param limit Limit (ms)
   * @return Logs for {@code country} with response time above {@code limit}
   */
  Collection<?> filterByCountryWithResponseTimeAboveLimit(
      Reader source, String country, long limit);

  /**
   * Filters logs in source by response time above average.
   *
   * @param source Source.
   * @return Logs with response time above average.
   */
  Collection<?> filterByResponseTimeAboveAverage(Reader source);
}
