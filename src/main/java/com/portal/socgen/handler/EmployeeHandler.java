package com.portal.socgen.handler;

import com.portal.socgen.data.model.Employee;
import com.portal.socgen.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeHandler {

    List<Employee> getEmployee(long id) throws EmployeeNotFoundException;

    List<Employee> getEmployees();

    Employee createEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void deleteEmployee(long id);
}
