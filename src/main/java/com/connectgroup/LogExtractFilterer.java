package com.connectgroup;

import java.io.Reader;
import java.util.Collection;

public interface LogExtractFilterer {

  Collection<?> filterByCountry(Reader source, String country);

  Collection<?> filterByCountryWithResponseTimeAboveLimit(
      Reader source, String country, long limit);

  Collection<?> filterByResponseTimeAboveAverage(Reader source);
}
