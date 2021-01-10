
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Edit Language</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="col-8 offset-2">
    <h1>Edit Language</h1>
    <div>
        <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
            <input type="hidden" name="_method" value="put">
            <div class="row mb-3">
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </div>
            <div class="row mb-3">
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator"/>
                <form:input path="creator"/>
            </div>
            <div class="row mb-3">
                <form:label path="currentVersion">Version</form:label>
                <form:errors path="currentVersion"/>
                <form:input path="currentVersion"/>
            </div>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>
</body>
</html>
