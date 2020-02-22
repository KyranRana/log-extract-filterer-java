package com.connectgroup.validator;

import com.connectgroup.exception.ValidatorException;

/**
 * Contract for validator classes.
 *
 * @author kyranrana
 */
public interface Validator {

  /**
   * Validates subject is in the correct format.
   *
   * @param subject Subject.
   */
  void validate(String subject) throws ValidatorException;
}
