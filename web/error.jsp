<%-- 
    Document   : ViewEvent
    Created on : Apr 4, 2013, 9:25:37 PM
    Author     : Darshan
--%>
<jsp:include page="header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Refresh" content="5;url=welcome.jsp">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Error Page</title>
    </head>

    <body>
        <h1>${msg1}
            ${msg2}
        </h1>
        <img src="css/images/rotating_globe.gif">
    </body>
</html>
<jsp:include page="footer.jsp" />
