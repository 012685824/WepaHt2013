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
        
<script type="text/javascript">
    var base="http://localhost:8080/WepaHT/app/books?search=";
    

function etsi() {
    var url ="";
    var a = document.getElementById("nimi").value;
    var b = document.getElementById("tekija").value;
    if(b == ""){
         url = base+a+"&mista=nimi";
    }
    if(a == ""){
         url = base+b+"&mista=tekija";
    }
    
    
    open(url,'_self',true);
}
</script>
Etsi nimellä
<input type="text" id="nimi" size=20 value="" onChange="etsi();">
Etsi tekijällä
<input type="text" id="tekija" size=20 value="" onChange="etsi();">


        <ul>
            <c:forEach var="book" items="${books}">
                
                <li><a href="${pageContext.request.contextPath}/app/books/${book.id}">${book.name}</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
