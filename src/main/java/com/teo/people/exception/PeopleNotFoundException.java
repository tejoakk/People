package com.teo.people.exception;

/**
 * custom exceptions
 */
public class PeopleNotFoundException extends RuntimeException{

    public PeopleNotFoundException(Long id) {
        super("Could not find person by id:  " + id);
    }

    public PeopleNotFoundException(String name) {
        super("Could not find person by name: " + name);
    }
}
