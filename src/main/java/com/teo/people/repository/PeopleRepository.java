package com.teo.people.repository;

import com.teo.people.configuration.PeopleNotFoundAdvice;
import com.teo.people.exception.PeopleNotFoundException;
import com.teo.people.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * People Repository
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByFirstNameIgnoreCase(String firstName) ;

}

