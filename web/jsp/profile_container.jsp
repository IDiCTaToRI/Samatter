<%@ page import="model.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Untitled</title>
    <link rel="stylesheet" href="jsp/OtherElements/untitled/assets/bootstrap/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <div>
        <p class="text-nowrap text-center">
            <%Person user = (Person) session.getAttribute("person");%>
            <%=user.getFirstname()%>
        </p>
    </div>
    <div>
        <p class="text-nowrap text-center">
            <%=user.getSecondname()%>
        </p>
    </div>
    <div>
        <p class="text-nowrap text-center">
            <%=user.getEmail()%>
        </p>
    </div>
    <div>
        <p class="text-nowrap text-center">
            <%=user.getPhone()%>
        </p>
    </div>
    <div>
        <p class="text-nowrap text-center">
            <%=user.getBirthday()%>
        </p>
    </div>
</div>
<script src="jsp/OtherElements/untitled/assets/js/jquery.min.js"></script>
<script src="jsp/OtherElements/untitled/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>