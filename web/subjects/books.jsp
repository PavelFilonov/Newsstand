<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 05.12.2021
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

<div>
    ${info}
</div>

<br>

<form method="post" action="<c:url value="/books"/>">
    <div>
        <ul>Adding a new book:
            <br>
            <li><label>Title:
                <input name="title">
            </label></li>
            <br>
            <li><label>Amount:
                <input name="amount">
            </label></li>
            <br>
            <li><label>Author:
                <input name="author">
            </label></li>
            <br>
            <li><label>Publisher:
                <input name="publisher">
            </label></li>
            <br>
            <li><label>Number page:
                <input name="number_page">
            </label></li>
        </ul>

        <button type="submit" name="add">Add</button>
    </div>
</form>

<br>

<c:choose>
    <c:when test="${books != null && books.size() > 0}">
        <table border="1">
            <caption>Books</caption>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Amount</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Number page</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="<c:url value="/book/${book.id}"/>">${book.title}</a></td>
                    <td>${book.amount}</td>
                    <td>${book.author}</td>
                    <td>${book.publisher}</td>
                    <td>${book.numberPage}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>

    <c:otherwise>
        No data
    </c:otherwise>
</c:choose>

<br>

<a href="<c:url value="/"/>">Main page</a>

</body>
</html>
