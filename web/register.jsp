<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" type="text/css" href="css/reg1.css" />
        <link rel="stylesheet" href="css/jquery-ui-1.10.2.custom.css" /> 
        <link rel="stylesheet" href="css/pwd_strength.css" type="text/css"/>

        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="js/jquery.pwstrength.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>

        <script type="text/javascript">
            jQuery(function($) { $('#pass').pwstrength(); });
            
        function refreshIt(){
            
            console.log($("#cpass").val());
            $("#capId").attr("src","captcha?text=" + rndText());
        }
    
        function rndText()
        {
            str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
            rndStr = new String();
        
            for(i=1;i<=5;i++){
                var m = Math.ceil(Math.random()* (str.length-1));
                rndStr += str[m];            
            }
            return rndStr;
        }
            
function msg(p1)
{
    if(p1=="OK")
        alert(p1);
    else
        alert(p1);
}
$("#capId").attr("src","captcha?text=" + rndText());
        </script>
        <script>
$(document).ready(function() {
    $( "#datepicker" ).datepicker();
    $( "#datepicker" ).datepicker( "option", "showAnim", "slideDown" );
});
             
function check1(p1,p2)
{
    if (p1.value != p2.value || p1.value == '' || p2.value == '') {
        p2.setCustomValidity('Password Incorrect');
    } else {
        p2.setCustomValidity('');
    }
}
        </script>

    </head>
    <body onload="refreshIt()" onfocus="check1(pass, cpass)">
     
        <form id="register" name="myform" method="post" action="register">
            <h1 id="h1reg">Registration</h1>
            <fieldset id="inputsreg">
                <input name="fname" id="fname" type="text" placeholder="First Name" autofocus required >   
                <input name="lname" id="lname" type="text" placeholder="Last Name" required>
                <input name="uname" id="uname" type="text" placeholder="Username" required>   
                <input type="password" class="password" name="pass" id="pass" placeholder="Password" data-indicator="pwindicator" required/>
                <div id="pwindicator">
                    <div class="bar" align="right"></div><br>
                    <div class="label" align="right"></div>
                </div>

                <input type="password" class="password" name="cpass" id="cpass"  placeholder="Confirm Password" required />
                <input name="email" id="email" type="email" placeholder="Email ID" required > 
                <input name="bday" id="datepicker" type="text" placeholder="Birthday (MM/DD/YYYY)" pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d" required> 
            </fieldset>
            <fieldset>
                <table>
                    <tr>
                        <th>
                            <img draggable="false" id="capId" src="captcha?text=" />
                        </th>
                        <th>
                            <a href="#" onclick="refreshIt()" style="text-decoration: none">Refresh</a>
                        </th>
                        <td>
                            <input type="text" name="txtInput" size="15" id="txtInput" placeholder="Enter code here" />    
                        </td>
                        <td><label style="text-decoration: blink; color: red" />${msg}</td>
                    </tr>
                </table>
            </fieldset>

            <fieldset id="actions">
                <table border="0" width="100%">
                    <tr><td width="80%">
                            <input type="submit" id="submit" value="Register" name="submit" /></td>
                        <td><input type="reset" id="reset" value="Reset" name="reset" /></td>
                        <td><a href="login.jsp"> Login </a></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>