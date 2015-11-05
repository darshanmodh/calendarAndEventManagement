/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Darshan
 */
@WebServlet(name = "ChangePictureServlet", urlPatterns = {"/picture"})
public class ChangePictureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Hello...");
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

        Connection con = null;
        Statement stmt = null;
        String message = null;
        String conUrl = "jdbc:mysql://localhost:3306/";
        String driverName = "com.mysql.jdbc.Driver";
        String databaseName = "project";
        String usrName = "darshan";
        String usrPass = "darshan";

        InputStream inputStream = null;

        Part filePart = request.getPart("photo");
        String ct = filePart.getHeader("content-type");
        if ((ct.equals("image/jpeg") || ct.equals("image/png") || ct.equals("image/gif")) && (filePart.getSize() >= 1 && filePart.getSize() <= 1024 * 1024 * 3)) {
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
            }
            try {
                con = DriverManager.getConnection(conUrl + databaseName, usrName,
                        usrPass);
                stmt = con.createStatement();
                String query = "UPDATE contact SET photo=? WHERE uname=?";
                PreparedStatement statement = con.prepareStatement(query);

                if (inputStream != null) {
                    statement.setBlob(1, inputStream);
                }
                statement.setString(2, username);

                int row = statement.executeUpdate();
                if (row > 0) {
                    message = "Your pic is successfully uploaded.";
                }
            } catch (Exception e) {
                message = "ERROR in uploading pic. ";
            } finally {
                try {
                    con.close();
                    stmt.close();
                } catch (Exception e) {
                }
                request.setAttribute("msg2", message);
            }
        } else {
            request.setAttribute("msg2", "Unsupported File.");
        }
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
