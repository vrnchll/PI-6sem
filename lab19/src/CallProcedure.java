import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.exit;

public class CallProcedure extends HttpServlet implements Servlet {
    protected static String SqlPersonBrw = "{call GetMultiplication(?,?,?,?)}";


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
            CallableStatement stm = connection.prepareCall(SqlPersonBrw);
            stm.setInt(1, 2);
            stm.setInt(2, 3);
            stm.setInt(3, 2);
            stm.registerOutParameter(4,Types.INTEGER);
            stm.execute();
            Integer rc = stm.getInt(4);
            pw.println("res = "+rc);
            connection.close();
        }catch (SQLException e) {
            System.out.println("Rrr:doGet:SQLException:" + e);
        }
    }

}