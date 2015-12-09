<%-- 
    Document   : admin_list_properties
    Created on : Dec 9, 2015, 10:23:31 AM
    Author     : Kelli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SmartHomes - Properties</title>
        <link href="style/admin_core.css" rel="stylesheet" type="text/css"/>
        <script>
        function countWords(phrase){
            var limitedPhrase;
            var total = phrase.match(/(\w+)/g).length;
            console.log('Total words: '+total);
            limitedPhrase = phrase.substring(0,300);
            console.log(limitedPhrase);
            return limitedPhrase;
        }
        </script>
    </head>
    <body>
        <!--<div id="scontent">-->
        <%@include  file="admin_dashboard.jsp"%>
        <table>
            <thead></thead>
            <tbody>
            <c:forEach var="current" items="${listing}">
                <tr>
                    <td>
                        <div class="property-item">
                        <input type="checkbox">
                            <div class="property-thumbnail">
                                <img src="imgsrv?dirName=${current.imgDirLocation}&imageFile=index.jpg" width="110px" height="65px"/>
                            </div>
                            <div class="property-item-header">${current.header}</div>,
                            <span class="property-item-pricetag">${current.priceFormatted}</span>
                            <span class="property-item-text">${current.description}</span>
                            <!--<a href="details?propId=${current.propertyId}" class="plist-item-btndetails">View Details</a>-->
                            <script>countWords('${current.description}');</script>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <!--</div>-->
</body>
</html>
