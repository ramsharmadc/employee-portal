package com.portal.socgen.controller;

import com.portal.socgen.data.model.Employee;
import com.portal.socgen.error.EmployeeNotFoundException;
import com.portal.socgen.error.InvalidRequestException;
import com.portal.socgen.handler.EmployeeHandler;
import com.portal.socgen.validator.EmployeeCreateRequestValidator;
import com.portal.socgen.validator.EmployeeGetRequestValidator;
import com.portal.socgen.validator.EmployeeUpdateeRequestValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/portal/employee")
public class EmployeePortalController {

    private static final Logger LOGGER = LogManager.getLogger(EmployeePortalController.class);

    @Autowired
    private EmployeeHandler employeeHandler;

    @Autowired
    private EmployeeCreateRequestValidator createRequestValidator;

    @Autowired
    private EmployeeGetRequestValidator getRequestValidator;

    @Autowired
    private EmployeeUpdateeRequestValidator updateRequestValidator;

    @RequestMapping(
            value = "/get/{id}",
            method = {RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Employee>> getEmployee(@PathVariable(value = "id") long id)
            throws EmployeeNotFoundException, InvalidRequestException {
        getRequestValidator.validate(id);
        LOGGER.info("Fetching Employee for id - {}", id);
        List<Employee> employees = employeeHandler.getEmployee(id);
        return ResponseEntity.ok().body(employees);
    }

    @RequestMapping(
            value = "/get",
            method = {RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Employee>> getAllEmployee() {
        LOGGER.info("Fetching all employees");
        List<Employee> employeeList = employeeHandler.getEmployees();
        return ResponseEntity.ok().body(employeeList);
    }

    @RequestMapping(
            value = "/create",
            method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee)
            throws InvalidRequestException {
        createRequestValidator.validate(employee);
        LOGGER.info("Creating Employee - {}", employee);
        Employee createdEmployee = employeeHandler.createEmployee(employee);
        if (createdEmployee.getId() != 0) {
            return ResponseEntity.ok().body(createdEmployee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(employee);
        }
    }

    @RequestMapping(
            value = "/delete",
            method = {RequestMethod.PUT},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> deleteEmployee(@Valid @RequestBody Employee employee)
            throws InvalidRequestException {
        updateRequestValidator.validate(employee);
        LOGGER.info("Deleting Employee for request - {}", employee);
        employeeHandler.deleteEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = {RequestMethod.PUT},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") long id)
            throws InvalidRequestException {
        LOGGER.info("Deleting Employee - {}", id);
        employeeHandler.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}