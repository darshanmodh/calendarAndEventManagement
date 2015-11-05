package in.servlets;

import in.hibernate.MyHb;
import in.hibernate.Reg;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "LoginSerlvet", urlPatterns = {"/signin"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    c.setMaxAge(0);
                    c.setPath("/project1/");
                    response.addCookie(c);
                }
            }
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Session sess = MyHb.getSessionFactory().openSession();
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");

        List<Reg> regs = sess.createCriteria(Reg.class).add(Restrictions.eq("uname", uname)).add(Restrictions.eq("pass", pass)).list();
        if (!regs.isEmpty()) {

            FileOutputStream image;
            Connection con = null;
            PreparedStatement ps = null;
            Statement st = null;
            ResultSet rs = null;
            StringBuffer query = null;
            String driverName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306";
            String dbName = "project";
            String dbUser = "darshan";
            String dbPass = "darshan";

            Reg reg = regs.get(0);
            System.out.println("Found" + reg);

            Cookie c1 = new Cookie("user", reg.getUname());
            Cookie c2 = new Cookie("fname", reg.getFname());
            Cookie c3 = new Cookie("lname", reg.getLname());
            c1.setPath("/project1/");
            c2.setPath("/project1/");
            c3.setPath("/project1/");
            if (remember != null) {
                c1.setMaxAge(60 * 60);
                c2.setMaxAge(60 * 60);
                c3.setMaxAge(60 * 60);
            }
            response.addCookie(c1);
            response.addCookie(c2);
            response.addCookie(c3);

            response.sendRedirect("welcome.jsp");
            return;
        } else {
            System.out.println("Not Found");
            request.setAttribute("msg", "Invalid username or password.");
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
