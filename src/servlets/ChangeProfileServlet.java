package servlets;

import forms.ChangeProfileForm;
import forms.ProfileForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeProfile")
public class ChangeProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ChangeProfileForm.changeUser(request, response)){
            request.getRequestDispatcher("jsp/changeProfile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/profile");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(ProfileForm.getUser(request, response)){
            request.getRequestDispatcher("jsp/changeProfile.jsp").forward(request, response);
        } else {
            response.sendRedirect("/profile");
        }
    }
}