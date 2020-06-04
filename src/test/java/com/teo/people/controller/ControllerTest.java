package com.teo.people.controller;

import com.teo.people.exception.PeopleNotFoundException;
import com.teo.people.model.People;
import com.teo.people.repository.PeopleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ControllerTest {
    @Mock
    PeopleRepository repository;
    @InjectMocks
    Controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAll() {
        when(repository.findAll()).thenReturn(Arrays.<People>asList(new People("test1", "last", "middle", "04-06-2020", "imageurl")));
        List<People> result = controller.all();
        Assertions.assertEquals(Arrays.<People>asList(new People("test1", "last", "middle", "04-06-2020", "imageurl")), result);
    }

//    @Test
//    void testNewPerson() {
//        People result = controller.newPerson(new People("firstName", "lastName", "middleName", "dob", "imageurl"));
//        verify(repository).save(any());
//        Assertions.assertEquals(repository.findAll().size(),1);
//    }

//    @Test
//    void testGetPerson() {
//        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(new People("test1", "last", "middle", "04-06-2020", "imageurl")));
//        People result = controller.getPerson(Long.valueOf(1));
//        Assertions.assertEquals(new People("test1", "last", "middle", "04-06-2020", "imageurl"), result);
//    }
//    @Test
//    public void testGetPersonException() {
//        Assertions.assertThrows(PeopleNotFoundException.class, () ->{controller.getPerson(Long.valueOf(1));});
//    }

    @Test
    void testGetByName() {
        when(repository.findByFirstName(anyString())).thenReturn(java.util.Optional.of(new People("firstName", "lastName", "middleName", "dob", "imageurl")));
        People result = controller.getByName("firstName");
        Assertions.assertEquals(new People("firstName", "lastName", "middleName", "dob", "imageurl"), result);
    }

    @Test
    public void testGetByNameException() {
        Assertions.assertThrows(PeopleNotFoundException.class, () ->{controller.getByName("name");});
    }
}

