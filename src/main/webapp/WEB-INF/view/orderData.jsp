<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1 align="center" style="color: fuchsia">All Table</h1>
<%@include file="userMenu.jsp"%>
<c:choose>
	<c:when test="${!empty list}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>MODE</th>
				<th>CODE</th>
				<th>TYPE</th>
				<th>ACCEPT</th>
				<th>DESC</th>
				<th colspan="3">OPERATIONS</th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.id}</td>
					<td>${ob.mode}</td>
					<td>${ob.code}</td>
					<td>${ob.orderType}</td>
					<td>${ob.accept}</td>
					<td>${ob.desc}</td>
					<td><a href="delete?mid= ${ob.id}"> <img  src="../resources/images/delete.png" width="50" height="50"></a></a></td>
					<td><a href="edit?mid= ${ob.id}"> <img  src="../resources/images/edit.jfif" width="50" height="50"></a></a></td>
					<td><a href="view?mid= ${ob.id}"> <img  src="../resources/images/view.png" width="50" height="50"></a></a></td>
				</tr>

			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1>No Data Found</h1>
	</c:otherwise>
</c:choose>
<a href="excel"> <img  src="../resources/images/excel.jfif" width="100" height="60"></a></a>
<a href="pdf"> <img  src="../resources/images/pdf.jfif" width="100" height="60"></a></a>
${msg}
