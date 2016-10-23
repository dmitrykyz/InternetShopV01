<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/19/2016
  Time: 15:48
  To change this template use File | Settings | File Templates.
  # 20 # форма ввода информации и вызов контроллера # /jsp/login.jsp
  Страница содержит скрытое поле hidden, которое должно содержать указание
на действие, связанное с функционалом этой страницы. В данном случае — запуск
процесса аутентификации пользователя. В атрибут errorLoginPassMessage будет
передаваться сообщение после неудачной попытки ввода логина-пароля. В атри-
бут wrongAction сообщение о несуществующей команде.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title></head>
<body>
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
    <input type="submit" value="Log in"/>
</form><hr/>
</body></html>
