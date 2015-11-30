<%-- 
    Document   : NewProp
    Created on : 20-Nov-2015, 16:45:59
    Author     : Kelli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../style/admin_core.css" rel="stylesheet" type="text/css"/>
        <title>|SmartHomes - New Property|</title>
    </head>
    <body>
        <h1>New Property</h1>
        <form action="img_upload" method="post" enctype="multipart/form-data">
            <div class="frm-block">
                <label id="header">Owner's Details</label>
                <table>
                    <tr><td><label>First Name </label></td><td><input type="text" name="tx_fname" placeholder="First Name" required="true"/></td></tr>
                    <tr><td><label>Last Name</label> </td><td><input type="text" name="tx_lname" placeholder="Last Name" required="true"/></td></tr>
                    <tr><td><label>Email 1</label> </td><td><input type="email" name="tx_email1" placeholder="Email 1" required="true"/></td></tr>
                    <tr><td><label>Email 2</label> </td><td><input type="email" name="tx_email2" placeholder="Email 2" /></td></tr>
                    <tr><td><label>Phone 1 </label></td><td><input type="tel" name="tx_phone1" placeholder="Phone Number 1" required="true"/></td></tr>
                    <tr><td><label>Phone 2 </label></td><td><input type="tel" name="tx_phone2" placeholder="Phone Number 2"/></td></tr>
                </table>
            </div>
            <div class="frm-block">
                <label id="header">Property Type & Location</label>
                <table>
                    <tr><td><label>Type</label></td><td><select name="s_proptype"/>>
                    <option>APARTMENT</option>
                    <option>BUNGALOW</option>
                    <option>MANSIONETTE</option>
                    <option>STUDIO</option>
                    <option>UNDEVELOPED LAND</option>
                    </select></td></tr><tr>
                        <td><label>Intent</label> </td><td><select name="s_propintent"/>>
                    <option>SALE</option>
                    <option>RENT-OUT</option>
                    <option>LEASE</option>
                    </select></td></tr>
                    <tr><td><label>County</label> </td><td><select name="s_county"/>>
                    <option>KIAMBU</option>
                    <option>NAIROBI</option>
                    <option>LAIKIPIA</option>
                    <option>NYANDARUA</option>
                    <option>KILIFI</option>
                    <option>MAKUENI</option>
                    <option>SIAYA</option>
                    <option>WAJIR</option>
                    </select></td></tr>
                    <tr><td><label>Division</label> </td><td><input type="text" name="tx_division" placeholder="Division"/></td></tr>
                    <tr><td><label>Town</label></td><td><input type="tel" name="tx_town" placeholder="Nearest Town"/></td></tr>
                    <tr><td><label>Road </label></td><td><input type="tel" name="tx_road" placeholder="Road"/></td></tr>
                    <!--<tr><td><label>Plot Number </label></td><td><input type="tel" name="tx_phone2" placeholder="Phone Number 2"/></td></tr>-->

                </table>
            </div>
            <div class="frm-block">
                <label id="header">Images & Price</label><br>
                <table>
                        <input type="file" name="img1Upload" required="true" /> 
                        <br>
                        <input type="file" required="true"/>
                        <br>
                        <input type="file"/>
                        <br>
                        <input type="file"/>
                        <br>
                        <input type="file"/><br>
                </table>
            </div>
            <div class="frm-block-txarea">
                <label id="header">Property Description</label>
                <input id="desc-header" type="text" name="tx_header" placeholder="Header"/>                
                    <label>Price</label> </td><td><input type="text" name="tx_price" placeholder="Price"/>
                <textarea name="tx_description" placeholder="Describe the property in detail"></textarea>
                <br>
                <input id="desc-header" type="text" name="tx_keywords" placeholder="Keywords"/>
                <input type="submit" value="Create Property" id="upload-block">
            </div>  
        </form>
    </body>
</html>
