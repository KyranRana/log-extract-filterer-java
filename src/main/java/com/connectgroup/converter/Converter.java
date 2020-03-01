package com.connectgroup.converter;

public interface Converter<T, R> {

  R convert(T subject);
}
