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
                                <span class="plist-item-pricetag">Ksh ${current.price}</span>
                                <span class="plist-item-text">${current.description}</span>
                                <a href="#" class="plist-item-btndetails">View Details</a>
                            </div>
                        </td>
                        </tr>
                    </c:forEach>
<!--                        <tr >
                            <td>
                            <div class="plist-item">
                            <%--<c:out value="${current.description}"></c:out>--%>
                                <div class="plist-thumbnail">
                                    <img src="images/slider/bn_pic2.jpg" width="325px" height="200px"/>
                                <div class="plist-thumbnail-status">Available</div>
                                </div>
                                <div class="plist-item-header">3 Bedroomed, Kileleshwa</div>
                                <span class="plist-item-pricetag">Ksh 120 000</span> 
                            <c:out value=""></c:out>
                                <span class="plist-item-text">It comes with a large living room with balcony, spacious well finished Kitchen. High ceilings Large windows, multiple light fixtures, ample storage in both kitchens and bedrooms. The 3 bedroom Apartment has 2 bedrooms en suite, and one shared bathroom. The master Bedroom has a balcony. 3rd non en suite bedroom is ideal as a guest bedroom or study.</span>
                                <a href="#" class="plist-item-btndetails">View Details</a>
                            </div>
                        </td>
                        </tr>
                   
                   
                    -->
                </tbody>
            </table>
        </div>
    </body>
</html>

