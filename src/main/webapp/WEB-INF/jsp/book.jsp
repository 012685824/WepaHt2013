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
        <a href="${pageContext.request.contextPath}/app/books?search=">Back to books</a>
        <h1>${book.name}</h1>
        
        <strong>Book name: </strong>${book.name}<br/>
        <strong>Authors: </strong>${book.authors}<br/>
        <strong>Publishers: </strong>${book.publishers}<br/>
        <strong>Isbn: </strong>${book.isbn}<br/>
        <strong>Publishing Date: </strong>${book.publish_date}<br/>
        <img src="${book.cover}" alt="${book.name}"><br/>
   
        <a href="${pageContext.request.contextPath}/app/edit/${book.id}">Muokkaa kirjan tietoja</a>
        <a href="${pageContext.request.contextPath}/app/del/${book.id}">Poista kirja</a>

    </body>
</html>
