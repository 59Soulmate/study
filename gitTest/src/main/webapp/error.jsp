<%--
  Created by IntelliJ IDEA.
  User: sd-kf
  Date: 2017/6/17
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>404 - Page Not Found</title>
    <link rel="stylesheet" type="text/css" href="/static/error/main.css">
    <script type="text/javascript" src="/static/public/js/jquery-1.12.4.min.js"></script>
</head>
<body>
<div id="main" class="zh">
    <header id="header">
        <h1>
            <span class="icon">!</span>404<span class="sub">页面未找到</span>
        </h1>
    </header>
    <div id="content">
        <h2>
            <br>您所请求的页面无法找到
        </h2>
        <p>
            该用户权限可能不足<br><br> 服务器无法正常提供信息。<br>
            目标页面可能已经被更改、删除或移到其他位置，或您所输入页面地址错误。
        </p>
        <div class="utilities">
            <a class="button right" href="#"
               onClick="history.go(-1);return true;">返回...</a><a
                class="button right" href="#">联系我们</a>
            <div class="clear"></div>
        </div>
    </div>
</div>
</body>
</html>