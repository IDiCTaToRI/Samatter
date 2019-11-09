package forms;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutForm {

    private static String cookieId = "id";
    private static String cookiePass = "password";

    public static boolean logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie userCookie = null;
        Cookie passCookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookieId.equals(c.getName())) {
                    userCookie = c;
                    userCookie.setMaxAge(0);
                }
                if (cookiePass.equals(c.getName())) {
                    passCookie = c;
                    passCookie.setMaxAge(0);
                }
            }
            if (userCookie != null && passCookie != null) {
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }
        }
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }
}
