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
        <h1>Book</h1>

        
        <a href="${pageContext.request.contextPath}/app/">Back to index</a>
        
        <h1>${book.name}</h1>
        
        <strong>Book name: </strong>${book.name}<br/>
        <strong>Authors: </strong>${book.authors}<br/>
        <strong>Publishers: </strong>${book.publishers}<br/>
        <strong>Isbn: </strong>${book.isbn}<br/>
        <strong>Publishing Date: </strong>${book.publish_date}<br/>
   
        
        <H1>Oletko varma että kirja poistetaan<H1>
         <form:form action="${pageContext.request.contextPath}/app/del/${book.id}" method="DELETE">
             
            <input type="submit" name="poista" value="Poista kirja">
        </form:form>
            
    </body>
</html>
