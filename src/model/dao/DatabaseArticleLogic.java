package model.dao;

import model.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DatabaseArticleLogic {
    public DatabaseArticleLogic() {
    }

    public static Article[] getAllArticles() {
        Set<Article> articles = new HashSet<>();
        try {
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement("SELECT * from newsdata");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                articles.add(new Article(rs.getInt("id"), rs.getString("articletext"), rs.getString("comment"), rs.getString("imglink"), rs.getString("genre"), rs.getString("articledata")));
            }
            Database.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Article[] articlesArray = articles.stream().toArray(Article[]::new);
        return articlesArray;
    }

    public static Article[] getArticleByGenre(String genre) {
        Set<Article> articles = new HashSet<>();
        try {
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement("SELECT * FROM newsdata WHERE genre = ?");
            statement.setString(1, genre);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                articles.add(new Article(rs.getInt("id"), rs.getString("articletext"), rs.getString("comment"), rs.getString("imglink"), rs.getString("genre"), rs.getString("articledata")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Article[] articlesArray = articles.stream().toArray(Article[]::new);
        return articlesArray;
    }

    public static Article getArticleById(int id) {
        try {
            PreparedStatement statement = Database.getInstance().getConnection().prepareStatement("SELECT * from newsdata WHERE id = ?");
            statement.setString(1, String.valueOf(id));
            ResultSet rs = statement.executeQuery();
            Article article = null;
            while (rs.next()) {
                article = new Article(rs.getInt("id"), rs.getString("articletext"), rs.getString("comment"), rs.getString("imglink"), rs.getString("genre"), rs.getString("articledata"));
            }
            Database.getInstance().closeConnection();
            return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
