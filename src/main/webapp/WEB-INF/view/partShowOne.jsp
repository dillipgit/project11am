<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<h1 align="center" style="color: gray;">Welcome One Part</h1>
<body>
<table border="1">
<tr>
<th>CODE</th><td>${ob.prtCode}</td>
</tr>
<tr>
<th>WIDTH</th><td>${ob.prtWidth}</td>
</tr>
<tr>
<th>LENGTH</th><td>${ob.prtLength}</td>
</tr>
<tr>
<th>HEIGHT</th><td>${ob.prtHeight}</td>
</tr>
<tr>
<th>UOM</th><td>${ob.uomOb}</td>
</tr>
<tr>
<th>Sale Mode</th><td>${ob.omSaleOb}</td>
</tr>
<tr>
<th>COST</th><td>${ob.prtCost}</td>
</tr>
<tr>
<th>CURRENCY</th><td>${ob.prtCurrency}</td>
</tr>
<tr>
<th>NOTE</th><td>${ob.prtDescription}</td>
</tr>
</table>
<a href="excel?id=${ob.parId}">
	               <img  src="../resources/images/excel.jfif" width="60" height="60"></a>
	<a href="pdf?id=${ob.parId}">
	               <img  src="../resources/images/pdf.jfif"  width="60" height="60"></a>
</body>
</html>