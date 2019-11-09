package servlets;

import model.Article;
import model.dao.DatabaseArticleLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/articles/comment/*")
public class ArticlesCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artcileId = req.getRequestURI().replace("/articles/comment/", "");
        System.out.println(artcileId + "ыыыыы");
        artcileId = artcileId.replace("jsp/articlesComment.jsp", "");
        System.out.println(artcileId);
        HttpSession session = req.getSession();
        if (!artcileId.equals("")) {
            Article article = DatabaseArticleLogic.getArticleById(Integer.valueOf(artcileId));
            session.setAttribute("article", article);
            req.getRequestDispatcher("jsp/articlesComment.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
