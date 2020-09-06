package com.portal.socgen.handler;

import com.portal.socgen.common.ResultSorter;
import com.portal.socgen.data.model.Employee;
import com.portal.socgen.data.repository.EmployeeRepository;
import com.portal.socgen.error.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeHandlerImpl implements EmployeeHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployee(long id) throws EmployeeNotFoundException {
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found for id - " + id)));
        return employeeList;
    }

    @Override
    public List<Employee> getEmployees() {
        return new LinkedList<>(employeeRepository.findAll(ResultSorter.firstNameAscendingOrder()));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
