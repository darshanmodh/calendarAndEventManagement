/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import in.hibernate.MyHb;
import in.hibernate.Reg;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Darshan
 */
@WebServlet(name = "aboutServlet", urlPatterns = {"/about"})
public class aboutServlet extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/project";
    private String dbUser = "root";
    private String dbPass = "";

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
        try {
            Session sess = MyHb.getSessionFactory().openSession();
            Query query = sess.createQuery("from Reg where uname=:m1");
            query.setParameter("m1", username);
            List list = query.list();
            for (Object obj : list) {
                Reg reg = (Reg) obj;
                request.setAttribute("fname", reg.getFname());
                request.setAttribute("lname", reg.getLname());
                request.setAttribute("email", reg.getEmail());
            }
        } catch (Exception e) {
        }
        request.getRequestDispatcher("/about.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

        Session sess = MyHb.getSessionFactory().openSession();
        String email = "darshan.project123@gmail.com";
        String name = request.getParameter("name");
        String subject = "Feedback";
        String message = request.getParameter("message");

        List<Reg> list = sess.createCriteria(in.hibernate.Reg.class).add(Restrictions.eq("uname", username)).list();

        if (!list.isEmpty()) {
            Reg reg = list.get(0);

            String body = "\nDear Admin,\n";
            body += username + " wants to give feedback on your site.\n=============================";
            body += "\n\n"+message+ "\n\n\nThanking You,";
            body += "\n"+name;
            try {
                Properties props = new Properties();

                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", 587);
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.ssl.enable", "yes");
                props.put("mail.smtp.ssl.trust", "*");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.ssl.socketFactory", "javax.net.ssl.SSLSocketFactory");

                MyAuth auth = new MyAuth();
                javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, auth);
                MimeMessage msg = new MimeMessage(session);

                msg.setFrom(new InternetAddress("darshan.project123@gmail.com"));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                msg.setSubject(subject);

                msg.setText(body);
                Transport.send(msg);
                request.setAttribute("msg", "Mail Sent Successfully on your registered E-mail ID.");
                request.getRequestDispatcher("/picture.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("msg1", "Mail cannot be sent.");
            }
        } else {
            request.setAttribute("msg1", "Given Information is Wrong.");
        }
        request.getRequestDispatcher("/picture.jsp").forward(request, response);
    }
}
