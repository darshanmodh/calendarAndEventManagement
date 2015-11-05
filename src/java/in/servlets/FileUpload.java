    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import in.hibernate.MyHb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
@WebServlet(name = "FileUpload", urlPatterns = {"/upload"})
public class FileUpload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/myFiles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String desc = request.getParameter("desc");
        Part part = request.getPart("file");
        PrintWriter pw = response.getWriter();

        String disposition = part.getHeader("content-disposition");
        String ct = part.getHeader("content-type");
        
        disposition = disposition.replaceAll("\"", "");
        String[] ar = disposition.split("filename=");
        String filename = "";

        if (ar.length == 2) {
            filename = ar[1];
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
        
        String virtualPath = "/files/" + username +"@" + filename;
        String realPath = getServletContext().getRealPath(virtualPath);

        if (part.getSize() >= 1 && part.getSize() <= 1024 * 1024 * 5) {
            part.write(realPath);
            request.setAttribute("msg1", "File " + filename + " has been uploaded successfully.");
            request.getRequestDispatcher("/myFiles.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", filename + " is more than 5 MB.");
            request.getRequestDispatcher("/myFiles.jsp").forward(request, response);
        }
    }
}
