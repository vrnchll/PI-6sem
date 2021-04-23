import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Afternoon extends HttpServlet implements Servlet {
    public Afternoon() {
        super();
        System.out.println("Afternoon:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        super.init();
        System.out.println("Afternoon:init");
    }
    public void destroy() {
        super.destroy();
        System.out.println("Afternoon:destroy");
    }
    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException,  IOException {
        System.out.println("Afternoon:service:"+rq.getMethod());
        PrintWriter pw = rs.getWriter();
        pw.println("Servlet:Good afternoon" + "\n");
        pw.flush();
    }
}
