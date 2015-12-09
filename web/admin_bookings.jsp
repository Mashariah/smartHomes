<%-- 
    Document   : admin_bookings
    Created on : Dec 9, 2015, 5:43:55 PM
    Author     : Kelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SmartHomes - Bookings</title>
        <link href="style/admin_core.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--<div id="scontent">-->
        <%@include  file="admin_dashboard.jsp"%>
        <table>
            <thead></thead>
            <tbody>
            <c:forEach var="current" items="${bookings}">
                <tr>
                    <td>item</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <!--</div>-->
</body>
</html>
