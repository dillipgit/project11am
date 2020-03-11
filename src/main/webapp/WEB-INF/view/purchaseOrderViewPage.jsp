<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<h2 align="center" style="color: maroon;">Welcome To PurchaseOrder
	ViewPage</h2>
<body>
	<form:form action="save" method="POST" modelAttribute="purchaseOrder">
		<pre>
ORDER CODE::
<form:input path="pCode" />
SHIPMENT CODE::
<form:select path="shipObj.shipId">
<form:option value="">-select-</form:option>
<form:options items="${shipMap}"/>
</form:select>
VENDOR::
<form:select path="whUserObj.userId">
<form:option value="">-select-</form:option>
<form:options items="${whUserMap}"/>
</form:select>
REF NO::
<form:input path="rNo" />
QUALITY CHECK::
<form:radiobutton path="qualityCheck" value="Required" />Required
<form:radiobutton path="qualityCheck" value="Not Required" />Not Required
 STATUS::
<form:input path="dStatus" readonly="true"/>
DESCRIPTION::
<form:textarea path="note" />
<input type="submit" value="place order">
</pre>
	</form:form>
	 ${message}
</body>
</html>