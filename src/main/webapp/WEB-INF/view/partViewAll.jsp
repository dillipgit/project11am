<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<h1 align="center" style="color: maroon;">All Part View Page</h1>
<%@include file="userMenu.jsp"%>
<body>
<form:choose>
<form:when test="${!empty list}">
<table border="1">
<tr>
<th>Code</th>
<th>Width</th>
<th>Length</th>
<th>Height</th>
<th>Uom</th>
<th>Cost</th>
<th>Currency</th>
<th>Note</th>
<th colspan="3">Operation</th>
</tr>
<form:forEach items="${list}" var="bj">
<tr> 
<td>${bj.prtCode}</td>
<td>${bj.prtWidth}</td>
<td>${bj.prtLength}</td>
<td>${bj.prtHeight}</td>
<td>${bj.uomOb.umoModel}</td>
<td>${bj.prtCost}</td>
<td>${bj.prtCurrency}</td>
<td>${bj.prtDescription}</td>
<td><a href="delete?pId=${bj.parId}">delete</a></td> 
<td><a href="edit?pId=${bj.parId}">edit</a></td> 
<td><a href="view?pId=${bj.parId}">view</a></td> 
</tr>
</form:forEach>
</table>
</form:when>
<form:otherwise>
<h3 style="color: red;">No Data Found</h3>
</form:otherwise>
</form:choose>
<a href="excel"> <img src="../resources/images/excel.jfif"
		width="120" height="60"></a>
	
	<a href="pdf"> <img src="../resources/images/pdf.jfif" width="120"
		height="60"></a>

  ${msg}
</body>
</html>