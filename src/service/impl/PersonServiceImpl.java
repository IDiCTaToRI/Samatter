package service.impl;

import model.Person;
import model.dao.PersonDao;
import service.PersonService;

import java.util.Collection;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Boolean add(Person person) {
        List<Person> duplicate = personDao.findByPerson(person.getFirstname(), person.getSecondname(), person.isSex(), person.getAge(), person.getBirthday(), person.getPatronymic());
        if (duplicate.isEmpty()) {
            personDao.add(person);
            return true;
        }
        return false;
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public Collection<Person> getPerson(String search) {
        return personDao.getPersons(search);
    }

    @Override
    public void delete(Person person) {
        personDao.delete(person);
    }
}
