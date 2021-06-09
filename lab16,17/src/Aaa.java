import classes.CBean;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Aaa extends HttpServlet implements Servlet {
    public Aaa() {
        super();
        System.out.println("Aaa:constructor");
    }
    public CBean cb;
    public void init() throws ServletException {
        super.init();
        System.out.println("Aaa:init");
    }
    public void destroy() {
        super.destroy();
        System.out.println("Aaa:destroy");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        HttpClient hc = new HttpClient();
       String uri = "http://localhost:8081/lab16/Bbb";
  //      String uri = "http://http://172.16.193.69:8080/AS_3022BVS/Bbb";
        PostMethod pm = new PostMethod(uri);
        pm.addRequestHeader("FirstName", "Veronika");
        pm.addRequestHeader("LastName", "Bobrik");
        pm.addRequestHeader("Age", "20");
        NameValuePair[] params = { new NameValuePair("Faculty", "FIT"),
                new NameValuePair("Course", "3"),
                new NameValuePair("Group", "2/2")};
        pm.addParameters(params);
        hc.executeMethod(pm);
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html><body><h3>Aaa<br>Response from Bbb</h3>");
        Header[] headers = pm.getResponseHeaders();
        for(int i=0;i<headers.length;i++) {
            pw.println("<br>" + headers[i].getName() + ": " + headers[i].getValue());
        }
        pw.print(pm.getResponseBodyAsString());
        pw.close();
    }
}