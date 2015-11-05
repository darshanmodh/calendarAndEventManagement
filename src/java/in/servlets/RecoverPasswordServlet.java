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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Darshan
 */
@WebServlet(name = "RecoverPasswordServlet", urlPatterns = {"/recover"})
public class RecoverPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/recover.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session sess = MyHb.getSessionFactory().openSession();
        String uname = request.getParameter("uname");
        String bday = request.getParameter("bday");
        String email = "";
        String pass = "";
        String subject = "Your Password";

        List<Reg> list = sess.createCriteria(in.hibernate.Reg.class).add(Restrictions.eq("uname", uname)).list();
               
        if(!list.isEmpty()){
            Reg reg = list.get(0);
            if (reg.getBday().equals(bday)) {
                email = reg.getEmail();
                pass = reg.getPass();
                String body = "\nDear ";
                body += reg.getFname()
                        + "\n\n Your Password is : " + pass
                        + "\n\n\n\nThanking You, \nProject Team";
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
                    request.getRequestDispatcher("/recover.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("msg", "Mail cannot be sent.");
                    
                }
            } else {
                request.setAttribute("msg", "Given Information is Wrong.");
            }
        }else
        {
            request.setAttribute("msg", "Given Information is Wrong.");
        }
        request.getRequestDispatcher("/recover.jsp").forward(request, response);
    }
}
