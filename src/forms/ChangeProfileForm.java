package forms;

import model.Person;
import model.dao.DatabasePersonLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeProfileForm {
    public static boolean changeUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        if (person != null){
            DatabasePersonLogic.changePerson(person);//метод, принимает пёрсона и меняет его в бд по айдишнику
            return true;
        } else {
            return false;
        }
    }
}