<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<h1 align="center" style="color: navy;">ShipmentType ViewPage</h1>
<html>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.shipId}</td>
		</tr>
		<tr>
			<th>MODE</th>
			<td>${ob.shipMode}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.shipCode}</td>
		</tr>
		<tr>
			<th>ENABLE</th>
			<td>${ob.enbShip}</td>
		</tr>
		<tr>
			<th>GRADE</th>
			<td>${ob.shipGrade}</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${ob.shipDesc}</td>
		</tr>
	</table>
	<a href="excel?id=${ob.shipId}">Excel Export</a>
	<a href="pdf?id=${ob.shipId}">Pdf Export</a>
</body>
</html>
