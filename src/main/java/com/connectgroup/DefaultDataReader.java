package com.connectgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default data reader.
 *
 * @author kyranrana
 */
public class DefaultDataReader implements DataReader {

  @Override
  public List<String> readAllLines(Reader source) {
    List<String> lines;

    try (BufferedReader reader = new BufferedReader(source)) {
      lines = reader.lines().collect(Collectors.toList());
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }

    return lines;
  }
}
