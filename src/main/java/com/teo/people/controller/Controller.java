package com.teo.people.controller;

import com.teo.people.exception.PeopleNotFoundException;
import com.teo.people.model.People;
import com.teo.people.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for people resource and directly invoking repository as
 * not
 * implementing the custom business logic in service classes
 */
@CrossOrigin
@RestController
class Controller {

    @Autowired
    private final PeopleRepository repository;

    Controller(PeopleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/people")
    List<People> all() {
        return repository.findAll();
    }

    @GetMapping("/people/{id}")
    People getPerson(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException(id));
    }

    //TODO: for now using react text filter instead of search api
//    @GetMapping("/people/")
//    People getByName(@RequestParam String name) {
//        return repository.findByFirstNameIgnoreCase(name)
//                .orElseThrow(() -> new PeopleNotFoundException(name));
//
//    }

}
