<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<html>
<body>
<h1 align="center" style="color: green;">WELCOME TO DOCUMENT PAGE</h1>
<form action="upload" method="post" enctype="multipart/form-data">
<pre>
ID::<input type="text" name="fileId">
DOC::<input type="file" name="fileOb">
<input type="submit" value="upload">
</pre>
</form>
<!--before using (redirect:show)  -->
 <%--  ${message} --%>
</body>
</html>

 <table border="1">
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>LINK</th>
    </tr>
    <c:forEach items="${list}" var="ob">
    <tr>
    <td>${ob[0]}</td>
    <td>${ob[1]}</td>
    <td><a href="download?fileId=${ob[0]}">DOWNLOAD</a></td>
    </tr>
    </c:forEach>
    </table>