<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html>
<head>
    <title>Title</title>

</head>
<%--JSTL--%>
<body>
<i>Your entered a string </i> <%=request.getAttribute("somethingFromForm")%> <br>
<i>Number of words in that string is </i> <%=request.getAttribute("numberOfWords")%>
</body>
</html>
