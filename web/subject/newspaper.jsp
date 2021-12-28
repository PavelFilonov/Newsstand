<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 04.12.2021
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Newspaper</title>
</head>
<body>
<form method="post"  action="<c:url value="/newspaper/${newspaper.id}"/>">
    <ul>
        <li><label>ID: ${newspaper.id}</label></li>
        <br>
        <li><label>Title:
            <input name="title" value="${newspaper.title}">
        </label></li>
        <br>
        <li><label>Amount:
            <input name="amount" value="${newspaper.amount}">
        </label></li>
        <br>
        <li><label>Number:
            <input name="number" value="${newspaper.number}">
        </label></li>
        <br>
        <li><label>Date release:
            <input type="date" name="date_release" value="${newspaper.dateRelease}">
        </label></li>
    </ul>

    <br>

    <div>
        <button type="submit" name="submit" value="update">Update newspaper</button>
        <br>
        <button type="submit" name="submit" value="delete">Delete newspaper</button>
    </div>
    <br>
    ${info}
    <br>
    <div>
        <br>
        <a href="<c:url value="/newspapers"/>">Newspapers</a>
        <br>
        <a href="<c:url value="/"/>">Main page</a>
    </div>
</form>
</body>
</html>
