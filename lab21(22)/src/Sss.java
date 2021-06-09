import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet {

    public Sss() {
        super();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException, IOException {
        PrintWriter pw = rs.getWriter();
        pw.println("Servlet:SSS");
        pw.close();
    }

}
