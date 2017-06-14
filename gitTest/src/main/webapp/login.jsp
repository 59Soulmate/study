<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dream-Login</title>
    <link rel="stylesheet" type="text/css" href="/static/public/css/Login.css"/>
</head>
<body>
<div id="login">
    <h1>Login_Dream1</h1>
    <form action="/front/index.action" method="post">
        <input type="text" required="required" placeholder="用户名" name="name" id="name"/>
        <input type="password" required="required" placeholder="密码" name="pass" id="pass"/>
        <button class="but" type="submit">登录</button>
    </form>
</div>
</body>
</html>