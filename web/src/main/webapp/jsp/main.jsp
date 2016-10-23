<%--
  Created by IntelliJ IDEA.
  User: Dmitry
  Date: 10/19/2016
  Time: 15:52
  To change this template use File | Settings | File Templates.
  Страница main.jsp также объявляет команду, для передачи параметра
с командой здесь использована строка с запросом типа GET, но это лишь
демонстрация возможностей. В реальном примере следует передавать ко-
манду в скрытом поле и только по методу POST. Метод doGet() в сервлете
оставить пустым.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome</title></head>
<body>
<h3>Welcome</h3>
<hr/>
${user}, hello!
<hr/>
<a href="controller?command=logout">Logout</a>
</body></html>
