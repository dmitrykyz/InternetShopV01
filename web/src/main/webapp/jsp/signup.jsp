<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/26/2016
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Sign up new Shop Client</title></head>
<body>
<form name="signupForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addnewclient" />
    Login: <input type="text" name="login" value=""/>
    <br/>
    Password: <input type="password" name="password" value=""/>
    <br/>
    FirstName <input type="text" name="firstname" value=""/>
    <br/>
    LastName <input type="text" name="laststname" value=""/>
    <br/>
    <br/>
    <input type="submit" value="Approve"/>
</form><hr/>

</body>
</html>
