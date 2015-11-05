
package in.servlets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ImageServlet", urlPatterns = {"/captcha"})
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        String captchaText =  request.getParameter("text");
                if(captchaText == null)
                   captchaText =  "Hello World";
                
         session.setAttribute("captcha", captchaText);
        BufferedImage bfImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = bfImage.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 100,60);
        g.setColor(Color.BLACK);
        g.drawString(captchaText, 10, 20);
        
        response.setContentType("image/png");
        ImageIO.write(bfImage, "png", response.getOutputStream());
        response.flushBuffer();
    }
}
