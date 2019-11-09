package model.dao.impl;

import model.Person;
import model.dao.Database;
import model.dao.PersonDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private PreparedStatement statement;

    public void add(Person person) {
        try {
            statement = Database.getInstance().getConnection().prepareStatement("INSERT INTO person (firstname, secondname, sex, age, birthday, patronymic) VALUE (?, ?, ?, ?, ?, ?)");
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getSecondname());
            statement.setBoolean(3, person.isSex());
            statement.setInt(4, person.getAge());
            statement.setString(5, person.getBirthday());
            statement.setString(6, person.getPatronymic());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person person) {
        try {
            statement = Database.getInstance().getConnection().prepareStatement("UPDATE person SET firstname = ?, secondname = ?, sex = ?, age = ?, birthday = ?, patronymic = ? WHERE id = ?");
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getSecondname());
            statement.setBoolean(3, person.isSex());
            statement.setInt(4, person.getAge());
            statement.setString(5, person.getBirthday());
            statement.setString(6, person.getPatronymic());
            statement.setString(7, person.getId());
            statement.executeUpdate();//BigDecimal.valueOf(Long.parseLong(person.getIdh())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Person person) {
        try {
            statement = Database.getInstance().getConnection().prepareStatement("DELETE FROM person WHERE idh = ?");
            statement.setString(1, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Collection<Person> getPersons(String search) {
        ArrayList<Person> foundPerson = new ArrayList<>();
        try {
            statement = Database.getInstance().getConnection().prepareStatement("SELECT * FROM person WHERE idh = ?");
            statement.setString(1, search);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getString("idh"));
                person.setFirstname(rs.getString("firstname"));
                person.setSecondname(rs.getString("secondname"));
                person.setSex(rs.getBoolean("sex"));
                person.setAge(rs.getShort("age"));
                person.setBirthday(rs.getString("birthday"));
                person.setPatronymic(rs.getString("patronymic"));
                foundPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundPerson;
    }

    @Override
    public List findByPerson(String firstname, String secondname, boolean sex, short age, String birthday, String patronymic) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        try {
            statement = Database.getInstance().getConnection().prepareStatement("SELECT * FROM person WHERE firstname = ?, secondname = ?, sex = ?, age = ?, birthday = ?, patronymic = ?");
            statement.setString(1, firstname);
            statement.setString(2, secondname);
            statement.setBoolean(3, sex);
            statement.setInt(4, age);
            statement.setString(5, birthday);
            statement.setString(6, patronymic);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setFirstname(firstname);
                person.setSecondname(secondname);
                person.setSex(sex);
                person.setAge(age);
                person.setBirthday(birthday);
                person.setPatronymic(patronymic);
                personArrayList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personArrayList;
    }
}
