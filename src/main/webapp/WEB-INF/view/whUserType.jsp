<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    <html>
    <body>
    <form:form action="save" method="post" modelAttribute="WhUserTypeModel">
    <pre>
     USER TYPE::
    <form:radiobutton path="userType" value="vendor"/> VENDOR
    <form:radiobutton path="userType" value="customer"/> CUSTOMER 
    USER CODE::
    <form:input path="userCode"/> 
    
    USER FOR::
    <form:input path="userFor"/>
    USER EMAIL::
    <form:input path="email"/>
    USER CONTACT::
     <form:input path="contact"/>
    USERID TYPE::
    <form:select path="userIdType">
    <form:option value="">--select--</form:option>
    <form:option value="pan">PAN CARD</form:option>
    <form:option value="adhar">ADHAR CARD</form:option>
    <form:option value="voterid">VOTERID</form:option>
    <form:option value="other">OTHER</form:option>
    </form:select>
    IF OTHER::
    <form:input path="other"/>
    ID NUMBER::
    <form:input path="id"/>
    <input type="submit" value="create">
    </pre>
    </form:form>
    </body>
    </html>
     ${msg}
    