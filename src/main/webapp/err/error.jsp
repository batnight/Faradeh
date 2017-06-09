<%-- 
    Document   : error
    Created on : Jun 8, 2017, 5:46:25 PM
    Author     : Mohammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>خطا</title>
    </head>
    <body>
        <h1><%=request.getAttribute("errorMessage")%></h1>
    </body>
</html>
