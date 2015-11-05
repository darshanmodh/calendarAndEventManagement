<%-- 
    Document   : picture
    Created on : Apr 22, 2013, 12:56:21 AM
    Author     : Darshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Picture</title>
    </head>
    <body>
        <ul type="square">
            <li>For changes, please Login again.</li><br><br>
            <label style="color: darkgreen">${msg}</label><br><br>
            <label style="color: darkgreen">${msg2}</label><label style="color: red">${msg1}</label><br>
        </ul>
        <input type="button" value="Back" onclick="window.location.href='welcome.jsp'" style="font-size: xx-large; background-color: #838383">
    </body>
</html>
<jsp:include page="footer.jsp" />