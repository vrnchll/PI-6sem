import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sss_Header", value = "/sss_header")
public class Sss_Header extends javax.servlet.http.HttpServlet
        implements  javax.servlet.Servlet {
    public Sss_Header() {
        super();
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:doGet");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:doPost");
        System.out.println(rq.getHeader("Value-X"));
        System.out.println(rq.getHeader("Value-Y"));
        Integer x = new Integer(rq.getHeader("Value-X"));
        Integer y = new Integer(rq.getHeader("Value-Y"));
        Integer z = x + y;
        System.out.println(z.toString());
        rs.setHeader("Value-Z", z.toString());
        try {
            Thread.sleep(10000);
        } catch(Exception e) {

        }
    }
}


