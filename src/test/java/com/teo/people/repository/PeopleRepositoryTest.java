package com.teo.people.repository;

import com.teo.people.model.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PeopleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PeopleRepository repository;

    @Test
    public void testFindByName() {
        People mock = new People("Michelle1", "Dessler1", "", "02/07/1977", "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/rvypwy1503069308.jpg");
        entityManager.persist(mock);
        Optional<People> person = repository.findByFirstName("Michelle1");
        assertEquals(person, mock);
    }
}