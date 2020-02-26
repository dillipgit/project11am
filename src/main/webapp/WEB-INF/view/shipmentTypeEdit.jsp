<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html>
    <body>
    <h1 align="center"  style="color: fuchsia;">Edit Shipment</h1>
    <form:form action="update" method="POST" modelAttribute="shipmentType">
    <pre>
    SHIPMENT ID::
    <form:input path="shipId" readonly="true"/>
    SHIPMENT MODEL::
    <form:select path="shipMode">
    <form:option value="">--select--</form:option>
    <form:option value="air">Air</form:option>
    <form:option value="truck">truck</form:option>
    <form:option value="ship">ship</form:option>
    <form:option value="train">train</form:option>
    </form:select>
    SHIPMENT CODE::
    <form:input path="shipCode"/>
    ENABLE SHIPMENT::
    <form:select path="enbShip">
    <form:option value="yes">yes</form:option>
    <form:option value="no">no</form:option>
    </form:select>
    SHIPMENT GRADE::
    <form:radiobutton path="shipGrade" value="a"/>A
    <form:radiobutton path="shipGrade" value="b"/>B
    <form:radiobutton path="shipGrade" value="c"/>C
    DESCRIPTION::
    <form:textarea path="shipDesc"/>
    <input type="submit" value="Create Shipment">
    </pre>
    </form:form>
    </body>
    </html>
