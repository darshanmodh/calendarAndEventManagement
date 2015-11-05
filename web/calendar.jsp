<%@ page  language="java" import="java.util.*,java.text.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    public int nullIntconv(String inv) {
        int conv = 0;

        try {
            conv = Integer.parseInt(inv);
        } catch (Exception e) {
        }
        return conv;
    }
%>
<%
    int iYear = nullIntconv(request.getParameter("iYear"));
    int iMonth = nullIntconv(request.getParameter("iMonth"));

    Calendar ca = new GregorianCalendar();
    int iTDay = ca.get(Calendar.DATE);
    int iTYear = ca.get(Calendar.YEAR);
    int iTMonth = ca.get(Calendar.MONTH);

    if (iYear == 0) {
        iYear = iTYear;
        iMonth = iTMonth;
    }

    GregorianCalendar cal = new GregorianCalendar(iYear, iMonth, 1);

    int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weekStartDay = cal.get(Calendar.DAY_OF_WEEK);

    cal = new GregorianCalendar(iYear, iMonth, days);
    int iTotalweeks = cal.get(Calendar.WEEK_OF_MONTH);

    if (iMonth == iTMonth && iYear == iTYear) {%>
<style>
    #day_<%=iTDay%>
    {
        border-color: red;
        border-style: double;
        border-width: thick;
    }
</style>
<%}
%>
<html>
    <head>
        <title>Calendar Page</title>
        <base href="/project1/"/>
        <link rel="stylesheet" type="text/css" href="css/calendar1.css">

        <title>Calendar</title>
        <script>
            function big(x)
            {
                x.style.backgroundColor = "#D0DCEB";
                //x.style.height="50";
                x.style.width="100%";
                x.style.color="red";
            }

            function normal(x)
            {
                x.style.backgroundColor = "#B0C4DE";
                //x.style.height="35";
                x.style.width="14.28%";
                x.style.color="black";
                
            }
            function goTo()
            {
                document.frm.submit()
            }
        </script>
    </head>

    <body>
        <form name="frm" method="post">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr class="t1">
                                <td width="6%">Year</td>
                                <td width="7%">
                                    <select name="iYear" onchange="goTo()">
                                        <%
                                            // start year and end year in combo box to change year in calendar
                                            for (int iy = iTYear - 70; iy <= iTYear + 70; iy++) {
                                                if (iy == iYear) {
                                        %>
                                        <option value="<%=iy%>" selected="selected"><%=iy%></option>
                                        <%
                                        } else {
                                        %>
                                        <option value="<%=iy%>"><%=iy%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select></td>
                                <td width="73%" align="center"><h3><%=new SimpleDateFormat("MMMM").format(new Date(2008, iMonth, 01))%> <%=iYear%></h3></td>
                                <td width="6%">Month</td>
                                <td  width="8%">
                                    <select name="iMonth" onchange="goTo()">
                                        <%
                                            // print month in combo box to change month in calendar
                                            for (int im = 0; im <= 11; im++) {
                                                if (im == iMonth) {
                                        %>
                                        <option value="<%=im%>" selected="selected"><%=new SimpleDateFormat("MMMM").format(new Date(2008, im, 01))%></option>
                                        <%
                                        } else {
                                        %>
                                        <option value="<%=im%>"><%=new SimpleDateFormat("MMMM").format(new Date(2008, im, 01))%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select></td>
                            </tr>
                        </table></td>
                </tr>
                <tr>
                    <td><table align="center" border="1" cellpadding="3" cellspacing="0" width="100%">
                            <tbody>
                                <tr class="d1">
                                    <th>Sun</th>
                                    <th>Mon</th>
                                    <th>Tue</th>
                                    <th>Wed</th>
                                    <th>Thu</th>
                                    <th>Fri</th>
                                    <th>Sat</th>
                                </tr>
                                <%
                                    int cnt = 1;
                                    for (int i = 1; i <= iTotalweeks; i++) {
                                %>
                                <tr class="d2" height="100">
                                    <%
                                        for (int j = 1; j <= 7; j++) {
                                            if (cnt < weekStartDay || (cnt - weekStartDay + 1) > days) {
                                    %>
                                    <td  align="center" height="35" width="14.28%">&nbsp;</td>
                                    <%               } else {
                                    %>
                                    <td align="center" height="35" width="14.28%" id="day_<%=(cnt - weekStartDay + 1)%>" >
                                        <a class="a1" style="text-decoration: none" href="view?day=<%=(cnt - weekStartDay + 1)%>&month=<%=new SimpleDateFormat("MMMM").format(new Date(2008, iMonth, 01))%>&year=<%=iYear%>">
                                            <div class="l1" onmouseover="big(this)" onmouseout="normal(this)"><%=(cnt - weekStartDay + 1)%></div>
                                        </a>
                                    </td>
                                    <%
                                            }
                                            cnt++;
                                        }
                                    %>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table></td>
                </tr>
            </table>
        </form>
</body>
</html>
