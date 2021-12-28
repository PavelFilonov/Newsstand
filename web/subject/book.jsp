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
    <title>Book</title>
</head>
<body>
<form method="post" action="<c:url value="/book/${book.id}"/>">
    <ul>
        <li><label>ID: ${book.id}</label></li>
        <br>
        <li><label>Title:
            <input name="title" value="${book.title}">
        </label></li>
        <br>
        <li><label>Amount:
            <input name="amount" value="${book.amount}">
        </label></li>
        <br>
        <li><label>Author:
            <input name="author" value="${book.author}">
        </label></li>
        <br>
        <li><label>Publisher:
            <input name="publisher" value="${book.publisher}">
        </label></li>
        <br>
        <li><label>Number page:
            <input name="number_page" value="${book.numberPage}">
        </label></li>
    </ul>

    <br>

    <div>
        <button type="submit" name="submit" value="update">Update book</button>
        <br>
        <button type="submit" name="submit" value="delete">Delete book</button>
    </div>
    <br>
    ${info}
    <br>
    <div>
        <br>
        <a href="<c:url value="/books"/>">Books</a>
        <br>
        <a href="<c:url value="/"/>">Main page</a>
    </div>
</form>
</body>
</html>
