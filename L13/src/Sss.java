
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Sss extends HttpServlet {

    public Sss() {
        System.out.println("Sss: constructor");
    }

    public void init(ServletConfig config) throws ServletException {
        super.init();
        System.out.println("Sss: init");
    }

    public void destroy(){
        System.out.println("Sss: destroy");
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Sss: service: " + request.getMethod());
//        PrintWriter writer = response.getWriter();
//        writer.write("Sss: service: " + request.getMethod() + "\n");
//        writer.write("Server name: " + request.getServerName() + "\n");
//        writer.write("Addr: " + request.getRemoteAddr() + " Port: " + request.getRemotePort() + "\n\n");
//        writer.write(showRequest(request) + "\n");
        super.service(request, response);
    }

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
       System.out.println("Sss: doGet");
//////    PrintWriter writer = response.getWriter();
//////    writer.write("Sss: service: " + request.getMethod() + "\n");
//////    writer.write("Server name: " + request.getServerName() + "\n");
////
//////        //1,4
////////        RequestDispatcher requestDispatcher;
////////        requestDispatcher=request.getRequestDispatcher("/Ggg");
////////        requestDispatcher.forward(request,response);
////////        //3
////////        RequestDispatcher requestDispatcher;
////////        requestDispatcher=request.getRequestDispatcher("/address.html");
////////        requestDispatcher.forward(request,response);
//////
//////        //5
//////        //  response.sendRedirect("http://localhost:8081/lab13/address.html");
//////           response.sendRedirect("http://localhost:8081/lab13/Ggg");
//////
//////
    // обработка http-запроса
        System.out.println("Sss:doGet");
    HttpClient hc = new HttpClient();
//     GetMethod pm = new GetMethod("http://172.16.193.69:8080"
//              + request.getContextPath() + "/Ggg?firstname=Veronika&lastname=Bobrik");
    GetMethod pm = new GetMethod("http://localhost:8081"
            + request.getContextPath() + "/Ggg?firstname=Veronika&lastname=Bobrik");
        hc.executeMethod(pm);
        response.getWriter().write(pm.getResponseBodyAsString());
}

   public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
//        //2
////        RequestDispatcher requestDispatcher;
////        requestDispatcher=request.getRequestDispatcher("/Ggg");
////        requestDispatcher.forward(request,response);
//
        // обработка http-запроса
        System.out.println("Sss:doPost");
        HttpClient hc = new HttpClient();
//        PostMethod pm = new PostMethod("http://172.16.193.69:8080"
//               + request.getContextPath() + "/Ggg");
        PostMethod pm = new PostMethod("http://localhost:8081"
                + request.getContextPath() + "/Ggg");
        NameValuePair[] parms = { new NameValuePair("firstname","Veronika"),
                new NameValuePair("lastname","Bobrik")};
        pm.addParameters(parms);
        hc.executeMethod(pm);
        response.getWriter().write(pm.getResponseBodyAsString());
    }

    private String showRequest(HttpServletRequest request)
            throws ServletException, IOException {

        StringBuilder requestString = new StringBuilder();

        requestString.append(request.getMethod() + " ");
        requestString.append(request.getRequestURL() + " ");
        requestString.append(request.getProtocol() + "\n");

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            requestString.append(headerName + ": " + request.getHeader(headerName) + "\n");
        }

        return requestString.toString();
    }

}
