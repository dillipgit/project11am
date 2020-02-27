<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="false"%>
<h1 align="center" style="color: aqua;">Welcome To UnitOfMeasure
	Data Page</h1>
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
					<td><a href="delete?id=${ob.id}"> <img  src="../resources/images/delete.png" width="50" height="40"></a></a></td>
					<td><a href="edit?id=${ob.id}"> <img  src="../resources/images/edit.jfif" width="50" height="40"></a></a></td>
					<td><a href="view?id=${ob.id}"> <img  src="../resources/images/view.png" width="50" height="40"></a></a></td>
				</tr>
			</c:forEach>
		</table>
 ${message }
</c:when>
	<c:otherwise>
		<h4 align="center" style="color: red;">No Data Found</h4>
	</c:otherwise>
</c:choose>
<a href="excel"> <img  src="../resources/images/excel.jfif" width="120" height="60"></a></a>
<a href="pdf"> <img  src="../resources/images/pdf.jfif" width="120" height="60"></a></a>