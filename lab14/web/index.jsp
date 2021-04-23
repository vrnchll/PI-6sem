<%@ page language="java"
         contentType="text/html;charset=ISO-8859-1"%>
<%@ page import="jspclass.* "%>
<!-- .......................................... -->
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=ISO-8859-1">
    <title>IS&amp;T-2021</title>
    <%! String name = null;
        String table = null;
        Regimex r = new Regimex();
        Integer n = r.GetHour();
        protected String Salutation(Integer h) {
            String rc = "Good ";
            if ((h > 0) && (h <= 5))
                rc += "night";
            else if ((h > 5) && (h <= 12))
                rc += "morning";
            else if ((h > 12) && (h <= 17))
                rc += "afternoon";
            else
                rc += "evening";
            return rc;
        }
        protected String NextWeekTable(Integer CountString){
            Regimex r1 = new Regimex();
            table = "<table>";
            table+="<tr> <td>" + r1.GetCurrentDate() + "</td>";
            table += " <td>" + r1.GetDayOfWeek() + "</td></tr>";

            for(Integer i = 1;i<CountString;i++){
                table += "<tr> <td>" + r1.AddDays(1) + "</td>";
                table += " <td>" + r1.GetDayOfWeek() + "</td></tr>";
            }
            table+="</table>";
            return table;
        }
    %>
</head>
<body>
   <%=NextWeekTable(7)%>
   <%=Salutation(n)%>
   <br>
   <form> <input type="submit" name="task5" value="5"> </form>
   <% if("5".equals(request.getParameter("task5"))) { %>
      <% if((n>=0) && (n<=6)) {%>
          <%@ include file="night.jsp" %>
      <%}else if ((n > 6) && (n <= 12)){%>
          <%@ include file="morning.jsp" %>
      <%}else if ((n > 12) && (n <= 17)){%>
          <%@ include file="afternoon.jsp" %>
      <%}else{%>
          <%@ include file="evening.jsp" %>
      <%}%>
   <%}%>
   <form> <input type="submit" name="task6" value="6"> </form>
   <% if("6".equals(request.getParameter("task6"))) { %>
     <% if((n>=0) && (n<=6)) {%>
       <jsp:include page="night.jsp"/>
     <%}else if ((n > 6) && (n <= 12)){%>
       <jsp:include page="morning.jsp"/>
     <%}else if ((n > 12) && (n <= 17)){%>
       <jsp:include page="afternoon.jsp"/>
     <%}else{%>
       <jsp:include page="evening.jsp"/>
     <%}%>
   <%}%>
   <form> <input type="submit" name="task7" value="7"> </form>
   <% if("7".equals(request.getParameter("task7"))){ %>
      <jsp:include page="/Afternoon"/>
   <%}%>
   <form> <input type="submit" name="task8" value="8"> </form>
   <% if("8".equals(request.getParameter("task8"))) { %>
      <% if((n>=0) && (n<=6)) {%>
        <jsp:forward page="night.jsp"/>
      <%}else if ((n > 6) && (n <= 12)){%>
        <jsp:forward page="morning.jsp"/>
      <%}else if ((n > 12) && (n <= 17)){%>
        <jsp:forward page="afternoon.jsp"/>
      <%}else{%>
        <jsp:forward page="evening.jsp"/>
      <%}%>
   <%}%>
   <form>
       <input type="submit" name="task9" value="9"/>
   </form>
   <% if("9".equals(request.getParameter("task9"))){ %>
   <jsp:forward page="Afternoon"/>
   <%}%>
   <a href="Jjj?time=<%=n%>">Jjj</a>
   <form action="Jjj" method = "post">
       <input type="text" name="time" value="<%=n%>" visible="false"/>
       <input type = "submit" name="press"  value = "POST"/>
   </form>
</body>

