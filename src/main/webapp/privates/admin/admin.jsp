<%-- 
    Document   : admin
    Created on : Jun 8, 2017, 7:17:29 PM
    Author     : Mohammad
--%>

<%@page import="ir.faradeh.model.entity.AdminEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/iran_yekan_style.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-rtl/3.4.0/css/bootstrap-rtl.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.3.2/js/mdb.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/content/css/general_styles.css" />
        <script src="/content/scripts/script.js"></script>
        <link rel="shortcut icon" href="" type="image/x-icon">
        <link rel="icon" href="" type="image/x-icon">
        <title>ادمین</title>
    </head>
    <body>
        <%
            AdminEntity entity = (AdminEntity) request.getAttribute("entity");
        %>

        <form action="/Faradeh/privates/admin/editadmin" method="post">
            <label><%=entity.getId().toHexString()%></label><br/>
            <input type="hidden" value="<%=entity.getId().toHexString()%>" name="Id" />
            <input type="text" value="<%=entity.getFirstName() %>" name="FirstName" class="form-control"/>
            <input type="text" value="<%=entity.getLastName() %>" name="LastName" class="form-control"/>
            <input type="text" value="<%=entity.getMobileNumber() %>" name="MobileNumber" class="form-control"/>
            <input type="text" value="<%=entity.getHomeNumber() %>" name="HomeNumber" class="form-control"/>
            <input type="text" value="<%=entity.getEmail() %>" name="Email" class="form-control"/>
            <input type="text" value="<%=entity.getUsername() %>" name="Username" class="form-control"/>
            <input type="password" name="Password" class="form-control"/>
            <input type="submit" value="ویرایش" class="form-control"/>
        </form>
    </body>
</html>
