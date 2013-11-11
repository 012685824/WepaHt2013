

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>




<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WepaHT</title>
    </head>
    <body>
        <h1>Books</h1>

            <ul>
            <li><a href="${pageContext.request.contextPath}/app/books?search=">List all</a></li>
        </ul>            
    
        <h1>Add new book</h1> 
        <a href="${pageContext.request.contextPath}/app/add">Add</a>
  
            
    </body>
</html>
