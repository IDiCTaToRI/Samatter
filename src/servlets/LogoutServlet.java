package servlets;

import forms.LogoutForm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(LogoutForm.logout(request, response)) {
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/profile");
        }
    }
}
