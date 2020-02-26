<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
  <html>
  <body>
  <h4 align="center" style="color: teal;">Unit Of Measure Update Page</h4>
  
  <form:form action="update" method="POST" modelAttribute="unitOfMeasure">
  <pre>
  UOM ID::
  <form:input path="id" readonly="true" />
   UOM TYPE::
   <form:select path="umoType">
   <form:option value=" ">--SELECT--</form:option>
   <form:option value="Packing">PACKING</form:option>
   <form:option value="No Package">NO PACKAGE</form:option>
   <form:option value=" ">--NA--</form:option>
   </form:select>
   UOM MODEL::
   <form:input path="umoModel"/>
   DESCRIPTION::
   <form:textarea path="desc"/>
    <input type="submit" value="update">
  </pre>
  </form:form>
  </body>
  </html>  
    