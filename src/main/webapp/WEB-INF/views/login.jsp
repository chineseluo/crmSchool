<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="shiro"  uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>罗中文客户关系管理系统</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/views/login.js"></script>
    <shiro:authenticated>
        <script type="text/javascript">
            window.location.href ="/main";
        </script>
    </shiro:authenticated>
</head>
<body>
<section class="container">
    <div class="login">
        <h1>用户登录</h1>
        <form id="loginForm" method="post">
            <p><input type="text" name="username" value="admin" placeholder="账号"></p>
            <p><input type="password" name="password" value="123456" placeholder="密码"></p>
            <p class="submit">
                <input id="loginBtn" type="button" value="登录">
                <input id="resetBtn" type="button" value="重置">
            </p>
        </form>
    </div>
</section>
<div style="text-align:center;" class="login-help">
    <p>Copyright ©2018 This Crm-system is coding form ChineseLuo</p>
</div>
</body>
</html>