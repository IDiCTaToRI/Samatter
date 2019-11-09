<%@ page import="model.Article" %><%--
  Created by IntelliJ IDEA.
  User: kadyr
  Date: 09.11.2019
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
<div align="center">
    <% Article article = (Article) request.getSession().getAttribute("article");
        out.print("<img href=\"" + article.getImgLink() + "\"><br>");
        out.print("<h1>" + article.getArticleText() + "</h1><br>");
        out.print("<h2>" + article.getComment() + "</h2><br>");
        out.print("<div><h7>" + article.getArticleData() + "</h7></div><div><h7>" + article.getArticleData() + "</h7></div><br>");
        out.print("<form method=\"post\" action=\"/articles/comment/" + article.getId() +"\"");
    %>
        <input type="text" placeholder="Комментарий">
        <button class="btn btn-primary btn-block" type="submit">Вставить никому не нужное мнение</button></form>
</div>
</body>
</html>
