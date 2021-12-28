<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 04.12.2021
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<div>
    <label for="links_to_subjects">Go to subjects:</label>
    <ul id="links_to_subjects">
        <li><a href="<c:url value="/books"/>">Books</a></li>
        <li><a href="<c:url value="/journals"/>">Journals</a></li>
        <li><a href="<c:url value="/newspapers"/>">Newspapers</a></li>
    </ul>
</div>

<form method="post" action="<c:url value="/index"/>">
    <div>
        <label for="input_id">Input id:</label>
        <input id="input_id" name="input_id" type="text">
        <button type="submit" name="search_button" value="by_id">Search</button>
    </div>

    <div>
        <label for="input_title">Input title:</label>
        <input id="input_title" name="input_title" type="text">
        <button type="submit" name="search_button" value="by_title">Search</button>
    </div>
    <div>
        <button type="submit" name="search_button" value="all">Search all</button>
    </div>
</form>

<c:if test="${subjects != null && subjects.size() > 0}">
    <table border="1">
        <caption>Subjects</caption>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Amount</th>
            <th>Type</th>
        </tr>
        <c:forEach items="${subjects}" var="subject">
            <tr>
                <td>${subject.id}</td>
                <td><a href="<c:url value="/${subject.type.toString().toLowerCase()}/${subject.id}"/>">${subject.title}</a></td>
                <td>${subject.amount}</td>
                <td>${subject.type}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
