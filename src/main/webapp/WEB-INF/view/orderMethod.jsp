<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <h1 align="center" style="color: aqua">Welcome To OrderMethod</h1>
 
 
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 <html>
 <body>
 <form:form action="save" method="POST" modelAttribute="orderMethod">
 <pre>
 ORDER MODE::
 <form:radiobutton path="mode" value="sale"/>SALE
 <form:radiobutton path="mode" value="purchase"/>PURCHASE
 ORDER CODE::
 <form:input path="code"/>
 ORDER METHOD::
 <form:select path="method">
 <form:option value="">--SELECT--</form:option>
 <form:option value="fifo">FIFO</form:option>
 <form:option value="lifo">LIFO</form:option>
 <form:option value="fcfo">FCFO</form:option>
 <form:option value="fefo">FEFO</form:option>
 </form:select>
 ORDER ACCEPT::
 <form:checkbox path="accept" value="multi-model"/>MULTI-MODEL
 <form:checkbox path="accept" value="accept-returns"/>ACCEPT RETURNS
 DESCRIPTION::
 <form:textarea path="desc"/>
 <input type="submit" value="create"/>
 </pre>
 </form:form>
  ${msg} 
 </body>
 </html>
 
    
   <%--  <form action="save" method="POST">
    <pre>
    Order Mode:<input type="radio" name="mode" value="sale">sale
                         <input type="radio" name="mode" value="purchase">purchase
     Order Code:
                        <input type="text" name="code">
      Order Method:
                         <select name="method">
                         <option>---SELECT---</option>
                         <option>FIFO</option>
                         <option>LIFO</option>
                         <option>FCFO</option>
                         <option>FEFO</option>
                         </select>
      Order Accept:
                          <input type="checkbox" name="accept" value="mm">Multi-Model
                           <input type="checkbox" name="accept" value="ar">Accept-Returns
      Descrition:<textarea name="desc"></textarea>
      
      <input type="submit" value="create"/>
    </pre>
      ${msg} 
    </form>
 --%>






