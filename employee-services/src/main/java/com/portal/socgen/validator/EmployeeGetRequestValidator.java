package com.portal.socgen.validator;

import com.portal.socgen.error.InvalidRequestException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeGetRequestValidator implements GetRequestValidator<Long> {

    public void validate(Long id) throws InvalidRequestException {
        if (id <= 0) {
            throw new InvalidRequestException("Invalid identifier");
        }
    }
}
