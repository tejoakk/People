package com.teo.people.configuration;

import com.teo.people.model.People;
import com.teo.people.repository.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * load initial Data
 */
@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    public CommandLineRunner demo(PeopleRepository repository) {
        return (args) -> {
            // save a few customers
            log.info("Preloading " + repository.save(new People("Jack", "Charles", "Bauer", "02/07/1977", "https://images.unsplash.com/photo-1525355198643-193cd25842ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60")));
            log.info("Preloading " +  repository.save(new People("Chloe", "O'Brian", "", "02/07/1977", "https://images.unsplash.com/photo-1542410613-d073472c3135?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60")));
            log.info("Preloading " +  repository.save(new People("Kim", "Bauer", "", "02/07/1977", "https://images.unsplash.com/photo-1538448174498-9956c159edb0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60")));
            log.info("Preloading " +  repository.save(new People("David", "Palmer", "", "02/07/1977", "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/rvypwy1503069308.jpg")));
            log.info("Preloading " +  repository.save(new People("Michelle", "Dessler", "", "02/07/1977", "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/rvypwy1503069308.jpg")));
            log.info("Preloading " +  repository.save(new People("Michelle1", "Dessler1", "", "02/07/1977", "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/rvypwy1503069308.jpg")));
        };
    }
}
