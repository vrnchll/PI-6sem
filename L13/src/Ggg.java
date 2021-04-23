//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

public class Ggg extends HttpServlet {
    public Ggg() {
        System.out.println("Ggg: constructor");
    }

    public void init(ServletConfig var1) throws ServletException {
        super.init();
        System.out.println("Ggg: init");
    }

    public void destroy() {
        System.out.println("Ggg: destroy");
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ggg: " + request.getMethod());
        String parameter1 = request.getParameter("firstname");
        String parameter2 = request.getParameter("lastname");
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html> "
                + "<body> "
                + this.showRequest(request)
                + "<br><br>"
                + "Ggg: " + request.getMethod()
                + "<br>Ggg:firstname = " + parameter1
                + "<br>Ggg:lastname = " + parameter2
                + "<br>Ggg:getServerName: " + request.getServerName()
                + "<br>Ggg:getRemoteAddr: " + request.getRemoteAddr()
                + "</body>"
                + "</html>");
        printWriter.flush();

//        4
//        RequestDispatcher rd = null;
////
////                rd = request.getRequestDispatcher("/Sss");
////        rd.forward(request, response);
//
//   rd = request.getRequestDispatcher("/address.html");
//   rd.forward(request, response);
//
//        5
//        response.sendRedirect("http://localhost:8081/lab13/address.html");
    }

    private String showRequest(HttpServletRequest request) throws ServletException, IOException {
        StringBuilder var2 = new StringBuilder();
        var2.append(request.getMethod() + " ");
        var2.append(request.getRequestURL() + " ");
        var2.append(request.getProtocol() + "\n");
        Enumeration var3 = request.getHeaderNames();

        while(var3.hasMoreElements()) {
            String var4 = (String)var3.nextElement();
            var2.append(var4 + ": " + request.getHeader(var4) + "\n");
        }

        return var2.toString();
    }
}
