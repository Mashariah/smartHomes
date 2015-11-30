<%-- 
    Document   : details
    Created on : Nov 24, 2015, 1:35:11 PM
    Author     : Kelli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>|Smarthomes - Property Details | </title>
        <!--css -->
        <link type="text/css" href="/style/jquery-ui.css" rel="stylesheet"/>
        <link type="text/css" href="style/core.css" rel="stylesheet"/>
        <link type="text/css" href="style/banner.css" rel="stylesheet"/>
        <link type="text/css" href="style/nav-bar.css" rel="stylesheet"/>
        <!--scripts -->
        <script src="scripts/jquery-2.1.3.min.js" type="text/javascript"></script>

        <!-- 1. Link to jQuery (1.8 or later), -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> <!-- 33 KB -->

        <!-- fotorama.css & fotorama.js. -->
        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->

        <!-- 2. Add images to <div class="fotorama"></div>. -->

    </head>
    <body>
        <div id="banner">
            <div id="logo"><img src="images/banners/logo_1.png" width="100px" height="100px" alt="comp-logo"/></div>
            <div id="comp-name"></div>
        </div>
        <div class="content-body">
            <%@include file="menubar.jsp"%>
            <div id="register-login-bar">
                <a href="#">Login</a> | 
                <a href="#">Register</a>
            </div>
                <div class="fotorama" data-nav="thumbs">
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=index.jpg">
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb1.jpg">
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb2.jpg" >
                </div>
            <div class="details-desc">
                <table>
                    <tr><td id="head">${selectedProperty.header}</td></tr>
                    <!--<tr><td>Type: ${selectedProperty.propertyType}</td></tr>-->
                    <tr><td id="price-tag">Price: Ksh ${selectedProperty.price}</td></tr>
                    <tr><td>${selectedProperty.description}</td></tr>
                    <tr><td id="head">Location Details</td></tr>
                    <tr><td><strong>County:</strong> ${selectedProperty.location.county}</td></tr>
                    <tr><td><strong>Division:</strong> ${selectedProperty.location.division}</td></tr>
                    <tr><td><strong>Town:</strong> ${selectedProperty.location.town}</td></tr>
                    <tr><td><strong>Road:</strong> ${selectedProperty.location.road}</td></tr>
                </table>
                
            </div>
            <div class="details-toolbar">
                <a href="#" id="lnk_mail">Text Message</a>
                <a href="#">Email</a>
                <a href="#">Location Map</a>
                <div class="email-board"><form><input type="text" name="f" placeholder="Message"/></form></div>
            </div>
        </div>
            <script>
                $('lnk_mail').click(function(){
                    $('email-board').css("display","inline-block");
                });
            </script>
    </body>
    
</html>
