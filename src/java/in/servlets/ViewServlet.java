package in.servlets;

import in.hibernate.MyHb;
import in.hibernate.Reg;
import in.hibernate.UserEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "ViewServlet", urlPatterns = {"/view"})
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");

        if (day == null || month == null || year == null) {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }

        String strDate = day + "-" + month + "-" + year;

        request.setAttribute("eventDate", strDate);

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

        java.util.Date eventDate = MyHb.toDate(strDate);
        System.out.println("Event date " + eventDate);
        Reg reg = new Reg();
        reg.setUname(username);

        Session sess = MyHb.getSessionFactory().openSession();
        Transaction tran = sess.beginTransaction();

        List<UserEvent> events = sess.createCriteria(UserEvent.class).add(Restrictions.eq("reg", reg)).add(Restrictions.eq("eventdate", eventDate)).list();

        request.setAttribute("events", events);

        request.getRequestDispatcher("/viewEvent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
