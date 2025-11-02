<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
</head>
<body style="text-align:center; margin-top:100px;">
    <h1>Welcome to Job Portal</h1>

    <c:choose>
        <c:when test="${not empty username}">
            <p>Hello, ${username}!</p>
            <form action="/logout" method="post">
                <button type="submit">Logout</button>
            </form>
        </c:when>
        <c:otherwise>
            <a href="/oauth2/authorization/google">
                <button>Login with Google</button>
            </a>
        </c:otherwise>
    </c:choose>

    <br><br>
    <button onclick="location.href='/findJob'">Find Jobs</button>
    <button onclick="location.href='/registerJob'">Register Job</button>
</body>
</html>
