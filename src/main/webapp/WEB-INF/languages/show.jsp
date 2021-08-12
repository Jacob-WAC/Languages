<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Insert title here</title>
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1><c:out value="${language.name}" /></h1>
        <p>Creator: <c:out value="${language.creator}" /></p>
        <p>Version: <c:out value="${language.version}" /></p>
        <a href="/languages/${language.id}/edit">Edit language</a>
        <form action="/languages/${language.id}/delete" method="post">
            <input type="hidden" name="_method" value="delete" />
            <input type="submit" value="Delete" />
        </form>
    </body>
</html>
