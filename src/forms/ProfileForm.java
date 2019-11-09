package forms;

import model.Person;
import model.User;
import model.dao.Database;
import model.dao.DatabasePersonLogic;
import model.dao.DatabaseSignLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfileForm {

    public static boolean getUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = DatabasePersonLogic.getPerson(String.valueOf(session.getAttribute("id")));//метод, который принимает айдишник персона и из бд возвращает его.
        if (person != null){
            session.setAttribute("person", person);
            return true;
        } else {
            return false;
        }
    }
}