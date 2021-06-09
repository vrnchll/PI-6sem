import others.JdbcConnection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteLink extends HttpServlet {
    public DeleteLink() {
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        String Id = rq.getParameter("Id");

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Refs WHERE ref_id = " + Id);
            rs.sendRedirect("http://localhost:8081/lab24/index.jsp");
        } catch (IOException | SQLException var12) {
            System.out.println(var12);
        }

    }
}