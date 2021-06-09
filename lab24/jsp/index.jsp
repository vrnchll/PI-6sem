<%@ page import="others.Link" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="others.JdbcConnection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!Doctype html>
<html>
<head>
    <title>UWSR</title>
    <link rel="stylesheet" href="css/main.css" type="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<header>
    <h1 style="align-content: center; font-family: Cambria; font-size: 25px; padding-left: 610px">UWSR</h1>
    <div id="Search" style="margin-left: 500px">
        <form method="post" action="Search">
            <input type="text" width="150px" name="find">
            <input type="submit" value="Search">
        </form>
    </div>
</header>
<main >

    <% if (request.getParameter("admin")!=null){ %>
    <div id="FormAddLink" style="margin-left: 487px">
        <form method="POST" action="AddLink">
            <table border="0">
                <tr>
                    <td>Link:</td><td><input type="text" width="150px" name="Ref"></td>
                </tr>
                <tr>
                    <td>KeyWords:</td></td><td><input type="text" width="150px" name="DescriptionLink"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add Link" width="300px" align="center"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <%}%>
    <p style="align-content: center; font-family: Cambria; font-size: 25px; padding-left: 560px">Search result</p>
    <div id="FindedLinks">
        <%  HttpSession ses = request.getSession();
            if(ses.getAttribute("findedLinks") != null){
                ArrayList<Link> findedLinks = (ArrayList<Link>) ses.getAttribute("findedLinks");
                //  if (!findedLinks.isEmpty())
                for(Link link: findedLinks){
        %>
        <div class="Link"  style="border: 2px solid pink; background: ghostwhite; margin: 10px;">
            <a style="color: black" href=<%=link.get_Ref()%>><h2><%=link.get_DescriptionLink()%></h2></a>
            <div class="btns">
                <a style="color: black" href="AddLink?Id=<%=link.get_id()%>&action=true">+</a>
                <a style="color: black" href="AddLink?Id=<%=link.get_id()%>&action=false">-</a>
                <a style="color: black" href="Comment.jsp?Id=<%=link.get_id()%>" target="_blank">Comment</a>
                <span class="Useful"><%=link.get_IsUseful()%></span>
                <span class="Useless"><%=link.get_IsUseless()%></span>
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
                    if (UserName != null && UserName.equals(p)){
                %>
                <% if (request.getParameter("admin")!=null){ %>
                <a style="color: black" href="EditLink.jsp?Id=<%=link.get_id()%>&action=edit" >Edit</a>
                <a style="color: black" href="DeleteLink?Id=<%=link.get_id()%>">Delete</a>
                <%}%>
                <%}%>
            </div>
        </div>
        <%}}%>
    </div>
    <p style="align-content: center; font-family: Cambria; font-size: 25px; padding-left: 610px">Links</p>
    <div Id="ListOfLinks" style="color: black">
        <%
                Connection connection = JdbcConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet listOfLinks = statement.executeQuery("SELECT * FROM Refs");
                ArrayList<Link> links = new ArrayList<Link>();

                while(listOfLinks.next()){
                    Link link = new Link(listOfLinks.getInt(1),listOfLinks.getString(2), listOfLinks.getString(3), listOfLinks.getInt(4), listOfLinks.getInt(5));
                    links.add(link);
                }

                for(Link link: links){

        %>
        <div class="Link" style="border: 2px solid pink; background: ghostwhite; margin: 10px;" >
            <a style="color: black" href=<%=link.get_Ref()%>><h2><%=link.get_DescriptionLink()%></h2></a>
            <div class="btns">
                <a style="color: black" href="AddLink?Id=<%=link.get_id()%>&action=true">+</a>
                <a style="color: black" href="AddLink?Id=<%=link.get_id()%>&action=false">-</a>
                <a style="color: black" href="Comment.jsp?Id=<%=link.get_id()%>" target="_blank">Comment</a>
                <% if (request.getParameter("admin")!=null){ %>
                <a style="color: black" href="EditLink.jsp?Id=<%=link.get_id()%>&action=edit" >Edit</a>
                <a style="color: black" href="DeleteLink?Id=<%=link.get_id()%>">Delete</a>
                <%}%>
                <span class="Useful"><%=link.get_IsUseful()%></span>
                <span class="Useless"><%=link.get_IsUseless()%></span>
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
                    if (UserName != null && UserName.equals(p)){
                %>
                <a href="DeleteLink?Id=<%=link.get_id()%>">Delete</a>
                <%}%>
            </div>
        </div>
        <%
            }
%>
    </div>
</main>
</body>
</html>
