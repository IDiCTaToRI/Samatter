package model.dao;

import model.Person;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface PersonDao {
    void add(Person person);

    void update(Person person);

    void delete(Person person);

    Collection<Person> getPersons(String search);

    List findByPerson(String firstname, String secondname, boolean sex, short age, String birthday, String patronymic);
}