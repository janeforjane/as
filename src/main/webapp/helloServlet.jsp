<html>
<head>
    <title>YYY</title>
</head>
<body>
Hello <%=request.getAttribute("nameAttribute")%> !
<br>
<br>
<br>
<br>
<br>

<form id="form" action="myResServlet">
    <fieldset>
        <legend>Hello</legend>

        <div>
            <label>Enter something:</label>

            <input name="user-string" type="user-string" placeholder="Enter something" required autofocus>
        </div>

        <div>
            <input name="enter" type="submit" value="Go!">
        </div>
    </fieldset>
</form>
</body>
</html>
