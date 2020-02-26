<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <h1 align="center" style="color: navy;">OneOrder ViewPage</h1>
    <html>
    <body>
    <table border="1">
    <tr>
    <th>ID</th><td>${ob.id}</td>
    </tr>
    <tr>
    <th>MODE</th><td>${ob.mode}</td>
    </tr>
    <tr>
    <th>CODE</th><td>${ob.code}</td>
    </tr>
    <tr>
    <th>ORDER TYPE</th><td>${ob.method}</td>
    </tr>
    <tr>
    <th>ACCEPT</th><td>${ob.accept}</td>
    </tr>
    <tr>
    <th>NOTE</th><td>${ob.desc}</td>
    </tr>
    </table>
    </body>
    </html>
    