<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>attendanceExport管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/attendanceExport.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="attendanceExport_datagrid">
		<thead>
			<tr>
				<th data-options="field:'employee_username',width:10,align:'center'">员工姓名</th>
				<th data-options="field:'earlydays',width:10,align:'center'">早退天数</th>
				<th data-options="field:'latedays',width:10,align:'center'">迟到天数</th>
				<th data-options="field:'attendancedays',width:10,align:'center'">出勤天数</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="attendanceExport_dialog">
		<form id="attendanceExport_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>早退天数</td>
				<td><input type="text" name="earlydays"></td>
			</tr>
			<tr>
				<td>迟到天数</td>
				<td><input type="text" name="latedays"></td>
			</tr>
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="employee_username"></td>
			</tr>
			<tr>
				<td>出勤天数</td>
				<td><input type="text" name="attendancedays"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="attendanceExport_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-xls" plain="true" data-cmd="download">导出表格</a>
			<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
</body>
</html>