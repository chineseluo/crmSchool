<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级课程管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/classCourseManage.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="classCourseManage_datagrid">
		<thead>
			<tr>
				<th data-options="field:'mark',width:10,align:'center'">备注</th>
				<th data-options="field:'classroom',width:10,align:'center'">班级</th>
			</tr>
		</thead>
	</table>
	<!-- 新增编辑对话框 -->
	<div id="classCourseManage_dialog">
		<form id="classCourseManage_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
			<tr>
				<td>备注</td>
				<td><input type="text" name="mark"></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="classroom"></td>
			</tr>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="classCourseManage_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="classCourseManage_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>