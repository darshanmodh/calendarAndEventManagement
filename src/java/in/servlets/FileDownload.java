/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Darshan
 */
@MultipartConfig
@WebServlet(name = "FileDownload", urlPatterns = {"/download"})
public class FileDownload extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fileName = request.getParameter("file");
        String vPath = "/files/" + fileName;
        String rPath = getServletContext().getRealPath(vPath);
        
        response.addHeader("context-type", "application/octet-stream");
        
        File file = new File(rPath);
        response.addHeader("context-length", String.valueOf(file.length()));
        response.addHeader("content-disposition", "attachment; filename="+fileName);
        
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        
        byte []ar = new byte[2048];
        int readByte = 0;
        
        while((readByte=in.read(ar)) > 0)
        {
            out.write(ar,0,readByte);
        }
        out.close();
        in.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
}
