<%-- 
    Document   : admin_dashboard
    Created on : Dec 8, 2015, 1:41:58 PM
    Author     : Kelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smarthomes - Admin</title>
                <link href="style/admin_core.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div id="dashboard-banner">
            <h2>SmartHomes</h2>
            <h3> Property Management Dashboard</h3>>
        </div>
            <div id="menu-bar">
                <div class="menu-bar-item"  id="first"><a href="properties?requestId=1">Properties</a></div>
                <div class="menu-bar-item"><a href="admin_list_properties.jsp">Bookings</a></div>
            </div>
            <div id="toolbar">
                <a href="NewProp.jsp"><img src="images/icons/ic_action_add.png" width="30px" height="30px" alt=""/>New</a>
                <a href="edit_properties.jsp"><img src="images/icons/ic_action_edit.png" width="30px" height="30px" alt=""/>Edit</a>
                <a href="#"><img src="images/icons/ic_action_search.png" width="30px" height="30px" alt=""/>Search</a>
                <a href="#"><img src="images/icons/ic_action_sms.png" width="30px" height="30px" alt=""/>Delete</a>
                <a href="#"><img src="images/icons/ic_action_trash.png" width="30px" height="30px" alt=""/>Delete</a>
                <span id="toolbar-item"></span>
            </div>
    </body>
</html>
