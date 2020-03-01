package com.connectgroup;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import com.connectgroup.converter.StringToLogEntryConverter;
import com.connectgroup.validator.LogEntryValidator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class DefaultLogExtractFiltererIntegrationTest {

  private final LogExtractFilterer logExtractFilterer;

  public DefaultLogExtractFiltererIntegrationTest() {
    logExtractFilterer =
        new DefaultLogExtractFilterer(new StringToLogEntryConverter(), new LogEntryValidator());
  }

  @Test
  public void shouldReturnEmptyCollection_WhenLogFileIsEmpty() throws FileNotFoundException {
    assertTrue(
        logExtractFilterer.filterByCountry(openFile("src/test/resources/empty"), "GB").isEmpty());
  }

  @Test
  public void shouldReturnCollectionWithUSEntries_WhenLogFileIsFilteredByUSCountryCode()
      throws FileNotFoundException {

    assertEquals(
        Arrays.asList(
            "1433190845,US,539",
            "1433666287,US,789",
            "1432484176,US,850",
            "1432485178,US,450",
            "1432486178,US,344"),
        logExtractFilterer.filterByCountry(openFile("src/test/resources/multi-lines"), "US"));
  }

  @Test
  public void shouldReturnCollectionWithGBEntries_WhenLogFileIsFilteredByGBCountryCode()
      throws FileNotFoundException {

    assertEquals(
        Collections.singletonList("1432917066,GB,37"),
        logExtractFilterer.filterByCountry(openFile("src/test/resources/multi-lines"), "GB"));
  }

  @Test
  public void
      shouldReturnCollectionWithUSEntriesAboveLimit_WhenLogFileIsFilteredByUSCountryCodeAndLimit500()
          throws FileNotFoundException {

    assertEquals(
        Arrays.asList("1433190845,US,539", "1433666287,US,789", "1432484176,US,850"),
        logExtractFilterer.filterByCountryWithResponseTimeAboveLimit(
            openFile("src/test/resources/multi-lines"), "US", 500L));
  }

  @Test
  public void
      shouldReturnCollectionWithDEEntriesAboveLimit_WhenLogFileIsFilteredByDECountryCodeAndLimit450()
          throws FileNotFoundException {

    assertEquals(
        Collections.singletonList("1432364063,DE,455"),
        logExtractFilterer.filterByCountryWithResponseTimeAboveLimit(
            openFile("src/test/resources/multi-lines"), "DE", 450L));
  }

  @Test
  public void
      shouldReturnCollectionWithEntriesAboveResponseTimeAvg_WhenLogFileIsFilteredByEntriesAboveResponseTimeAvg()
          throws FileNotFoundException {

    assertEquals(
        Arrays.asList(
            "1432917066,GB,37",
            "1432364076,DE,415",
            "1432485178,US,450",
            "1432486178,US,344",
            "1432364097,DE,450",
            "1432364063,DE,455"),
        logExtractFilterer.filterByResponseTimeAboveAverage(
            openFile("src/test/resources/multi-lines")));
  }

  private FileReader openFile(String filename) throws FileNotFoundException {
    return new FileReader(new File(filename));
  }
}
