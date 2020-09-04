package com.portal.socgen.validator;

import com.portal.socgen.data.model.Employee;
import com.portal.socgen.error.InvalidRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EmployeeCreateRequestValidator implements CreateRequestValidator<Employee> {

    public void validate(Employee employee) throws InvalidRequestException {
        if (employee == null) throw new InvalidRequestException("Invalid request object");
        if (StringUtils.isEmpty(employee.getFirstName())) {
            throw new InvalidRequestException("Invalid Fist Name");
        } else if (StringUtils.isEmpty(employee.getLastName())) {
            throw new InvalidRequestException("Invalid Last Name");
        } else if (StringUtils.isEmpty(employee.getGender())) {
            throw new InvalidRequestException("Invalid Gender");
        } else if (StringUtils.isEmpty(employee.getDateOfBirth())) {
            throw new InvalidRequestException("Invalid Date of Birth");
        } else if (StringUtils.isEmpty(employee.getDepartment())) {
            throw new InvalidRequestException("Invalid Department");
        }
    }
}
