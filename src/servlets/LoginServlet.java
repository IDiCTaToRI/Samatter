package servlets;

import forms.LoginForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        if (LoginForm.isLogined(req)) {
            resp.sendRedirect("/profile");
        } else {
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (LoginForm.login(request, response)) {
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
