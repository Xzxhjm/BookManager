<%--
  Created by IntelliJ IDEA.
  User: zzy
  Date: 2023/7/18
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>图书管理系统</title>
    <script>
      $(function()
      {
        $.post("/UserLogInServlet",$("#UserLoginForm").serialize(),function(data)
        {
          window.open("hello.html");
        });
      })
    </script>
  </head>
  <body>
  <form id="UserLoginForm" action="UserLogInServlet" method="post">
    <input type="text" name="username" placeholder="用户名">
    <input type="password" name="password" placeholder="密码">
    <input type="submit" value="登录">
  </form>
  </body>
</html>
