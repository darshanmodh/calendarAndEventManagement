<%-- 
    Document   : login
    Created on : Mar 28, 2013, 12:12:38 AM
    Author     : Darshan Modh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <base href="/project1/"/>
        <link rel="stylesheet" type="text/css" href="css/login_style.css">
    </head>

    <body>
        <form id="login" name="loginForm" method="post" action="signin">
            <h1>Log In</h1>
            <fieldset id="inputs">
                <input name="uname" id="username" type="text" placeholder="Username" autofocus required>   
                <input name="pass" id="password" type="password" placeholder="Password" required>
            </fieldset>
            <fieldset id="check">
                <input type="checkbox" id="remember" name="remember" value="remember">Remember Me
                <label style="text-decoration: blink; color: red"/>  ${msg}
            </fieldset>
            <fieldset id="actions">
                <input type="submit" id="submit" value="Log in">
                <a href="recover.jsp">Forgot your password?</a><a href="register.jsp">Register</a>
            </fieldset>
        </form>
    </body>
</html>
