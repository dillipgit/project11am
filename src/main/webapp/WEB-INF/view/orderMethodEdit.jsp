<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    <html>
    <body>
    <h1 align="center" style="color:olive;">Edit Page</h1>
    <form:form action="update" method="post" modelAttribute="orderMethod">
    <pre>
    ORDER ID::
    <form:input path="id" readonly="true"/>
    ORDER MODE::
    <form:radiobutton path="mode" value="sale"/>sale
    <form:radiobutton path="mode" value="purchase"/>purchase
    ORDER CODE::
    <form:input path="code"/>
    ORDER TYPE::
    <form:select path="method">
    <form:option value="">---select---</form:option>
    <form:option value="fifo">fifo</form:option>
    <form:option value="lifo">lifo</form:option>
    <form:option value="fefo">fefo</form:option>
    <form:option value="fcfo">fcfo</form:option>
    </form:select>
    ORDER ACCEPT::
    <form:checkbox path="accept"  value="multi-model"/>Multi Model
    <form:checkbox path="accept"  value="accept-returns"/>Accept returns
    DESCRIPTION::
    <form:textarea path="desc"/>
    <input type="submit" value="create order">
    </pre>
    </form:form>
    </body>
    </html>
