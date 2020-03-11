<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<h1 style="color: fuchsia;" align="center">Sale Order</h1>
</head>
<body>
<form:form action="save" method="POST" modelAttribute="saleOrder">
<pre>
Order Code::
<form:input path="orderCode"/>
Shipment Code::
<form:select path="shipCode.shipId">
<form:option value="">-select-</form:option>
<form:options items="${shipMap}"/>
</form:select>
Ref No::
<form:input path="refNo"/>
Stock Mode
<form:radiobutton path="stockMode" value="Grade"/>Grade
<form:radiobutton path="stockMode" value="Margine"/>Margine
Stock Source::
<form:select path="stockSource">
<form:option value="">-select-</form:option>
<form:option value="open">open</form:option>
<form:option value="available">available</form:option>
<form:option value="refund">refund</form:option>
</form:select>
Default Status::
<form:input path="status" readonly="true"/>
Note::
<form:textarea path="note"/>
<input type="submit" value="create sale order">
</pre>
</form:form>
  ${message}
</body>
</html>