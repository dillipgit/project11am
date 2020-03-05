<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
  <html>
  <body>
  <h4 align="center" style="color: teal;">Unit Of Measure Page</h4>
  <%@include file="userMenu.jsp"%>
  <form:form action="save" method="POST" modelAttribute="unitOfMeasure">
  <pre>
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
    <input type="submit" value="create UMO">
  </pre>
  </form:form>
   ${msg}
  </body>
  </html>  
    
   
    
   <%--  <h1 align="center" style="color: aqua;">Unit Of Measure Registration Form</h1>
    <form action="save" method="POST">
    <pre>
    UMO TYPE:
           <select name="umoType">
           <option>---SELECT---</option>
           <option>PACKING</option>
           <option>NO PACKING</option>
           <option>---NA---</option>
           </select>
     UMO MODEL:
            <input type="text" name="umoModel">
      DESCRIPTION:
             <textarea rows="20" cols="20" name="desc"></textarea>
             <input type="submit" value="create UMO">
    </pre>
    
    </form>
       --%>
