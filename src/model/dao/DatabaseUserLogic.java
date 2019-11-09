package model.dao;

import model.dao.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUserLogic {
    public DatabaseUserLogic() {
    }

    public static String getLogin(String login, String password) {
        try {
            PreparedStatement createUserSql = Database.getInstance().getConnection().prepareStatement("INSERT INTO user (username, password) VALUES (?, ?)");
            createUserSql.setString(1, login);
            createUserSql.setString(2, password);
            createUserSql.executeUpdate();
            createUserSql.close();
            PreparedStatement findUserIdSql = Database.getInstance().getConnection().prepareStatement("SELECT id FROM user WHERE username = ?");
            findUserIdSql.setString(1, login);
            ResultSet rs = findUserIdSql.executeQuery();
            if (rs.next()) {
                return String.valueOf(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}