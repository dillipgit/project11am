<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
	

<html>
<body>
<%@include file="userMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-white text-center text-uppercase">
<h3>ShipmentType ViewPage</h3>
</div>
<div class="card-body">
	<table class="table table-hover">
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
	</div>
	<!--card body  -->
	
	<div class="card-footer bg-primary">
	<a href="excel?id=${ob.shipId}">
	               <img  src="../resources/images/excel.jfif" width="60" height="60"></a>
	<a href="pdf?id=${ob.shipId}">
	               <img  src="../resources/images/pdf.jfif"  width="60" height="60"></a> 
	</div>
	         </div>
	         <!--card close  --> 
	         
	   </div>
	   <!--container close  -->          
	    
</body>
</html>
