<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<h1 align="center" style="color: lime;">One Data ViewPage</h1>

<html>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.id}</td>
		</tr>
		
		<tr>
			<th>TYPE</th>
			<td>${ob.umoType}</td>
		</tr>
		
		<tr>
			<th>MODEL</th>
			<td>${ob.umoModel}</td>
		</tr>
		
		<tr>
			<th>NOTE</th>
			<td>${ob.desc}</td>
		</tr>
		
	</table>
	<a href="excel?id= ${ob.id}">Excel Export</a>
	<a href="pdf?id= ${ob.id}">Pdf Export</a>
</body>
</html>
