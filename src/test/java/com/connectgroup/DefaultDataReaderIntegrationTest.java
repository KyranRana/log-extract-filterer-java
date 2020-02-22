package com.connectgroup;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import org.junit.Test;

public class DefaultDataReaderIntegrationTest {

  private DataReader dataReader;

  public DefaultDataReaderIntegrationTest() {
    dataReader = new DefaultDataReader();
  }

  @Test
  public void shouldReturnNoLines_WhenFileIsEmpty() throws FileNotFoundException {
    assertTrue(dataReader.readAllLines(openFile("src/test/resources/empty")).isEmpty());
  }

  @Test
  public void shouldReturnAllLines_WhenFileIsNotEmpty() throws FileNotFoundException {
    assertEquals(
        Arrays.asList(
            "REQUEST_TIMESTAMP,COUNTRY_CODE,RESPONSE_TIME",
            "1433190845,US,539",
            "1432917066,GB,37",
            "1433666287,US,789",
            "1432484176,US,850",
            "1432364076,DE,415",
            "1432485178,US,450",
            "1432486178,US,344",
            "1432364097,DE,450",
            "1432364063,DE,455"),
        dataReader.readAllLines(openFile("src/test/resources/multi-lines")));
  }

  private FileReader openFile(String filename) throws FileNotFoundException {
    return new FileReader(new File(filename));
  }
}
