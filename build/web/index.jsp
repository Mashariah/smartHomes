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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="scripts/jquery-1.11.3.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.bxslider.min.js" type="text/javascript"></script>
        <link href="style/jquery.bxslider.css" rel="stylesheet" type="text/css"/>
        <link href="style/core.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" href="style/nav-bar.css" rel="stylesheet"/>
        <link type="text/css" href="style/banner.css" rel="stylesheet"/>
        <title>| Smart Homes |</title>
   <script>
            $(document).ready(function() {
                $('.bxslider').bxSlider({
                    auto: true,
                    captions:true,
                    autoControls: true,
                    adaptiveHeight:false,
                    mode:'fade',
                    speed:2000
            });
        });
        </script>
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
                <form action="search" method="post">
                <span>Find Your Ideal Property</span>
                <select name="propertyType">
                        <option>For Sale</option>
                        <option>To Rent</option>
                    </select>
                    <input type="text" name="txtTarget" placeholder="Search Features, Town or price"/>
                    <input type="submit" name="searchBtn" value="Search"/>
                </form>
            </div>
            <ul class="bxslider">
<!--                <li><img  src="images/slider/image2.jpg" title="Farm for Sale" height="400px"></li>
                <li><img  src="images/slider/image3.jpg" height="400px"></li>
                <li><img  src="images/slider/image4.jpg" height="400px"></li>-->
                <li><img  src="images/slider/image5-s.jpg"></li>
                <li><img  src="images/slider/image6-s.jpg"></li>
                <li><img  src="images/slider/image7-s.jpg"></li>
                </div>
    </body>
</html>