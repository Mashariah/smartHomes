<%-- 
    Document   : properties
    Created on : 17-Nov-2015, 15:18:27
    Author     : Kelli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="style/core.css" rel="stylesheet"/>
        <link type="text/css" href="style/banner.css" rel="stylesheet"/>
        <link type="text/css" href="style/nav-bar.css" rel="stylesheet"/>
        <title>| Smart Homes |</title>
    </head>
    <body>
        <div id="banner">
            <div id="logo"><img src="images/banners/logo_1.png" width="100px" height="100px" alt="comp-logo"/></div>
            <div id="comp-name">  .</div>
        </div>
        <div class="content-body">
            <%@include file="menubar.jsp"%>
            <div id="register-login-bar">
                <a href="#">Login</a> | 
                <a href="#">Register</a>
            </div>
            <c:forEach var="item" items="${pageScope.listing}">
                            <c:out value="${item}"/>
                    </c:forEach>
            <table>
                <thead></thead>
                <tbody>
                    <c:forEach var="current" items="${listing}">
                        <tr >
                            <td>
                            <div class="plist-item">
                                <div class="plist-thumbnail">
                                    <img 
                                        src="imgsrv?dirName=${current.imgDirLocation}&imageFile=index.jpg" width="330px" height="200px"/>
                                    <div class="plist-thumbnail-status">${current.saleStatus}</div>
                                </div>
                                <div class="plist-item-header">${current.header}</div>
                                <span class="plist-item-pricetag">${current.priceFormatted}</span>
                                <span class="plist-item-text">${current.description}</span>
                                <a href="details?propId=${current.propertyId}" class="plist-item-btndetails">View Details</a>
                            </div>
                        </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script>
        function formatCurrency(val){
            return val.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g,'Ksh1,');
        }
        </script>
</html>

