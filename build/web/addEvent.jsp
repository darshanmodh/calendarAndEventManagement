<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title> addEvent Page </title>
        <base href="/project1/"/>
        <link rel="stylesheet" type="text/css" href="css/addEvent.css">
    </head>

    <body>
        <form class="e1" method="post" action="event" name="myform">
            <input type="hidden" name="eventDate" value="${eventDate}"/>

            <input type="text" name="eventDesc"/>

            <table border="0" width="100%" >
                <tr><td width="35%"> </td><td>
                        <input type="submit" name="cmd" id="submit" value="Add Event"/>
                    </td> <td></td></tr>
            </table>

            <p>
            <h1>
                <a href="welcome.jsp" style="text-decoration: none; padding: 10px; font-family: cursive">Back To Calendar</a>
            </h1>
            </p>

            <p>
            <h2>${msg}</h2>
        </p>
    </form>
</body>
</html>
<%
try{
String date = request.getAttribute("eventDate").toString();
}catch(Exception ex){
    request.setAttribute("msg2", "First select any date.");
    request.getRequestDispatcher("/error.jsp").forward(request, response);
}
%>