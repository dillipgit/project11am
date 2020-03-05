<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>
    <body>
    <%@include file="userMenu.jsp"%>
    <div class="container">
    <div class="card">
    <div class="card-header bg-primary text-center text-uppercase">
    <h3>Edit Page</h3>
    </div>
    <div class="card-body ">
    <form:form action="update" method="POST" modelAttribute="shipmentType">
    <div class="row">
    <div class="col-4">
    <label for="shipId ">SHIPMENT ID</label>
    </div>
    <div class="col-4">
      <form:input path="shipId" readonly="true"/>
    </div>
    </div>
    
    <div class="row">
    <div class="col-4">
    <label for="shipMode">SHIPMENT MODEL</label>
    </div>
    <div class="col-4">
      <form:select path="shipMode">
    <form:option value="">--select--</form:option>
    <form:option value="air">Air</form:option>
    <form:option value="truck">truck</form:option>
    <form:option value="ship">ship</form:option>
    <form:option value="train">train</form:option>
    </form:select>
    </div>
    </div>
   
   <div class="row">
    <div class="col-4">
    <label for="shipCode">SHIPMENT CODE</label>
    </div>
    <div class="col-4">
      <form:input path="shipCode"/>
    </div>
    </div>
    
    
    <div class="row">
    <div class="col-4">
    <label for="enbShip">ENABLE SHIPMENT</label>
    </div>
    <div class="col-4">
     <form:select path="enbShip">
    <form:option value="yes">yes</form:option>
    <form:option value="no">no</form:option>
    </form:select>
    </div>
    </div>
    
    
    
    <div class="row">
    <div class="col-4">
    <label for="shipGrade"> SHIPMENT GRADE</label>
    </div>
    <div class="col-4">
     <form:radiobutton path="shipGrade" value="a"/>A
    <form:radiobutton path="shipGrade" value="b"/>B
    <form:radiobutton path="shipGrade" value="c"/>C
    </div>
    </div>
    
    
    
    <div class="row">
    <div class="col-4">
    <label for="shipDesc">DESCRIPTION</label>
    </div>
    <div class="col-4">
     <form:textarea path="shipDesc"/>
    </div>
    </div>
   
   
     <div class="row">
    <div class="col-4"> </div>
    <div class="col-4">
    <input type="submit" value="Create Shipment" class="btn btn-success">
     <input type="reset" value="reset" class="btn btn-danger">
    </div>
    </div>
    </form:form>
    </div>
    <!--card body close  -->
    </div>
    <!--close card  -->
    </div>
    <!--close container  -->
    </body>
    </html>
