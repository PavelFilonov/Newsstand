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
    <title>Journal</title>
</head>
<body>
<form method="post" action="<c:url value="/journal/${journal.id}"/>">
    <ul>
        <li><label>ID: ${journal.id}</label></li>
        <br>
        <li><label>Title:
            <input name="title" value="${journal.title}">
        </label></li>
        <br>
        <li><label>Amount:
            <input name="amount" value="${journal.amount}">
        </label></li>
        <br>
        <li><label>Number:
            <input name="number" value="${journal.number}">
        </label></li>
        <br>
        <li><label>Date release:
            <input type="date" name="date_release" value="${journal.dateRelease}">
        </label></li>
        <br>
        <li><label>Number page:
            <input name="number_page" value="${journal.numberPage}">
        </label></li>
    </ul>

    <br>

    <div>
        <button type="submit" name="submit" value="update">Update journal</button>
        <br>
        <button type="submit" name="submit" value="delete">Delete journal</button>
    </div>
    <br>
    ${info}
    <br>
    <div>
        <br>
        <a href="<c:url value="/journals"/>">Journals</a>
        <br>
        <a href="<c:url value="/"/>">Main page</a>
    </div>
</form>
</body>
</html>
