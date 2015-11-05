<%-- 
    Document   : files
    Created on : Apr 19, 2013, 11:02:12 PM
    Author     : Darshan
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/calendar1.css"/>
        <title>My File List</title>
        <link rel="stylesheet" href="css/jquery-ui-1.10.2.custom.css" />
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery-ui.js"></script>
        <style>
            label {
                display: inline-block;
                width: 5em;
            }
        </style>
        <script>
            $(function() {
                $( document ).tooltip({
                    track: true
                });
            });
        </script>
    </head>
    <body>
        <h2 class="w1">Welcome ${cookie.fname.value} ${cookie.lname.value}</h2>
    <center><h1 style="font-family: cursive;">My File List</h1>
        <table border="2" style=" border-top-style:dotted;
                border-right-style:solid;
                border-bottom-style:dotted;
                border-left-style:solid;">
            <tr><th>File Name</th><th>Size</th></tr>
            <%
                String sourceDirectory = "C:\\Users\\Darshan\\Documents\\NetBeansProjects\\project1\\build\\web\\files\\";
                File f = new File(sourceDirectory);
                String[] fileNames = f.list();
                File[] fileObjects = f.listFiles();
                String username = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("user")) {
                            username = c.getValue();
                            break;
                        }
                    }
                }
                for (int i = 0; i < fileObjects.length; i++) {
                    if (!fileObjects[i].isDirectory()) {
                        try {
                            String[] ar = fileNames[i].split("@");
                            if (ar[0].equals(username)) {
            %>
            <tr height="40px"><td>
                    <a title="Click here to download this file" href="download?file=<%=fileNames[i]%>" style="text-decoration: none; font-size:larger"><%= ar[1]%></a>
                </td>
                <td><%= Long.toString(fileObjects[i].length() / 1024)%> KB
                </td></tr>
                <%
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                %>
        </table>
        <font face="cursive" size="5"><b><a title="Click here to Upload your files." href="myFiles.jsp" style="text-decoration: none; font-size: larger">Upload File</a></b></font></center>
</body>
</html>
<jsp:include page="footer.jsp" />
