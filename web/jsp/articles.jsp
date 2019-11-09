<%@ page import="model.Article" %><%--
  Created by IntelliJ IDEA.
  User: kadyr
  Date: 09.11.2019
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<div align="center">
    <% Article[] articles = (Article[]) request.getSession().getAttribute("articles");
        for (Article a : articles) {
        out.print("<p>" + a.getArticleText() + "</p><br>");
        }%>
</div>
</body>
</html>
