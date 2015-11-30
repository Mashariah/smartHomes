<%-- 
    Document   : testpage
    Created on : Nov 28, 2015, 2:45:29 PM
    Author     : Kelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Slider Test Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="scripts/jquery-1.11.3.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.bxslider.min.js" type="text/javascript"></script>
        <link href="style/jquery.bxslider.css" rel="stylesheet" type="text/css"/>
        <link href="style/core.css" rel="stylesheet" type="text/css"/>
        <script>
            $(document).ready(function() {
                $('.bxslider').bxSlider({
                    auto: true,
                    captions:true,
                    autoControls: true
            });
        });
        </script>
    </head>
    <body>
        <div id="slider-content">
            <ul class="bxslider">
                <li><img src="images/test-images/image1.jpg"></li>
                <li><img src="images/test-images/karen1.jpg"></li>
                <li><img src="images/test-images/karen2.jpg"></li>
            </ul>
        </div>
    </body>
</html>
