/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saquib
 */
public class ServletDemo extends HttpServlet{
    @Override
   public void init()
   {
       System.out.println("Servlet started");
       
   }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        PrintWriter out = res.getWriter();
        out.println("Hello, this is servlet");
    }
}
