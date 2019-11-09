package forms;

import model.Person;
import model.dao.DatabasePersonLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteForm {

    public static boolean deleteUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        if (person != null){
            DatabasePersonLogic.deletePerson(person);//метод, принимает айди персона и удаляет его в бд
            return true;
        } else {
            return false;
        }
    }
}