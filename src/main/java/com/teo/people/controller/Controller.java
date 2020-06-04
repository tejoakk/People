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

//    @PostMapping("/people")
//    People newPerson(@RequestBody People newPerson) {
//        return repository.save(newPerson);
//    }
//
//    @GetMapping("/people/{id}")
//    People getPerson(@PathVariable Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new PeopleNotFoundException(id));
//    }

    @GetMapping("/people/{name}")
    People getByName(@PathVariable String name) {
        return repository.findByFirstName(name)
                .orElseThrow(() -> new PeopleNotFoundException(name));

    }

}
