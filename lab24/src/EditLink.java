import others.Link;
import others.JdbcConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet({"/EditLink"})
public class EditLink extends HttpServlet {
    public EditLink() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("Id");
        String linkValue = request.getParameter("Link");
        String desc = request.getParameter("Desc");
        try {




            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(String.format("UPDATE Refs SET url = \'" + linkValue + "\' , description = \'" + desc + "\'  WHERE ref_id = " + Id));
            statement.close();
            connection.close();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }


        response.sendRedirect("http://localhost:8081/lab24/index.jsp");
    }
}
