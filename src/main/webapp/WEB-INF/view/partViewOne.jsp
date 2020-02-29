<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<h1 align="center" style="color: purple;">One Part Details</h1>
<body>
<form:form action="update" method="POST" modelAttribute="msg">
<pre>
ID::
<form:input path="parId" readonly="true"/>
CODE::
<form:input path="prtCode" />
WIDTH::
<form:input path="prtWidth" />
LENGTH::
<form:input path="prtLength" />
HEIGHT:: 
<form:input path="prtHeight"/>
BASE COST::
<form:input path="prtCost"/>
BASE CURRENCY::
<form:select path="prtCurrency">
<form:option value="">--select--</form:option>
<form:option value="inr">INR</form:option>
<form:option value="usd">USD</form:option>
<form:option value="aus">AUS</form:option>
<form:option value="eru">ERU</form:option>
</form:select>
DESCRIPTION::
<form:textarea path="prtDescription" />
<input type="submit" value="update" />
</form:form>
</pre>
</body>
</html>