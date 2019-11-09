package service;

import model.Person;

import java.util.Collection;

public interface PersonService {
    Boolean add(Person person);

    void update(Person person);

    Collection<Person> getPerson(String search);

    void delete(Person person);
}
