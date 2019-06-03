<%
String action = request.getParameter("action");
%>


<html>
<body>
<h2>Hello Truckers!</h2>

<head><title>Driver Log-in</title></head>

<body>

<form action="redirect.jsp">

    Driver name: <input type="text" name="driverName" />

    <br/><br/>

    Truck number: <input type="text" name="truckNumber" />

    <br/><br/>

    Trailer number: <input type="text" name="trailerNumber" />

    <br/><br/>

    Start address: <input type="text" name="startAddress" />

    <br/><br/>

    End address: <input type="text" name="endAddress" />

    <input type="submit" value="Submit"/>

</form>

</body>
</html>