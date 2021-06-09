import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.exit;

public class OracleServlet extends HttpServlet implements Servlet {
    protected static String SqlPersonBrw = "select firstname, lastname, age from Usrs where firstname = ?";


    protected void doGet(HttpServletRequest rq,
                         HttpServletResponse rs)
            throws ServletException, IOException {
        rs.setCharacterEncoding("CP1251");
        PrintWriter pw = rs.getWriter();
        try {
            String host = "localhost";
            int    port = 1521;
            String sid  = "orcl";
            String user = "system";
            String pwd  = "1Y2b3r4f";

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                System.out.println("Oracle JDBC Driver is not found");
                e.printStackTrace();
                exit (-1);
            }
            String url = String.format("jdbc:oracle:thin:@%s:%d:%s", host, port, sid);
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                System.out.println("Connection Failed : " + e.getMessage());
                exit (-1);
            }
            if (connection != null) {
                System.out.println("You made it, take control your database now!");
            } else {
                System.out.println("Failed to make connection!");
            }
            PreparedStatement stm =
                    connection.prepareStatement(SqlPersonBrw);
            stm.setString(1, "Veronika");
            ResultSet rss = stm.executeQuery();
            pw.println("<table>");
            while (rss.next()) {
                pw.println("<tr>"+"<td>"+rss.getString(1)+"</td>"
                        +"<td>"+rss.getString(2)+"</td>"
                        +"<td>"+ rss.getInt(3)+"</td>"
                        +"</tr>");
            }
            pw.println("</table>");
            connection.close();
        }catch (SQLException e) {
            System.out.println("Rrr:doGet:SQLException:" + e);
        }
    }

}