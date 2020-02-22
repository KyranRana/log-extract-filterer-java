package com.connectgroup;

import java.io.Reader;
import java.util.List;

/**
 * Contract for data reader.
 *
 * @author kyranrana
 */
public interface DataReader {

  /**
   * Reads and returns all lines from a source.
   *
   * @param source Source.
   * @return Lines
   */
  List<String> readAllLines(Reader source);
}
