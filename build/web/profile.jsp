<%-- 
    Document   : profile
    Created on : Apr 20, 2013, 7:07:24 PM
    Author     : Darshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/jquery-ui-1.10.2.custom.css" /> 
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <title>Profile</title>
        <script>
            $(document).ready(function() {
                $( "#datepicker" ).datepicker();
                $( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );
            });

            $(document).ready(function() {
                $('input:text').focus(
                function(){
                    $(this).css({'background-color' : '#FFFFEEE'});
                });
                $('input:text').blur(
                function(){
                    $(this).css({'background-color' : '#DFD8D1'});
                });
            });
        </script>
    </head>
    <body>
        <h2 class="w1">Welcome ${cookie.fname.value} ${cookie.lname.value}</h2>
    <center>
        <form action="profile" method="post" enctype="multipart/form-data">
            <table border="0" width="60%" cellspacing="15" cellpadding="5">
                <tr><td style="font-size: xx-large">Username: </td>
                    <td style="font-size: xx-large"><input name="uname" type="text" readonly value="${uname}" style="background: transparent; font-size: xx-large"></td></tr>
                <tr><td style="font-size: xx-large">First Name: </td>
                    <td style="font-size: xx-large"><input name="fname" style="font-size: xx-large" type="text" value="${fname}" required onfocus="color(this);"></td></tr>
                <tr><td style="font-size: xx-large">Last Name: </td>
                    <td style="font-size: xx-large"><input name="lname" style="font-size: xx-large" type="text" value="${lname}" required></td></tr>
                <tr><td style="font-size: xx-large">Email: </td>
                    <td style="font-size: xx-large"><input name="email" style="font-size: xx-large" type="email" value="${email}" required></td></tr>
                <tr><td style="font-size: xx-large">Birthday: </td>
                    <td style="font-size: xx-large"><input name="bday" style="font-size: xx-large" id="datepicker" type="text" value="${bday}" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d" required></td></tr>
                <tr><td style="font-size: xx-large">Photo: </td>
                    <td style="font-size: xx-large"><input size="25" name="photo" style="font-size: xx-large" name="photo" type="file"></td></tr>
                <tr><td style="font-size: xx-large">Your Current Photo: </td>
                    <td style="font-size: xx-large"><img width="70px" height="70px" border="0" src="css/images/${cookie.user.value}.jpg" /> </td></tr>
                <tr><td style="font-size: xx-large"></td>
                    <td style="font-size: xx-large"><input type="submit" value="Update" style="font-size: xx-large; background-color: #838383"> &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="button" value="Back" onclick="window.location.href='welcome.jsp'" style="font-size: xx-large; background-color: #838383"></td></tr>
                <tr><td colspan="2"><label style="color: darkgreen" />${msg}<label style="color: darkgreen" />${msg2}<label style="color: red" />${msg1}</td></tr>
            </table>
        </form>
    </center>
</body>
</html>
<jsp:include page="footer.jsp" />
