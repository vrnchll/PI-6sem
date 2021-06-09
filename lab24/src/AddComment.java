import others.JdbcConnection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddComment extends HttpServlet {
    public AddComment() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Cookie cookie = new Cookie("UserName", name);
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        String comment = req.getParameter("comment");
        String Id = req.getParameter("Id");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException var11) {
            System.out.println(var11);
            var11.printStackTrace();
        }

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO Comments(ref_id, session_id, stamp, com_text)" + "VALUES (\'%s\',\'%s\',CURRENT_DATE,\'%s\')", Id, name, comment));
            statement.close();
            connection.close();
        } catch (SQLException var10) {
            System.out.println(var10);
            var10.printStackTrace();
        }

        resp.sendRedirect("Comment.jsp?Id=" + Id);
    }
}