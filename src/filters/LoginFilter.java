package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private String notFoundImage;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

        // ==> /images/image-not-found.png
        notFoundImage = fConfig.getInitParameter("notFoundImage");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        Cookie idCookie = null;
        Cookie passCookie = null;
        String cookieId = "id";
        String cookiePass = "password";

        if (session != null) {
            chain.doFilter(request, response);
        } else if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookieId.equals(c.getName())) {
                    idCookie = c;
                }
                if (cookiePass.equals(c.getName())) {
                    passCookie = c;
                }
            }
            session.setAttribute(cookieId, idCookie);
            session.setAttribute(cookiePass, passCookie);
        } else {

            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect("login");
        }
    }
}