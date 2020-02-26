<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <body>
    <h1 align="center" style="color: orange;" >UserAllData Page</h1>
    <c:choose>
    <c:when test="${! empty list }">
    <table border="1">
    <tr>
    <th>ID</th>
    <th>USER TYPE</th>
    <th>USER CODE</th>
    <th>USER FOR</th>
    <th>EMAIL</th>
    <th>CONTACT</th>
    <th>USERID TYPE</th>
    <th>IF OTHER</th>
    <th>ID NO</th>
    <th colspan="3">OPERATION</th>
    </tr>
    <c:forEach items="${list}" var="ob">
    <tr>
    <td>${ob.userId }</td>
    <td>${ob.userType }</td>
    <td>${ob.userCode }</td>
    <td>${ob.userFor }</td>
    <td>${ob.email }</td>
    <td>${ob.contact }</td>
    <td>${ob.userIdType }</td>
    <td>${ob.other}</td>
    <td>${ob. id }</td>
    <td><a href="delete?userId=${ob.userId}">delete</a></td>
    <td><a href="edit?userId=${ob.userId}">edit</a></td>
    <td><a href="view?userId=${ob.userId}">view</a></td>
    </tr>
    </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
    <h3>No Data found!</h3>
    </c:otherwise>
    </c:choose>
    </body>
    </html>
