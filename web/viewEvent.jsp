<%
    try {
        String date = request.getAttribute("eventDate").toString();
    } catch (Exception ex) {
        request.setAttribute("msg2", "First select any date.");
        request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String day = request.getParameter("day");
    String month = request.getParameter("month");
    String year = request.getParameter("year");
    String strDate = day + "-" + month + "-" + year;
    request.setAttribute("eventDate", strDate);
%>
<html>
    <head>
        <title> View Event </title>
        <base href="/project1/"/>
        <link rel="stylesheet" type="text/css" href="css/login_style.css">
    </head>

    <body link="black" alink="black" vlink="black">
        <form class="e1" method="post" action=""   id="login" name="loginForm">
            <h1> Events </h1>
            <input type="hidden" name="eventDate" value="${eventDate}"/>

            <p>
            <h2>${msg}</h2>
        </p>
        <c:forEach var="event" items="${events}">
            <p id="list">  <fmt:formatDate value="${event.eventdate}"/>
                ${event.eventdesc}</p>
            </c:forEach>
        <center>
            <font face="cursive" size="6"><a href="welcome.jsp" style="text-decoration: none">Back</a>
            <br>
            <a href="event?day=<%=day%>&month=<%=month%>&year=<%=year%>" style="text-decoration: none">Add Event</a>
            </font>
        </center>
    </form>
</body>
</html>
