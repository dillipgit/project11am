<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<%@include file="userMenu.jsp" %>
<div class="container">
		<div class="card">
		<div class="card-header bg-primary text-white text-center text-uppercase">
		<h3>welcome to shipment type data page</h3>
		</div>
		
		<div class="card-body">
	<c:choose>
		<c:when test="${!empty list }">
			<table class="table  table-hover">
				<tr  class="bg-success text-white">
				<!-- 	<th>ID</th> -->
					<th>CODE</th>
					<th>GRADE</th>
					<th>MODE</th>
					<th>ENABLE</th>
					<th>DESC</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr style="color">
						<%-- <th>${ob.shipId}</th> --%>
						<th>${ob.shipCode}</th>
						<th>${ob.shipGrade}</th>
						<th>${ob.shipMode}</th>
						<th>${ob.enbShip}</th>
						<th>${ob.shipDesc}</th>
						<!-- <th><a href=delete?shipId=${ob.shipId}> <img  src="../resources/images/delete.png" width="40" height="40"></a></a></th>
						<th><a href=edit?shipId=${ob.shipId}> <img  src="../resources/images/edit.jfif" width="40" height="40"></a></a></th>
						<th><a href=view?shipId=${ob.shipId}> <img  src="../resources/images/view.png" width="40" height="40"></a></a></th> -->
						
						<th><a href=delete?shipId=${ob.shipId} class="btn btn-danger">DELETE</a></th>
						<th><a href=edit?shipId=${ob.shipId} class="btn btn-warning">EDIT</a></th>
						<th><a href=view?shipId=${ob.shipId} class="btn btn-info">VIEW</a></th> 
					</tr>
				</c:forEach>
			</table>
</c:when>
		<c:otherwise>
			<h4 style="color: red;">No Data Found</h2>
		</c:otherwise>
	</c:choose>
	 </div>
	 
	 <c:if test="${!empty message }">
	 <c:choose>
	 <c:when test="${opr eq 'DEL' }">
	 <div class="card-footer bg-info text-white text-center"><b>${message}</b></div>
	 </c:when>
	 <c:otherwise>
	 <div class="card-footer bg-info text-white text-center"><b>${message}</b></div>
	 </c:otherwise>
	 </c:choose>
	 </c:if>
	
	</div>
	<!--close container  -->
	 <a href="excel"> <img src="../resources/images/excel.jfif"
		width="120" height="60"></a>

	<a href="pdf"> <img src="../resources/images/pdf.jfif" width="120"
		height="60"></a>
	
</body>
</html>

  <%--  ${shipmentTypeEdit} --%>
