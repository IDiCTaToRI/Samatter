package forms;

import model.Person;
import model.dao.DatabasePersonLogic;
import model.dao.DatabaseUserLogic;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class RegisterForm {
    //private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static boolean addUser(String login, String password, String firstname, String secondname, String patronymic, String email, String address, String phone, String birthday, String sex, String age) {
        Person person;
        String id;
        Boolean sexBool;

        if (login != null && password != null) {
            //String hash = encoder.encode(password);
            id = DatabaseUserLogic.getLogin(login, password);//метод, который добавляет логин и пароль в бд и возвращает взамен НОВЫЙ айдишник этого пользователя
        } else {
            return false;
        }

        if (sex.equals("Малай")) {
            sexBool = true;
        } else {
            sexBool = false;
        }

        if (id != null && firstname != null && secondname != null && patronymic != null && email != null && address != null && phone != null && birthday != null && age != null) {
            person = new Person(id, firstname, secondname, patronymic, sexBool, Short.parseShort(age), birthday, email, address, phone);
            DatabasePersonLogic.addPerson(person);//метод, который принимает персона и добавляет его в бд
            return true;
        } else {
            return false;
        }
    }
}