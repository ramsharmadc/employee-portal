package com.portal.socgen;

import com.portal.socgen.data.model.Employee;
import com.portal.socgen.error.InvalidRequestException;
import com.portal.socgen.validator.EmployeeCreateRequestValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class ValidatorTest {

    EmployeeCreateRequestValidator createRequestValidator;

    @Before
    public void setup() {
        createRequestValidator = new EmployeeCreateRequestValidator();
    }

    @Test
    public void testCreateRequestValidation() {

        //valid request
        Employee alex = new Employee("alex", "shan", "M", Calendar.getInstance().getTime(), "Tech");

        try {
            createRequestValidator.validate(alex);
            Assert.assertEquals(true, true);
        } catch (InvalidRequestException e) {
            Assert.assertTrue("Invalid request", false);
        }

        // invalid request
        Employee alex2 = new Employee("alex", "", "M", Calendar.getInstance().getTime(), "Tech");

        try {
            createRequestValidator.validate(alex2);
            Assert.assertEquals(true, false);
        } catch (InvalidRequestException e) {
            Assert.assertTrue("Invalid request", true);
        }
    }
}
