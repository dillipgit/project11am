<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<h3 align="center" style="color: fuchsia;">Welcome To View Page</h3>
<body>
<table border="1">
<tr>
<th>ID</th><td>  ${ob.userId}</td>
</tr>
<tr>
<th>USER TYPE</th><td>${ob.userType}</td>
</tr>
<tr>
<th>USER CODE</th><td>${ob.userCode}</td>
</tr>
<tr>
<th>USER FOR</th><td>${ob.userFor}</td>
</tr>
<tr>
<th>EMAIL</th><td> ${ob.email}</td>
</tr>
<tr>
<th>CONTACT</th><td> ${ob.contact}</td>
</tr>
<tr>
<th>USERID</th><td> ${ob.userIdType}</td>
</tr>
<tr>
<th>OTHER</th><td> ${ob.other}</td>
</tr>
<tr>
<th>IDNUMBER</th><td> ${ob.id}</td>
</tr>
</table>
<a href="excel?id= ${ob.userId}">Excel Export</a>
	<a href="pdf?id= ${ob.userId}">Pdf Export</a>

</body>
</html>