package forms;

import model.dao.DatabaseSignLogic;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForm {

    private static String paramId = "id";
    private static String paramPass = "password";

    public static boolean isLogined(HttpServletRequest request) {
        Cookie userCookie = null;
        Cookie passCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (paramId.equals(c.getName())) {
                    userCookie = c;
                }
                if (paramPass.equals(c.getName())) {
                    passCookie = c;
                }
            }
        }
        return (userCookie != null && passCookie != null);
    }

    public static boolean login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String id = DatabaseSignLogic.getId(request.getParameter("login"), request.getParameter("password"));//метод который принимает логин и пароль пользователя и возвращает уже имеющийся в базе id'ник
        if (id != null) {
            session.setAttribute("id", id);
            session.setAttribute(paramPass, request.getParameter(paramPass));
            if (request.getParameter("remember") != null) {
                Cookie userCookie = new Cookie(paramId, (String) session.getAttribute(paramId));
                Cookie passCookie = new Cookie(paramPass, request.getParameter(paramPass));
                userCookie.setMaxAge(2592000); //30 days
                passCookie.setMaxAge(2592000); // 30 days
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
            return true;
        } else {
            return false;
        }
    }
}