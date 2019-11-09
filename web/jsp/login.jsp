<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>login</title>
    <link rel="stylesheet" href="jsp/OtherElements/login/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="jsp/OtherElements/login/assets/css/styles.min.css">
</head>

<body>
<jsp:include page="header_reg.jsp" />
<div class="login-clean">
    <form method="post" action="/login">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><img src="jsp/OtherElements/login/assets/img/verification-sign-sketch.png" style="width: 128px;"></div>
        <div class="form-group"><input class="form-control" type="text" name="login" placeholder="Ваше имя"></div>
        <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Пароль"></div>
        <div class="form-group">
            <div class="form-check"><label class="form-check-label"><input class="form-check-input" name="remember" type="checkbox">Запомнить меня</label></div>
        </div>
        <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Войти</button></div>
        <a class="forgot" href="#">Забыли пароль?</a></form>
</div>
<script src="jsp/OtherElements/login/assets/js/jquery.min.js"></script>
<script src="jsp/OtherElements/login/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>