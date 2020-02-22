package com.connectgroup.converter;

/**
 * Contract for converter classes.
 *
 * @param <T> Type to convert from.
 * @param <U> Type to convert to.
 * @author kyranrana
 */
public interface Converter<T, U> {

  /**
   * Converts {@link T} to {@link U}.
   *
   * @param subject Subject as {@link T}.
   * @return Subject as {@link U}.
   */
  U convert(T subject);
}
