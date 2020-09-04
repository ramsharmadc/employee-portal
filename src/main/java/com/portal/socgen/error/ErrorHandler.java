package com.portal.socgen.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(EmployeeNotFoundException e, WebRequest r) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), e.getMessage(), r.getDescription(true));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<?> invalidRequestException(InvalidRequestException e, WebRequest r) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), e.getMessage(), r.getDescription(true));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errorHandler(Exception e, WebRequest r) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), e.getMessage(), r.getDescription(true));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
