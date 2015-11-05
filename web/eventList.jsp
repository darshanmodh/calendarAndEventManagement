<%-- 
    Document   : eventList
    Created on : Apr 20, 2013, 5:49:09 PM
    Author     : Darshan
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/calendar1.css">
        <title>Event List</title>
    </head>
    <body> 
        <h2 class="w1">Welcome ${cookie.fname.value} ${cookie.lname.value}</h2>
    <center>
        <table border="0">
            <tr><th>Date</th><th>Event</th></tr>
            <ul style="list-style-image:url('css/images/arrow.png');">
                <ul style="list-style-image:url('css/images/arrow.png');">
        <c:forEach var="event" items="${events}">
            <tr><td style="font-size: larger">
            <fmt:formatDate value="${event.eventdate}"/></td><td style="font-size: large"> <ul style="list-style-image:url('css/images/arrow.png');"><li>
                            ${event.eventdesc}</li></td></tr>
            </c:forEach>
            </ul>
        </table>
    </center>
    </body>
</html>
<jsp:include page="footer.jsp" />
