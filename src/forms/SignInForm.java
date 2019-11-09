package forms;

import model.User;
import model.dao.Database;
import model.dao.DatabaseSignLogic;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignInForm {

    private static String cookieUsername = "username";
    private static String cookiePass = "password";
    private static String paramUsername = "username";
    private static String paramPass = "password";

    public static boolean isLogined(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        }

        Cookie userCookie = null;
        Cookie passCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookieUsername.equals(c.getName())) {
                    userCookie = c;
                }
                if (cookiePass.equals(c.getName())) {
                    passCookie = c;
                }
            }
        }
        return userCookie != null && passCookie != null;
    }

    public static boolean login(HttpServletRequest request, HttpServletResponse response) {
        User user = DatabaseSignLogic.login(request.getParameter(paramUsername),request.getParameter(paramPass));
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if (request.getParameter("remember") != null) {
                Cookie userCookie = new Cookie(cookieUsername, request.getParameter(paramUsername));
                Cookie passCookie = new Cookie(cookiePass, request.getParameter(paramPass));
                userCookie.setMaxAge(2592000); //2592000 seconds = 30 days
                passCookie.setMaxAge(2592000); //2592000 seconds = 30 days
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
        } else{
            return false;
        }

        /*String findUsername = request.getParameter(paramUsername); //fixme wtf? boolean?
        String findPassword = request.getParameter(paramPass); //fixme wtf? boolean?
        if (findUsername && findPassword) {
            if (request.getParameter("remember") != null) {
                System.out.println("Remember for a month");
                Cookie userCookie = new Cookie(cookieUsername, request.getParameter(paramUsername));
                Cookie passCookie = new Cookie(cookiePass, request.getParameter(paramPass));
                userCookie.setMaxAge(2592000); //2592000 seconds = 30 days
                passCookie.setMaxAge(2592000); //2592000 seconds = 30 days
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
            return true;
        } else {
            return false;
        }*/
        return true;
    }
}
