<%@ page import="java.sql.Connection" %>
<%@ page import="others.Link" %>
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
        Link link = null;

            link = Link.getLinkFromDb(Integer.parseInt(request.getParameter("Id")));

    %>
    <form method="post" action="EditLink">
        <span>Your link:</span>
        <textarea cols="15" rows="5" name="Link"><%=link.get_Ref()%></textarea>
        <textarea cols="15" rows="5" name="Desc"><%=link.get_DescriptionLink()%></textarea>
        <input type="text" value="<%=request.getParameter("Id")%>" style="display: none;" name="Id">
        <input type="submit" value="Terminate editing">
    </form>
</div>
</body>
</html>
