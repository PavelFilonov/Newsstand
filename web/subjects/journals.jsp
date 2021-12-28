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
    <title>Journals</title>
</head>
<body>

<div>
    ${info}
</div>

<br>

<form method="post" action="<c:url value="/books"/>">
    <div>
        <ul>Adding a new journal:
            <br>
            <li><label>Title:
                <input name="title">
            </label></li>
            <br>
            <li><label>Amount:
                <input name="amount">
            </label></li>
            <br>
            <li><label>Number:
                <input name="number">
            </label></li>
            <br>
            <li><label>Date release:
                <input type="date" name="date_release">
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
    <c:when test="${journals != null && journals.size() > 0}">
        <table border="1">
            <caption>Journals</caption>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Amount</th>
                <th>Number</th>
                <th>Date release</th>
                <th>Number page</th>
            </tr>
            <c:forEach items="${journals}" var="journal">
                <tr>
                    <td>${journal.id}</td>
                    <td><a href="<c:url value="/journal/${journal.id}"/>">${journal.title}</a></td>
                    <td>${journal.amount}</td>
                    <td>${journal.number}</td>
                    <td>${journal.dateRelease}</td>
                    <td>${journal.numberPage}</td>
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
