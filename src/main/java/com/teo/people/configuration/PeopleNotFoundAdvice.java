package com.teo.people.configuration;

import com.teo.people.exception.PeopleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * handler to show the exception msg
 */
@ControllerAdvice
public class PeopleNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PeopleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String PeopleNotFoundHandler(PeopleNotFoundException ex) {
        return ex.getMessage();
    }
}
