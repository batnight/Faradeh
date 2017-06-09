<%-- 
    Document   : institutions
    Created on : Jun 9, 2017, 3:12:29 PM
    Author     : Mohammad
--%>

<%@page import="ir.faradeh.model.entity.InstitutionEntity"%>
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
        <title>مدیریت موسسه ها</title>
    </head>
    <body>
        <table class="table-responsive table-bordered">
            <tr>
                <td>شناسه</td>
                <td>نام موسسه</td>
                <td>ایمیل  موسسه</td>
                <td>شماره تلفن موسسه</td>
                <td>وبسایت موسسه</td>
                <td>ویرایش</td>
                <td>حذف</td>
            </tr>
            <%
                List<InstitutionEntity> list = (List<InstitutionEntity>) request.getAttribute("list");
                for (InstitutionEntity entity : list) {
            %>
            <tr>
                <td><%=entity.getId().toHexString()%></td>
                <td><%=entity.getInstitutionName()%></td>
                <td><%=entity.getInstitutionPhoneNumber()%></td>
                <td><%=entity.getInstitutionEmail()%></td>
                <td><%=entity.getInstitutionWebsite()%></td>
     
                <td>
                    <a href="/Faradeh/privates/admin/editinstitution?Id=<%=entity.getId().toHexString()%>">ویرایش</a>
                </td>
                <td>
                    <form action="/Faradeh/privates/admin/deleteinstitution" method="post" >
                        <input type="hidden" name="Id" value="<%=entity.getId().toHexString()%>" />
                        <input type="submit" value="حذف" class="btn-link" />
                    </form>
                </td>

            </tr>
            <%}%>
        </table>
        <a href="/Faradeh/privates/admin/dashboard.html">بازگشت به پنل</a>
        <br/>
        <a href="/Faradeh/privates/admin/addinstitution.html">اضافه کردن موسسه جدید</a>
    </body>
</html>
