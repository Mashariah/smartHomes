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
        <script src="scripts/jquery-1.11.3.min.js" type="text/javascript"></script>
        <link href="style/core.css" rel="stylesheet" type="text/css"/>
        <link type="text/css" href="style/nav-bar.css" rel="stylesheet"/>
        <link type="text/css" href="style/banner.css" rel="stylesheet"/>
        <link href="style/unslider.css" rel="stylesheet" type="text/css"/>
        <link href="style/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="style/jquery.timepicker.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/unslider-min.js" type="text/javascript"></script>
        <script src="scripts/simplegallery.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="scripts/jquery.timepicker.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('#img-gallery').simplegallery({
                    galltime: 400, // transition delay
                    gallcontent: '.content',
                    gallthumbnail: '.thumbnail',
                    gallthumb: '.thumb'
                });
            });
        </script>
    </head>
    <body>
        <style>
            .ui-datepicker {font-size: 9pt !important}
            .ui-timepicker-wrapper{font-size: 9pt;}
        </style>
        <div id="banner">
            <div id="logo"><img src="images/banners/logo3.png" width="100px" height="100px" alt="comp-logo"/></div>
        </div>
        <div class="content-body">
            <%@include file="menubar.jsp"%>
            <div id="register-login-bar">
                <a href="#">Login</a> | 
                <a href="#">Register</a>
            </div>

            <section class="simplegallery" id="img-gallery">
                <div class="content">
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=index.jpg" class="image_0"/>
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb1.jpg" class="image_1" style="display: none;" alt=""/>
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb1.jpg" class="image_2" style="display: none;" alt=""/>
                    <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb2.jpg" class="image_3" style="display: none;" alt=""/>
                </div>
                <div class="clear"></div>
                <div class="thumbnail">
                    <div class="thumb">
                        <a href="#" rel="0">
                            <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=index.jpg" id="thumb_1"></a>
                    </div>
                    <div class="thumb">
                        <a href="#" rel="1">
                            <img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb1.jpg" id="thumb_2"></a>
                    </div>
                    <div class="thumb last">
                        <a href="#" rel="2"><img src="imgsrv?dirName=${selectedProperty.imgDirLocation}&imageFile=thumb2.jpg" id="thumb_3"></a>
                    </div>
                </div>
            </section>
            <div class="details-desc">
                <table>
                    <tr><td id="head">${selectedProperty.header}</td></tr>
                    <!--<tr><td>Type: ${selectedProperty.propertyType}</td></tr>-->
                    <tr><td id="price-tag">Price: Ksh ${selectedProperty.priceFormatted}</td></tr>
                    <tr><td>${selectedProperty.description}</td></tr>
                    <tr><td id="head">Location Details</td></tr>
                    <tr><td><strong>County:</strong> ${selectedProperty.location.county}</td></tr>
                    <tr><td><strong>Division:</strong> ${selectedProperty.location.division}</td></tr>
                    <tr><td><strong>Town:</strong> ${selectedProperty.location.town}</td></tr>
                    <tr><td><strong>Road:</strong> ${selectedProperty.location.road}</td></tr>
                </table>

            </div>

            <div class="details-toolbar">
                <span>Book a visit to this property</span>
                <div id="email-board">
                    <form action="#" method="GET">
                        <input type="text" id="tx_fName" name="tx_fName" placeholder="First Name"/>
                        <input type="text" id="tx_lName" name="tx_lName" placeholder="Last Name"/>
                        <input type="tel" id="tx_phone" name="tx_phone" placeholder="Phone Number"/>
                        <input type="email" id="tx_emailAddr" name="tx_emailAddr" placeholder="Email Address"/>
                        <!--<textarea name="tx_message" placeholder="Message"></textarea>-->
                        <input type="text" id="tx_datePicker" name="tx_dateFrom" placeholder="Date"/></td>
                        <input type="text" id="tx_timePicker" name="tx_timeFrom" placeholder="Time"/></td>
            <input type="hidden" name="tx_propId" value="${selectedProperty.propertyId}"/></td>
            <input id="sendBtn" type="button" value="Make Booking" onclick="bookForVisit();"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $("#tx_datePicker").datepicker();
            $("#tx_timePicker").timepicker();
            console.log("done good");
        });
            </script>
            <script>
        function bookForVisit(){
            console.log("entered method...");
            var tx_fName = document.getElementById("tx_fName").value;
            var tx_lName= document.getElementById("tx_lName").value;
            var tx_phone = document.getElementById("tx_phone").value;
            var tx_emailAddr = document.getElementById("tx_emailAddr").value;
            
            //encode any special characters in the date values..
            var tx_datePicker = encodeURIComponent(document.getElementById("tx_datePicker").value);
            var tx_timePicker = encodeURIComponent(document.getElementById("tx_timePicker").value);
            
            //some logging...
                        console.log("fName =:"+tx_fName);
                        console.log("lName =:"+tx_lName);
                        console.log("phone =:"+tx_phone);
                        console.log("email =:"+tx_emailAddr);
                        
            var url = "messenger?tx_fName="+tx_fName+"&tx_lName="+tx_lName+"&tx_phone="+tx_phone+"&tx_emailAddr="+tx_emailAddr
            +"&tx_dateFrom="+tx_datePicker+"&tx_timeFrom="+tx_timePicker+"&tx_propId="+${selectedProperty.propertyId};
                        console.log("url =:"+url);
                //create XMLHTTP request object... for IE7+, Chrome, Firefox, Opera 
                if (window.XMLHttpRequest) {
                    xmlHttpRequest = new XMLHttpRequest();
                        console.log("created xmlhttprequest obj");
                }
                //.... for IE5 and IE6
                else {
                    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                }
               
               //at every state change of xhr...
                xmlHttpRequest.onreadystatechange = function() {
                //get the current state of the xhr object i.e. 0,1,2,3,4
                    if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                        var response = xmlHttpRequest.responseText; //server results as palin text
                        console.log("response="+response);
//                        var jsResponseObj = JSON.parse(response);
                        document.getElementById("email-board").innerHTML=
                                "<h5>"+response+"</h5>";
                    }
                };
//                xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                xmlHttpRequest.open("GET", url, true); //send using post to servlet charges
                xmlHttpRequest.send(null);                        
                        
            }
    </script>
    
</html>
