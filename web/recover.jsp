<%-- 
    Document   : recover
    Created on : Mar 31, 2013, 4:39:54 PM
    Author     : Darshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Recover Password</title>
        <link rel="stylesheet" type="text/css" href="css/recover.css" />
        <link rel="stylesheet" href="css/jquery-ui-1.10.2.custom.css" /> 

        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script>
            $(document).ready(function() {
                $( "#datepicker" ).datepicker();
                $( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );
            });
        </script>
    </head>

    <body>
        <form id="register" name="myform" method="post" action="recover">
            <h1 id="h1reg">Forgot Password</h1>
            <fieldset id="inputsreg">   
                <input name="uname" id="uname" type="text" placeholder="Username" autofocus required>   
                <input name="bday" id="datepicker" type="text" placeholder="Birthday (MM/DD/YYYY)" required> 
                <label style="text-decoration: blink; color: red" />${msg}
            </fieldset>
            <fieldset id="actions">
                <table width="100%">
                    <tr><td width="35%"></td><td>
                            <input type="submit" id="submit" value="Get Password" name="recover" /><br><br>
                            <a href="login.jsp">Login</a><a href="register.jsp">Register</a>
                        </td></tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
