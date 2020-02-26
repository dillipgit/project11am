<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
     <h1 align="center" style="color: fuchsia">All Table</h1>
     
    <c:choose>
    <c:when test="${!empty list}">
    <table border="1">
    <tr>
    <th>ID</th>
    <th>MODE</th>
    <th>CODE</th>
    <th>METHOD</th>
    <th>ACCEPT</th>
    <th>DESC</th>
    <th colspan="3">DELETE</th>
    </tr>
    <c:forEach items="${list}" var="ob">
    <tr>
    <td> ${ob.id} </td>
    <td> ${ob.mode} </td>
    <td> ${ob.code} </td>
    <td> ${ob.method} </td>
    <td> ${ob.accept} </td>
    <td> ${ob.desc} </td>
     <td><a href="delete?mid= ${ob.id}">delete</a> </td>
     <td><a href="edit?mid= ${ob.id}">edit</a> </td>
     <td><a href="view?mid= ${ob.id}">view</a> </td>
    </tr>
      
    </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
    <h1>No Data Found</h1>
    </c:otherwise>
    </c:choose>
    ${msg} 
 