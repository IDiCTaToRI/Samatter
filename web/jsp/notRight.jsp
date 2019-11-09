<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Такой login уже существует!</title>
</head>
<body>
<jsp:include page="header_reg.jsp"/>
<p>Такой login уже существует! Введите другой.</p>
<a href="<c:url value="http://localhost:8080/
register"/>" title="register">Register again</a>
</body>
</html>