<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<h2 align="center" style="color: maroon;">Welcome To PurchaseOrder
	ViewPage</h2>
<body>
	<form:form action="save" method="post" modelAttribute="purchaseOrder">
		<pre>
ORDER CODE::
<form:input path="pCode" />
REF NO::
<form:input path="rNo" />
QUALITY CHECK::
<form:radiobutton path="qualityCheck" value="Required" />Required
<form:radiobutton path="qualityCheck" value="Not Required" />Not Required
DEFAULT STATUS::
<form:input path="dStatus" />
DESCRIPTION::
<form:textarea path="desc" />
<input type="submit" value="place order">
</pre>
	</form:form>
	 ${message}
</body>
</html>