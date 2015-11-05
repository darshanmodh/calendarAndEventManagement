/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.dhruvi.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Wrapper

        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        Cookie[] cookies = req.getCookies();
        boolean isAuth = false;
        String username = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    isAuth = true;
                    username = c.getValue();
                    break;
                }
            }
        }
        System.out.println(req.getRequestURI());

        if (req.getRequestURI().contains("/css/")) {
            isAuth = true;
        }
        if (req.getRequestURI().contains("/js/")) {
            isAuth = true;
        }
        if (req.getRequestURI().contains("/signin")) {
            isAuth = true;
        }
        if (req.getRequestURI().contains("/register.jsp")) {
            isAuth = true;
        }
        if (req.getRequestURI().contains("/captcha")) {
            isAuth = true;
        }
        if (req.getRequestURI().contains("/register")) {
            isAuth = true;
        }
        if (req.getRequestURI().contains("/recover.jsp")) {
            isAuth = true;
         }
        if (req.getRequestURI().contains("/recover")) {
            isAuth = true;
         }
        System.out.println(username);
        if (isAuth) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
