package model.dao;

import model.Person;
import model.dao.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabasePersonLogic {

    public DatabasePersonLogic() {
    }

    public static boolean addPerson(Person person) {
        try {
            PreparedStatement addNewPersonSql = Database.getInstance().getConnection().prepareStatement("INSERT INTO person (firstname, secondname, sex, age, birthday, patronymic, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            addNewPersonSql.setString(1, person.getFirstname());
            addNewPersonSql.setString(2, person.getSecondname());
            addNewPersonSql.setBoolean(3, person.isSex());
            addNewPersonSql.setInt(4, person.getAge());
            addNewPersonSql.setString(5, person.getBirthday());
            addNewPersonSql.setString(6, person.getPatronymic());
            addNewPersonSql.setString(7, person.getEmail());
            addNewPersonSql.setString(8, person.getAddress());
            addNewPersonSql.setString(9, person.getPhone());
            addNewPersonSql.executeUpdate();
            addNewPersonSql.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean changePerson(Person person) {
        try {
            PreparedStatement updatePersonSql = Database.getInstance().getConnection().prepareStatement("UPDATE person SET firstname = ?, secondname = ?, sex = ?, age = ?, birthday = ?, patronymic = ?, email = ?, address = ?, phone = ? WHERE idh = ?");
            updatePersonSql.setString(1, person.getFirstname());
            updatePersonSql.setString(2, person.getSecondname());
            updatePersonSql.setBoolean(3, person.isSex());
            updatePersonSql.setShort(4, person.getAge());
            updatePersonSql.setString(5, person.getBirthday());
            updatePersonSql.setString(6, person.getPatronymic());
            updatePersonSql.setString(7, person.getEmail());
            updatePersonSql.setString(8, person.getAddress());
            updatePersonSql.setString(9, person.getPhone());
            updatePersonSql.setInt(7, Integer.valueOf(person.getId())); // fixme maybe it is not necessary to convert into int
            updatePersonSql.executeQuery();
            updatePersonSql.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deletePerson(Person person) {
        try {
            PreparedStatement deletePersonSql = Database.getInstance().getConnection().prepareStatement("DELETE FROM person WHERE idh = ?");
            deletePersonSql.setInt(1, Integer.valueOf(person.getId())); // fixme maybe it is not necessary to convert into int
            deletePersonSql.executeQuery();
            deletePersonSql.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Person getPerson(String idh) {
        try {
            PreparedStatement findPersonSql = Database.getInstance().getConnection().prepareStatement("SELECT * FROM person WHERE id = ?");
            findPersonSql.setString(1, idh);
            ResultSet rs = findPersonSql.executeQuery();
            if (rs.next()) {
                System.out.println(1);
                return new Person(String.valueOf(rs.getInt("id")), rs.getString("firstname"), rs.getString("secondname"), rs.getString("patronymic"), rs.getBoolean("sex"), rs.getShort("age"), rs.getString("birthday"), rs.getString("email"), rs.getString("address"), rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}