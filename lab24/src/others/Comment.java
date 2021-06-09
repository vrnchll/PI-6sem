package others;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Comment {
    private int _id;
    private int _LinkId;
    private String _author;
    private String _CommentText;
    private String _date;

    public int get_id() {
        return this._id;
    }

    public Comment(int id, int LinkId, String author, String date, String comment) {
        this._id = id;
        this._CommentText = comment;
        this._LinkId = LinkId;
        this._date = date;
        this._author = author;
    }

    public static Boolean existCookieName(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie[] var3 = cookies;
        int var4 = cookies.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Cookie cookie = var3[var5];
            if (cookie.getName() == "UserName" && cookie.getValue() == name) {
                return true;
            }
        }

        return false;
    }

    public String get_CommentText() {
        return this._CommentText;
    }

    public int get_LinkId() {
        return this._LinkId;
    }

    public String get_date() {
        return this._date;
    }

    public String get_author() {
        return this._author;
    }

    public static ArrayList<Comment> getCommentsFromDb(int LinkId) throws SQLException, ClassNotFoundException {
        ArrayList<Comment> resultSet = new ArrayList();
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Comments WHERE ref_id = " + LinkId);

        while(result.next()) {
            Comment comment = new Comment(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5));
            resultSet.add(comment);
        }

        statement.close();
        connection.close();
        return resultSet;
    }

    public static Comment getCommentFromDb(int Id) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Comments WHERE com_id = " + Id);

        Comment comment;
        for(comment = null; result.next(); comment = new Comment(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5))) {
        }

        statement.close();
        connection.close();
        return comment;
    }
}
