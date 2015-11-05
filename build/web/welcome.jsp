<%-- 
    Document   : welcome
    Created on : Mar 28, 2013, 12:39:11 AM
    Author     : Darshan Modh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>

<html>
       <head>
        <title>Calendar Page</title>
        <link rel="stylesheet" type="text/css" href="css/calendar1.css">
       </head>
    <body>
        <br>
        <img width="70px" height="70px" border="0" src="css/images/${cookie.user.value}.jpg" /> 
        <label style="font-family: cursive; font-size: xx-large"><b>Welcome ${cookie.fname.value} ${cookie.lname.value}</b></label>
        <%@include file="calendar.jsp" %>
    </body>
</html>
<jsp:include page="footer.jsp" />