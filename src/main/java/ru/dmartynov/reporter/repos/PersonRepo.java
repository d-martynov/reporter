package ru.dmartynov.reporter.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.dmartynov.reporter.models.Person;

/**
 * Created by d.martynov on 25.11.2015.
 */
public interface PersonRepo extends MongoRepository<Person, Long> {

}
