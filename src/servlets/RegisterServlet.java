package servlets;

import forms.RegisterForm;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String firstname = request.getParameter("firstname");
        String secondname = request.getParameter("secondname");
        String patronymic = request.getParameter("patronymic");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");

        if (!password.equals(password2) && RegisterForm.addUser(login, password, firstname, secondname, patronymic, email, address, phone, birthday, sex, age)) {
            response.sendRedirect("/login");
        } else {
            request.getRequestDispatcher("jsp/notRight.jsp").forward(request, response);
        }
    }
}