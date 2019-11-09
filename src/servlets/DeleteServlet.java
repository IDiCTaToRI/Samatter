package servlets;

import forms.DeleteForm;
import forms.ProfileForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(DeleteForm.deleteUser(request, response)){
            response.sendRedirect("/logout");
        } else {
            response.sendRedirect("/profile");
        }
    }
}