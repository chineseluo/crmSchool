<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/permission.js"></script> 
</head>
<body>
	<!-- 数据表格 -->
	<table id="permission_datagrid"></table>
	<!-- 数据表格CRUD按钮 -->
	<div id="permission_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="load">加载权限</a>
		</div>
	</div>
</body>
</html>