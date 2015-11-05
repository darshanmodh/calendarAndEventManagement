/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import in.hibernate.MyHb;
import in.hibernate.Reg;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import java.lang.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Darshan
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class ProfileServlet extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/project";
    private String dbUser = "darshan";
    private String dbPass = "darshan";

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
                request.setAttribute("uname", username);
                request.setAttribute("fname", reg.getFname());
                request.setAttribute("lname", reg.getLname());
                request.setAttribute("email", reg.getEmail());
                request.setAttribute("bday", reg.getBday());
            }
        } catch (Exception e) {
        }
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String bday = request.getParameter("bday");

        if (uname.equals("") || uname.equals(null)) {
            request.setAttribute("msg2", "Invalid Request.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
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

        InputStream inputStream = null;

        Part filePart = request.getPart("photo");
        String ct = filePart.getHeader("content-type");
        if ((ct.equals("image/jpeg") || ct.equals("image/png") || ct.equals("image/gif")) && (filePart.getSize() >= 1 && filePart.getSize() <= 1024 * 1024 * 3)) {
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }

            Connection conn = null;
            String message = null;

            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                String sql = "INSERT INTO contact (uname,photo) values (?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, uname);

                if (inputStream != null) {
                    statement.setBlob(2, inputStream);
                }

                int row = statement.executeUpdate();
                if (row > 0) {
                    message = "Your pic is successfully uploaded.";
                }
            } catch (Exception e) {
                message = "ERROR in uploading pic. ";
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Exception e) {
                    }
                }
                request.setAttribute("msg2", message);
            }
        } else {
            request.setAttribute("msg1", "Unsupported File.");
        }

        //Database to File System
        FileOutputStream image;
        Connection con = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet res = null;
        StringBuffer q = null;
        String driverName = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL,dbUser,dbPass);
            String sql = "select photo from contact where uname=? ORDER BY c_id DESC";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            res = ps.executeQuery();
            if(res.next())
            {
                Blob test = res.getBlob("photo");
                InputStream x = test.getBinaryStream();
                int size = x.available();
                OutputStream out = new FileOutputStream("C:\\Users\\Darshan\\Documents\\NetBeansProjects\\project1\\build\\web\\css\\images\\"+username+".jpg");
                //OutputStream out = new FileOutputStream("C:\\Users\\Darshan\\Documents\\NetBeansProjects\\project1\\web\\css\\images\\"+username+".jpg");
                byte b[] = new byte[size];
                x.read(b);
                out.write(b);
            }
        } catch (Exception e) {
        }finally{
            try {
                st.close();
                con.close();
            } catch (Exception e) {
            }
        }

        Session sess1 = MyHb.getSessionFactory().openSession();
        Transaction trans = sess1.beginTransaction();
        Query query = sess1.createQuery("from Reg where uname=:m1");
        query.setParameter("m1", username);
        List list = query.list();

        if (list.size() != 0) {
            Reg reg = (Reg) list.get(0);
            reg.setUname(uname);
            reg.setFname(fname);
            reg.setLname(lname);
            reg.setEmail(email);
            reg.setBday(bday);
            sess1.update(reg);
            trans.commit();
            request.setAttribute("msg", "Record updated successfully.");
        } else {
            request.setAttribute("msg1", "Record Not Updated");
        }
        request.getRequestDispatcher("/picture.jsp").forward(request, response);
    }
}
