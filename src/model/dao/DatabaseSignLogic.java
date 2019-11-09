package model.dao;

import model.User;
import model.dao.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSignLogic {

    private static String cookieUsername = "username";
    private static String cookiePass = "password";
    private static String paramUsername = "username";
    private static String paramPass = "password";


    public DatabaseSignLogic() {
    }

    public static String getId(String login, String password) {
        try {
            PreparedStatement findUserSql = Database.getInstance().getConnection().prepareStatement("SELECT id from user WHERE username = ? AND password = ?");
            findUserSql.setString(1, login);
            findUserSql.setString(2, password);
            ResultSet rs = findUserSql.executeQuery();
            if (rs.next()) {
                return rs.getString("id");
            }
            findUserSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User login(String paramUsernameReq, String paramPassReq) {
        try {
            PreparedStatement statement1 = Database.getInstance().getConnection().prepareStatement("SELECT * FROM user WHERE username = ?");
            statement1.setString(1, paramUsernameReq);
            ResultSet findUsernameSet = statement1.executeQuery();
            statement1.close();
            if (findUsernameSet.next() && findUsernameSet.getString(paramPass).equals(paramPassReq)) {
                return new User(findUsernameSet.getString("username"), findUsernameSet.getString("password"), findUsernameSet.getLong("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}