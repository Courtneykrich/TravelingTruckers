<html>
<body>
<h2>Hello Truckers!</h2>

<head><title>Driver Log-in</title></head>

<body>

 <!-- <form action="redirect.jsp"> -->

  <form action="trucker" method="GET">

<select name="driverName">
    <option>Kerry K</option>
    <option>Ken</option>
    <option>Marissa</option>
    <option>Dorie</option>
    <option>Frank</option>
    <option>Ted</option>
    <option>Kerry I</option>
    </select>

    <br/><br/>

    <input type="radio" name="customer" value="SAK"> SAK
    <input type="radio" name="customer" value="INS"> INS
    <input type="radio" name="customer" value="BLD"> BLD
    <input type="radio" name="customer" value="Other"> Other

    <br/><br/>

    Truck number: <input type="text" name="truckNumber" />

    <br/><br/>

    Trailer number: <input type="text" name="trailerNumber" />

    <br/><br/>

    Start address: <input type="text" name="startAddress" />

    <br/><br/>

    End address: <input type="text" name="endAddress" />

    <br/><br/>

    <input type="checkbox" name="expenses" value= "Flight"> Flight
    <input type="checkbox" name="expenses" value= "Car Rental"> Car Rental
    <input type="checkbox" name="expenses" value= "Hotel"> Hotel
    <input type="checkbox" name="expenses" value= "Maintenance"> Maintenance

    <br/><br/>

    <input type="submit" value="Submit"/>

</form>

</body>
</html>