
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Languages</title>
</head>
<body>
    <h1>Languages</h1>
    <table>
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
                <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.currentVersion}"/></td>
                <td>
                    <form action="/languages/${language.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete">
                    </form>
                    <span> | </span><form action="/languages/${language.id}/edit" method="get">
						    		<input type="submit" class="btn btn-link" value="edit">
									</form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <form:form action="/languages" method="post" modelAttribute="language">
            <div>
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </div>
            <div>
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator"/>
                <form:input path="creator"/>
            </div>
            <div>
                <form:label path="currentVersion">Current Version</form:label>
                <form:errors path="currentVersion"/>
                <form:input path="currentVersion"/>
            </div>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>
</body>