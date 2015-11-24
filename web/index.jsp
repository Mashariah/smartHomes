<%-- 
    Document   : index
    Created on : 07-Nov-2015, 15:37:07
    Author     : Kelli
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="scripts/jquery-2.1.3.min.js"></script>
        <script src="scripts/jquery.bxslider.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="/style/jquery.bxslider.css" rel="stylesheet"/>
        <link type="text/css" href="style/core.css" rel="stylesheet"/>
        <link type="text/css" href="style/banner.css" rel="stylesheet"/>
        <link type="text/css" href="style/nav-bar.css" rel="stylesheet"/>
        <title>| Smart Homes |</title>
    </head>
    <body id="index-bg">
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
            <div id="search-widget">
                <span id="search-widget">Find Your Ideal Home, Apartment or Land Plot</span>
                <form>
                    <input id="search-widget" type="text" name="search" placeholder="Search Town, City or Estate"/>
                    <input type="submit" name="btnTest" value="search"/>
                </form>
                <ul class="bxslider">
                    <li><img  src="images/slider/bn_pic1.jpg"/></li>
                    <li><img  src="images/slider/bn_pic2.jpg"/></li>
                    <li><img  src="images/slider/bn_pic3.jpg"/></li>
                    <li><img  src="images/slider/bn_pic4.jpg"/></li>
                </ul>
            </div>
            </div>
    </body>
    <script>
                
slider = $('.bxslider').bxSlider();
slider.startAuto();
    </script>
</html>