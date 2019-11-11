package parser;

import javafx.scene.transform.Scale;
import model.dao.Database;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

    public static void main(String[] args) throws IOException {

        String gameNews = "https://www.igromania.ru/news/game/";
        String indusNews = "https://www.igromania.ru/news/industry/";
        String hardNews = "https://www.igromania.ru/news/hard/";
        String cyberNews = "https://www.igromania.ru/news/cybersport/";

        Document document = Jsoup.connect(cyberNews).get();
        Element elem = document.getElementById("newsfeed_cont");

        Elements elem2 = elem.getElementsByClass("info_block_line clearfix_l");
        try {
            for (Element e : elem2) {
                PreparedStatement statement = Database.getInstance().getConnection().prepareStatement("INSERT into newsdata (articletext, comment, imglink, genre, articledata) VALUES (?, ?, ?, ?, ?)");

                System.out.println(e.getElementsByTag("img").first().attr("src")); // image url
                System.out.println(e.getElementsByClass("text_block_ttl t_18").first().text()); // article's text
                System.out.println(e.getElementsByClass("text_block_in").first().text().replace(e.getElementsByClass("text_block_ttl t_18").first().text(), "").substring(1)); // article's comment

                String[] str = e.getElementsByClass("botline").first().text().split(" ");
                System.out.println(str[2]); // article's date
                System.out.println(str[3]); // article's time
                int beginGenre = e.getElementsByClass("botline").first().text().indexOf('|') + 2;
                System.out.println(e.getElementsByClass("botline").first().text().substring(beginGenre)); // genre

                statement.setString(1, e.getElementsByClass("text_block_ttl t_18").first().text());
                statement.setString(2, e.getElementsByClass("text_block_in").first().text().replace(e.getElementsByClass("text_block_ttl t_18").first().text(), "").substring(1));
                statement.setString(3, e.getElementsByTag("img").first().attr("src"));
                statement.setString(4, e.getElementsByClass("botline").first().text().substring(beginGenre));
                statement.setString(5, str[2] + " " + str[3]);
                statement.executeUpdate();
                Database.getInstance().closeConnection();
            }
        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
    }
}
