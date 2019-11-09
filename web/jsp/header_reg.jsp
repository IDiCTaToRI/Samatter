<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>ShortNavBar</title>
    <link rel="stylesheet" href="jsp/GenElems/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="jsp/GenElems/assets/bootstrap/css/styles.min.css">
</head>

<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="${pageContext.request.contextPath}/">Samatter</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav mr-auto">
                <!--<li class="nav-item" role="presentation"><a class="nav-link active" href="<c:url value="http://localhost:8080/profile"/>">Профиль</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="<c:url value="http://localhost:8080/library"/>" >Статьи</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="<c:url value="http://localhost:8080/changeProfile"/>" >Настройки</a></li>-->
            </ul>
            <ul>
                 <span class="navbar-text actions">
                    <a class="btn btn-light action-button" role="button" href="<c:url value="http://localhost:8080/login"/>">Войти</a>
                </span>
            </ul>
        </div>
    </div>
</nav>
<script src="jsp/GenElems/ShortNavBar/assets/js/jquery.min.js"></script>
<script src="jsp/GenElems/ShortNavBar/assets/bootstrap/js/bootstrap.min.js"></script>
