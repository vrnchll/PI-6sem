<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="others.Comment"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>Links comments</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
<div id="comments" style="margin: auto">
    <div id="FormComment">
        <form method="post" action="AddComment">
            <table style="margin: auto">
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" width="150px"></td>
                </tr>
                <tr>
                    <td>Comment:</td>
                    <td>
                        <textarea cols="50" rows="5" name="comment"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" value="<%=request.getParameter("Id")%>" style="display: none;" name="Id">
                        <input style="margin-left: 230px" width="150px" type="submit" value="Add">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="ListOfComments">
        <%


            ArrayList<Comment> comments = Comment.getCommentsFromDb(Integer.parseInt(request.getParameter("Id")));

            for(Comment comment: comments){
        %>

        <div class="Comment" style="border: 1px solid black">
            <p>
                <span><b><%=comment.get_author()%></b></span><br>
                <span><i><%=comment.get_date().toString()%></i></span>
            <p><%=comment.get_CommentText()%></p>
            <%
                Cookie[] cookies = request.getCookies();
                String UserName = null;
                String cookieName = "UserName";
                LocalDate date = LocalDate.now();
                String p = String.valueOf(date.getMonthValue() + date.getDayOfMonth() + date.getYear());
                for(Cookie cookie: cookies){
                    if (cookieName.equals(cookie.getName())) {
                        UserName = cookie.getValue();
                        break;
                    }
                }
                if (UserName.equals(comment.get_author()) || UserName.equals(p) || request.getParameter("admin")!=null){
            %>
            <a style="color: black" href="EditComment.jsp?Id=<%=comment.get_id()%>">Edit comment</a>
            <a style="color: black" href="EditComment?Id=<%=comment.get_id()%>&action=del">Delete comment</a>
            <%}%>
            </p>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
