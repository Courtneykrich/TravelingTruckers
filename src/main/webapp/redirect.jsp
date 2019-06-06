<html>

<head><title>Job Creation Confirmation</title></head>

<body>

    This <%= request.getParameter("customer") %> job has been added.
    <br></br>
    Expenses included:
    <ul>
    <%
    String[] expenses = request.getParameterValues("expenses");
        for(String tempExp : expenses){
        out.println("<li>"+tempExp+ "</li>");
        }
    %>
    </ul>
    <br></br>
    Thanks, <%= request.getParameter("driverName") %>


</body>
</html>

