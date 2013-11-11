
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WepaHT</title>
    </head>
    <body>
        <h1>Books</h1>
    <a href="${pageContext.request.contextPath}/app/">Back to index</a><br>
    
        <h1>Add new book</h1> 
        
 
        
        <form:form commandName="book" action="${pageContext.request.contextPath}/app/add" method="POST">
            Isbn: <form:input id="isbn" path="isbn"/> <form:errors path="isbn" />Pakollinen<br/>
            Name: <form:input id="name" path="name" />  <form:errors path="name" /><br/>
            Authors: <form:input id="authors" path="authors" /> <form:errors path="authors" /><br/>
            Publishers: <form:input id="publishers" path="publishers"/> <form:errors path="publishers" /><br/>
            Publishing Date: <form:input id="publish_date" path="publish_date"/> <form:errors path="publish_date" /><br/>
            <input type="submit" value="ADD">

        </form:form>
         <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
            
    </body>
</html>
