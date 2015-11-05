<%-- 
    Document   : myFiles
    Created on : Apr 19, 2013, 6:48:55 PM
    Author     : Darshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/files.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <form method="post" action="upload" enctype="multipart/form-data" id="register" name="myform">
            <h1 class="uf"> Upload File </h1>
            <table border="0">
                <tr>
                    <td width="60%">File:</td> <td><input type="file" name="file"></td></tr>
                <tr><td>Description:</td> <td><input type="text" name="desc"></td></tr>
                <tr height="30px"><td colspan="2"><label style="color: red" />${msg}<label style="color: darkgreen" />${msg1}</td></tr>
                <tr><td></td><td><input type="submit" name="submit" id="submit" value="Upload"></td></tr>
                <tr><td></td><td style="text-align: right;"><a style="text-decoration: none; padding: 10px" href="files.jsp">Back</a>                                       <a style="text-decoration: none; padding: 10px" href="welcome.jsp">Home</a></td></tr>
            </table>
        </form>
    </body>
</html>
