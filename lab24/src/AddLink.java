import others.JdbcConnection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddLink extends HttpServlet implements Servlet {
    public AddLink() {
        super();
        System.out.println("AddLink:constructor");
    }

    public void init(ServletConfig sc) throws ServletException {
        super.init();
        System.out.println("AddLink:init");
    }

    public void destroy() {
        super.destroy();
        System.out.println("AddLink:destroy");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        rq.setCharacterEncoding("UTF-8");
        String Id = rq.getParameter("Id");
        String action = rq.getParameter("action");
        if ("true".equals(action)) {
            try {
                Connection connection = JdbcConnection.getConnection();
                Statement statement = connection.createStatement();
                statement.execute(String.format("UPDATE Refs SET plus = plus+1 WHERE ref_id = " + Id));
                connection.close();
            } catch ( SQLException var12) {
                System.out.println(var12);
            }
        }
        else if("false".equals(action)){
            try {
                Connection connection = JdbcConnection.getConnection();
                Statement statement = connection.createStatement();
                statement.execute(String.format("UPDATE Refs SET minus = minus-1 WHERE ref_id = " + Id));
                connection.close();
            } catch ( SQLException var12) {
                System.out.println(var12);
            }
        }
        rs.sendRedirect("http://localhost:8081/lab24/index.jsp");
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        rq.setCharacterEncoding("UTF-8");
        String Ref = rq.getParameter("Ref");
        String Description = rq.getParameter("DescriptionLink");
        int plus = 0;
        int minus = 0;
        if (Ref.length()>1 && Description.length()>1) {
            try {
                Connection connection = JdbcConnection.getConnection();
                Statement statement = connection.createStatement();
                statement.execute(String.format("INSERT INTO Refs (url, description, minus, plus ) Values (\'%s\',\'%s\',\'%d\',\'%d\')", Ref, Description, 0,0));

                connection.close();
            } catch (SQLException var12) {
                System.out.println(var12);
            }
        }
        rs.sendRedirect("http://localhost:8081/lab24/index.jsp");
    }
}