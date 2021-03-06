package com.connectgroup.util;

import static org.junit.Assert.assertEquals;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;

public class FileUtilIntegrationTest {

  @Test
  public void readFileLineByLine_whereFileDoesExist_streamVariation() throws Exception {
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
        FileUtil.readFileLineByLine(
            new InputStreamReader(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResourceAsStream("multi-lines")))));
  }
}
