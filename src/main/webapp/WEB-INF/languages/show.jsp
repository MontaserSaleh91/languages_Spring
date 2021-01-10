
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Show</title>
</head>
<body>
    <ul>
        <li><h2><c:out value="${language.name}"/></h2></li>
        <li><p><c:out value="${language.creator}"/></p></li>
        <li><p><c:out value="${language.currentVersion}"/></p></li>
        <li><a href="/languages/${language.id}/edit">Edit</a></li>
        <li>
            <form style="display: inline" action="/languages/${language.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input style="background: none; border: none; padding: 0; color: #069;font-family: arial, sans-serif; text-decoration: underline; cursor: pointer;" type="submit" value="Delete">
            </form>
        </li>
    </ul>
</body>
</html>
