/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import in.hibernate.MyHb;
import in.hibernate.Reg;
import in.hibernate.UserEvent;
import java.io.IOException;
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

/**
 *
 * @author Darshan
 */
@WebServlet(name = "Welcome1", urlPatterns = {"/wel"})
public class Welcome1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
         Reg reg = new Reg();
        reg.setUname(username);

        Session sess = MyHb.getSessionFactory().openSession();
        Transaction tran = sess.beginTransaction();

        List<UserEvent> events = sess.createCriteria(UserEvent.class).add(Restrictions.eq("reg", reg)).list();

        request.setAttribute("events", events);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
}
