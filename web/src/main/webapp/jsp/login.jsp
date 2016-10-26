<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/19/2016
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title></head>
<body>
<h3>Internet shop</h3>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <a href="controller?command=signup">Sign up</a>
    <br/>
    <br/>
    <input type="submit" value="Log in"/>
</form><hr/>
</body></html>
