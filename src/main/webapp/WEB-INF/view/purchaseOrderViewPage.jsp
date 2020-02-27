<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<h2 align="center" style="color: maroon;">Welcome To PurchaseOrder
	ViewPage</h2>
<body>
	<form:form action="" method="" modelAttribute="">
		<pre>
ORDER CODE::
<form:input path="" />
REF NO::
<form:input path="" />
QUALITY CHECK::
<form:radiobutton path="" value="" />Required
<form:radiobutton path="" value="" />Not Required
DEFAULT STATUS::
<form:input path="" />
DESCRIPTION::
<form:textarea path="" />
<input type="submit" value="place order">
</pre>
	</form:form>
</body>
</html>