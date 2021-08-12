<!-- prettier-ignore -->
<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
<!-- prettier-ignore -->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prettier-ignore -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- prettier-ignore -->

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
        <h1>test</h1>
        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Creator</th>
                        <th scope="col">Version</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${languages}" var="language">
                        <tr>
                            <td><a href="/languages/show/${language.id}"><c:out value="${language.name}" /></a></td>
                            <td><c:out value="${language.creator}" /></td>
                            <td><c:out value="${language.version}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div><form:form action="/languages/add" method="post" modelAttribute="oneLanguage">
            <p>
                <form:label path="name">name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="creator">creator</form:label>
                <form:errors path="creator"/>
                <form:textarea path="creator"/>
            </p>
            <p>
                <form:label path="version">version</form:label>
                <form:errors path="version"/>
                <form:input path="version"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>    </div>
    </body>
</html>
