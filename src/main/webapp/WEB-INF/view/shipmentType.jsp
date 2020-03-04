<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
</head>
<body>
	<%@include file="userMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome to shipment type registration page</h3>
			</div>

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="shipmentType">
				
					<div class="row">
						<div class="col-4">
							<label for="shipMode"><b>SHIPMENT MODE</b></label>
						</div>
						<div class="col-4">
							<form:select path="shipMode" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="air">AIR</form:option>
								<form:option value="truck">TRUCK</form:option>
								<form:option value="ship">SHIP</form:option>
								<form:option value="train">TRAIN</form:option>
							</form:select>
						</div>
					</div>
					<div class="col-4">
						<!--Error Message  -->
					</div>
			</div>
			<!--card-body close  -->

			<div class="row">
				<div class="col-4">
					<label for="shipCode"><b>SHIPMENT CODE</b></label>
				</div>
				<div class="coi-4">
					<form:input path="shipCode" />
				</div>
				<div class="col-4">
					<!--Error message  -->
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="enbShip"><b>ENABLE SHIPMENT</b></label>
				</div>
				<div class="col-4">
					<form:select path="enbShip">
						<form:option value="">--SELECT--</form:option>
						<form:option value="yes">YES</form:option>
						<form:option value="no">NO</form:option>
					</form:select>
				</div>
				<div class="row-4">
					<!--Error message  -->
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label><b>SHIPMENT GRADE</b></label>
				</div>
				<div class="col-4">
					<form:radiobutton path="shipGrade" value="a" />
					A
					<form:radiobutton path="shipGrade" value="b" />
					B
					<form:radiobutton path="shipGrade" value="c" />
					C
				</div>
				<div class="col-4">
					<!--Error message  -->
				</div>
			</div>

			<div class="row">
				<div class="col-4">
					<label for="shipDesc"><b> DESCRIPTION</b></label>
				</div>
				<div class="col-4">
					<form:textarea path="shipDesc" />
				</div>
				<div class="col-4">
					<
					<!--Error Message  -->
				</div>
			</div>

			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<input type="submit" value="register" class="btn btn-success">
					<input type="reset" value="reset" class="btn btn-danger">
				</div>
			</div>
			</form:form>

		</div>
		<c:if test="${!empty message }">
		<div class="card-footer bg-info text-white text-center">
			<b> ${message}</b>
		</div>
		</c:if>
		</div>
		<!--card close  -->
	</div>
	<!-- container close -->
</body>
</html>





















<%-- <html>
    <body>
    <h1 align="center" style="color: fuchsia;">Shipment Type Registration Page</h1>
    <form:form action="save" method="POST" modelAttribute="shipmentType">
    <pre>
    SHIPMENT MODE::
    <form:select path="shipMode">
    <form:option value="">--SELECT--</form:option>
    <form:option value="air">AIR</form:option>
    <form:option value="truck">TRUCK</form:option>
    <form:option value="ship">SHIP</form:option>
    <form:option value="train">TRAIN</form:option>
    </form:select>
    SHIPMENT CODE::
    <form:input path="shipCode"/>
    ENABLE SHIPMENT::
    <form:select path="enbShip">
    <form:option value="">--SELECT--</form:option>
    <form:option value="yes">YES</form:option>
    <form:option value="no">NO</form:option>
    </form:select>
    SHIPMENT GRADE::
  
    <form:radiobutton path="shipGrade" value="a"/>A
    <form:radiobutton path="shipGrade" value="b"/>B
    <form:radiobutton path="shipGrade" value="c"/>C
   DESCRIPTION::
   <form:textarea path="shipDesc"/>
    <input type="submit" value="register">
    </pre>
    </form:form>
     ${message}
    </body>
    </html> --%>





<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1 align="center" style="color: aqua">Welcome To Shipment Type Registration Page</h1>
</head>
<body>
<form action="save" method="POST">
<pre>
<b>Shipment Mode:</b>
       <select name="shipMode">
       <option>---select---</option>
       <option>Air</option>
       <option>Truck</option>
       <option>Ship</option>
       <option>Train</option>
       </select>
<b>Shipment Code:</b>
        <input type="text" name="shipCode">
<b>Enable Shipment:</b>
         <select name="enbShip">
         <option>---select---</option>
         <option>yes</option>
         <option>no</option>
         </select>
<b>Shipment Grade:</b>
          <input type="radio" name="shipGrade" value="a">A
          <input type="radio" name="shipGrade" value="b">B
          <input type="radio" name="shipGrade" value="c">C
<b>Description:</b>
           <textarea name="shipDesc"></textarea>
           <input type="submit" value="register">
</pre>
</form>
  ${message}
</body>
</html --%>