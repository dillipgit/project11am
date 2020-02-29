<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<div align="center">
		<h1 style="color: aqua;">Welcome to ShipmentType Data Page</h1>
	</div>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr style="color: blue;" bgcolor="black">
					<th>ID</th>
					<th>CODE</th>
					<th>GRADE</th>
					<th>MODE</th>
					<th>ENABLE</th>
					<th>DESC</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr style="color: white;" bgcolor="black">
						<th>${ob.shipId}</th>
						<th>${ob.shipCode}</th>
						<th>${ob.shipGrade}</th>
						<th>${ob.shipMode}</th>
						<th>${ob.enbShip}</th>
						<th>${ob.shipDesc}</th>
						<th><a href=delete?shipId=${ob.shipId}> <img  src="../resources/images/delete.png" width="40" height="40"></a></a></th>
						<th><a href=edit?shipId=${ob.shipId}> <img  src="../resources/images/edit.jfif" width="40" height="40"></a></a></th>
						<th><a href=view?shipId=${ob.shipId}> <img  src="../resources/images/view.png" width="40" height="40"></a></a></th>
					</tr>
				</c:forEach>
			</table>
 ${message}
   ${shipmentTypeEdit}
</c:when>
		<c:otherwise>
			<h2 style="color: red;">No Data Found</h2>
		</c:otherwise>
	</c:choose>
	<a href="excel"> <img src="../resources/images/excel.jfif"
		width="120" height="60"></a>

	<a href="pdf"> <img src="../resources/images/pdf.jfif" width="120"
		height="60"></a>
	
</body>
</html>
