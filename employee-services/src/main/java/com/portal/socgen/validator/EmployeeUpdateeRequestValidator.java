package com.portal.socgen.validator;

import com.portal.socgen.data.model.Employee;
import com.portal.socgen.error.InvalidRequestException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUpdateeRequestValidator implements CreateRequestValidator<Employee> {

    public void validate(Employee employee) throws InvalidRequestException {
        if (employee == null) throw new InvalidRequestException("Invalid request object");
        if (employee.getId() <= 0) {
            throw new InvalidRequestException("Invalid identifier");
        }
    }
}
