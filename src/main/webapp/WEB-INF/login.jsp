<%--
  Created by IntelliJ IDEA.
  User: melih.ozcan
  Date: 4.08.2021
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="POST">
    <label for="username">Kullanıcı Adı:</label>
    <input id="username" type="text" name="username">
    <label for="password">Şifre:</label>
    <input id="password" type="password" name="password">
    <input type="submit">
    <c:if test="${message != null}">
        <c:out value="${message}"/>
    </c:if>
</form>

</body>
</html>
