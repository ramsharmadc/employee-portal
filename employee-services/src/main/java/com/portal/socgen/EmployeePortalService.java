package com.portal.socgen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePortalService {

    private static final Logger LOGGER = LogManager.getLogger(EmployeePortalService.class);

    public static void main(String[] args) {

        LOGGER.info("STARTING EMPLOYEE PORTAL SERVICE");
        SpringApplication.run(EmployeePortalService.class, args);
    }
}
