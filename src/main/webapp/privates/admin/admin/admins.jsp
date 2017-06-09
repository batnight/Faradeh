<%-- 
    Document   : admins
    Created on : Jun 8, 2017, 4:43:06 PM
    Author     : Mohammad
--%>

<%@page import="ir.faradeh.model.entity.AdminEntity"%>
<%@page import="java.util.List"%>
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
        <title>مدیریت ادمین ها</title>
    </head>
    <body>
        <table class="table-responsive table-bordered">
            <tr>
                <td>شناسه</td>
                <td>نام</td>
                <td>نام خانوادگی</td>
                <td>ایمیل</td>
                <td>شماره همراه</td>
                <td>شماره منزل</td>
                <td>نام  کاربری</td>
                <td>ویرایش</td>
                <td>حذف</td>
            </tr>

            <%
                List<AdminEntity> list = (List<AdminEntity>) request.getAttribute("list");
                for (AdminEntity entity : list) {
            %>
            <tr>
                <td><%=entity.getId().toHexString()%></td>
                <td><%=entity.getFirstName()%></td>
                <td><%=entity.getLastName()%></td>
                <td><%=entity.getEmail()%></td>
                <td><%=entity.getMobileNumber()%></td>
                <td><%=entity.getHomeNumber()%></td>
                <td><%=entity.getUsername()%></td>
                <td>
                    <a href="/Faradeh/privates/admin/editadmin?Id=<%=entity.getId().toHexString()%>">ویرایش</a>
                </td>
                <td>
                    <form action="/Faradeh/privates/admin/deleteadmin" method="post" >
                        <input type="hidden" name="Id" value="<%=entity.getId().toHexString()%>" />
                        <input type="submit" value="حذف" class="btn-link" />
                    </form>
                </td>

            </tr>
            <%}%>
        </table>
        <a href="/Faradeh/privates/admin/dashboard.html">بازگشت به پنل</a>
        <br/>
        <a href="/Faradeh/privates/admin/admin/addadmin.html">اضافه کردن ادمین جدید</a>
    </body>
</html>
