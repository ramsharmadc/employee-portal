package com.portal.socgen.validator;

import com.portal.socgen.error.InvalidRequestException;

public interface GetRequestValidator<T> {

    void validate(T t) throws InvalidRequestException;
}
