<%@ page import="java.sql.Connection" %>
<%@ page import="others.Comment" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit comment</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
<div class="FormEditComment">
    <%


        Comment comment = Comment.getCommentFromDb(Integer.parseInt(request.getParameter("Id")));

    %>
    <form method="post" action="EditComment">
        <span>Your comment:</span>
        <textarea cols="15" rows="5" name="comment"><%=comment.get_CommentText()%></textarea>
        <input type="text" value="<%=request.getParameter("Id")%>" style="display: none;" name="Id">
        <input type="submit" value="Terminate editing">
    </form>
</div>
</body>
</html>
