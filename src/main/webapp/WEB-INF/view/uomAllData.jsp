<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false"%>
<h1 align="center" style="color: aqua;">Welcome To UnitOfMeasure Data Page</h1>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
<c:when test="${!empty list }">
<table border="1">
<tr>
<th>ID</th>
<th>TYPE</th>
<th>MODEL</th>
<th>DESC</th>
<th colspan="3">OPERATION</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.id}</td>
<td>${ob.umoType}</td>
<td>${ob.umoModel}</td>
<td>${ob.desc}</td>
<td><a href="delete?id=${ob.id}">delete</a></td>
<td><a href="edit?id=${ob.id}">edit</a></td>
<td><a href="view?id=${ob.id}">view</a></td>
</tr>
</c:forEach>
</table>
 ${message }
</c:when>
<c:otherwise>
<h4 align="center" style="color: red;">No Data Found</h4>
</c:otherwise>
</c:choose>