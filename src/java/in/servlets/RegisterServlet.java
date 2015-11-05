package in.servlets;

import in.hibernate.MyHb;
import in.hibernate.Reg;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        String email = request.getParameter("email");
        String bday = request.getParameter("bday");
        String txtInput = request.getParameter("txtInput");

        HttpSession session = request.getSession();

        String captcha = (String) session.getAttribute("captcha");

        if (txtInput.equals(captcha) && pass.equals(cpass)) {
            //request.setAttribute("msg", "OK");
            Session sess = MyHb.getSessionFactory().openSession();
            Transaction trans = sess.beginTransaction();

            List<Reg> list = sess.createCriteria(Reg.class).add(Restrictions.eq("uname", uname)).list();

            if (list.isEmpty()) {

                Reg reg = new Reg();
                reg.setFname(fname);
                reg.setLname(lname);
                reg.setUname(uname);
                reg.setPass(pass);
                reg.setCpass(cpass);
                reg.setEmail(email);
                reg.setBday(bday);
                sess.persist(reg);
                trans.commit();
            } else {
                request.setAttribute("msg", "Username is not available.");
            }
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Register Unsuccessful");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
