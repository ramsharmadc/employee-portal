package com.portal.socgen.validator;

import com.portal.socgen.error.InvalidRequestException;
import org.springframework.data.util.Pair;

public interface UpdateRequestValidator<T> {

    Pair<Boolean, String> validate(T t) throws InvalidRequestException;
}
