<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>attendancesheet管理</title>
<%@include file="common.jsp" %> 
<script type="text/javascript" src="/static/js/views/attendancesheet.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="attendancesheet_datagrid">

	<!-- 	<thead>
			<tr>
				<th data-options="field:'id',width:10,align:'center'">编号</th>
				<th data-options="field:'employee.id',width:10,align:'center'">用户id</th>
				<th data-options="field:'ip',width:10,align:'center'">签到ip</th>
				<th data-options="field:'signintime',width:10,align:'center'">签到时间</th>
				<th data-options="field:'signouttime',width:10,align:'center'">签退时间</th>
				<th data-options="field:'state',width:10,align:'center'">状态</th>
				<th data-options="field:'employee.username',width:10,align:'center'">补签人</th>
				<th data-options="field:'retroactivetime',width:10,align:'center'">补签时间</th>
			</tr>
		</thead> -->
	</table>
	<!-- 新增编辑对话框 -->
	<div id="attendancesheet_dialog">
		<form id="attendancesheet_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>迟到天数</td>
				<td><input type="text" name="latedays"></td>
			</tr>
			<tr>
				<td>迟到天数</td>
				<td><input type="text" name="earlyleavedays"></td>
			</tr>
			<tr>
				<td>出勤天数</td>
				<td><input type="text" name="attendancedays"></td>
			</tr>


		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="attendancesheet_datagrid_tb">
		<div>
			<!-- <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a> -->
			<a class="easyui-linkbutton" iconCls="icon-sign" plain="true" data-cmd="signin">签到</a>
			<a class="easyui-linkbutton" iconCls="icon-signout" plain="true" data-cmd="update">签退</a>
			<a class="easyui-linkbutton" iconCls="icon-resign" plain="true" data-cmd="update1">补签</a>
			<!-- <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">刪除</a> -->
			<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
			<!-- <a id="employee_editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true"  data-cmd="edit">查询</a> -->
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="attendancesheet_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>