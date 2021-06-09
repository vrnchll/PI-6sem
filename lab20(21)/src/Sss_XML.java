import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sss_XML", value = "/sss_xml")
public class Sss_XML extends javax.servlet.http.HttpServlet implements
        javax.servlet.Servlet {
    static final long serialVersionUID = 1L;
    public Sss_XML() {
        super();
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_XML:doGET");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Sss_Rand:doPost");
        Integer n = new Integer(rq.getHeader("XRand-N"));
        System.out.println(n);
        XXRand num = new XXRand(n);
        rs.setContentType("text/xml");
        PrintWriter w = rs.getWriter();
        String s = "<?xml version=\"1.0\"  encoding = \"utf-8\" ?><rand>" ;
        for (int i = 0; i < 10; i++)
        {
            System.out.println(num.Get().toString());
            s += "<num>"+num.Get().toString()+"</num>";
        }
        s += "</rand>";
        w.println(s);
        try {
            Thread.sleep(5000);
        } catch(Exception e) {

        }
    }
}

