package com.connectgroup.validator;

import com.connectgroup.exception.ValidatorException;

public interface Validator {

  void validate(String subject) throws ValidatorException;
}
