<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教室设置管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/classRoomManage.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="classRoomManage_datagrid">

	</table>
	<!-- 新增编辑对话框 -->
	<div id="classRoomManage_dialog" align="center">
		<form id="classRoomManage_form" method="post">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">

			<div>
				<input type="text" name="name" class="easyui-textbox" data-options="label:'教室名称:',labelPosition:'top', width:150">
			</div>
			<div>
				<input type="text" name="address" class="easyui-textbox" data-options="label:'地址:',labelPosition:'top', width:150">
			</div>
			<div>
				<input type="text" name="seatNumber" class="easyui-textbox" data-options="label:'座位数:',labelPosition:'top', width:150">
			</div>
			<div>
				<input type="text" name="state" class="easyui-combobox"
					   data-options="label:'状态:',labelPosition:'top',valueField:'id',textField:'name', width:150,data:[{id:'1',name:'占用'},{id:'0',name:'未使用'}]">
			</div>

		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="classRoomManage_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
			<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>

		</div>
		<div align="right">
			<input id="searchBtn" type="text">
		</div>
	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="classRoomManage_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>