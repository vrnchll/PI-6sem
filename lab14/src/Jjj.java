import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Jjj extends HttpServlet implements Servlet {
    public Jjj() {
        super();
        System.out.println("Jjj:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        super.init();
        System.out.println("Jjj:init");
    }
    public void destroy() {
        super.destroy();
        System.out.println("Jjj:destroy");
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        Integer hour = new Integer(rq.getParameter("time"));
        String jsp = "";
        if ((hour >= 0) && (hour <= 6))
            jsp =  "/night.jsp";
        else if ((hour > 6) && (hour <= 12))
            jsp = "/morning.jsp";
        else if ((hour > 12) && (hour <= 17))
            jsp = "/afternoon.jsp";
        else
            jsp = "/evening.jsp";
        rs.sendRedirect("/lab14" + jsp);
//        rs.sendRedirect("/AS_3022BVS" + jsp);
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        Integer hour = new Integer(rq.getParameter("time"));
        String jsp = "";
        if ((hour >= 0) && (hour <= 6))
            jsp =  "/night.jsp";
        else if ((hour > 6) && (hour <= 12))
            jsp = "/morning.jsp";
        else if ((hour > 12) && (hour <= 17))
            jsp = "/afternoon.jsp";
        else
            jsp = "/evening.jsp";
        rs.sendRedirect("/lab14" + jsp);
//        rs.sendRedirect("/AS_3022BVS" + jsp);
    }
}
