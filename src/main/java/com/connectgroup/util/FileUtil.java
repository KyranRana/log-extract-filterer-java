package com.connectgroup.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

  public static List<String> readFileLineByLine(Reader source) throws IOException {
    List<String> lines;

    try (BufferedReader reader = new BufferedReader(source)) {
      lines = reader.lines().collect(Collectors.toList());
    }

    return lines;
  }
}
