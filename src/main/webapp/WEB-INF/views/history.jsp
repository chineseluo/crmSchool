<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="common.jsp"%>
<script type="text/javascript" src="/static/js/views/history.js"></script>
<style type="text/css">
.fieldset-border {
   border: 1px solid #D4D4D4;
   border-radius: 5px 5px 5px 5px;
}
</style>
<title>移交历史首页</title>
</head>
<body>
<!-- =============================================数据表格================================================================== -->

	<table id="history_datagrid"></table>
<!-- =============================================数据表格上方的按钮============================================================== -->
	
	<div id="history_toolbar">
		<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true"
			data-cmd="reload">刷新</a>
		<a class="easyui-linkbutton" iconCls="icon-select" plain="true" 
			data-cmd="superQuery">高级查询</a>
		<div style="float: right;">
		<input class="easyui-searchbox" data-options="prompt:'关键字查询',searcher:doSearch" style="width:300px;"></input>
		</div>
	</div>
<!-- =============================================弹窗下方的按钮============================================================== -->
		<!-- 新增弹窗 -->
		<div id="history_dialog_buttons">
		<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true"
			data-cmd="save">保存</a> <a class="easyui-linkbutton"
			iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
		<!-- 查询弹窗 -->
		<div id="history_dialogOfQuery_buttons">
		<a class="easyui-linkbutton" iconCls="icon-select" plain="true"
			data-cmd="supersearch">查询</a> <a class="easyui-linkbutton"
			iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>

<!-- =============================================高级查询的弹窗============================================================== -->
	<div id="history_dialogOfQuery">
		<form method="post" id="history_superQueryForm">
			
			<fieldset class="fieldset-border">
				<legend>基本信息</legend>
				<table>
				<tr><td>客户名称:</td><td><input class="easyui-textbox"  name="name" id="name_query"/></td></tr>
				<tr><td>开始日期:</td><td><input name="begindate" class="easyui-datebox" id="begindate_query" /></td> </tr>
				<tr><td>结束日期:</td><td><input name="enddate" class="easyui-datebox" id="enddate_query" /></td> </tr>
				<tr><td>原拥有人:</td><td><input  name="beforeId" id="before_query" class="easyui-combobox"
				 data-options="valueField:'id',textField:'username',url:'/employee/queryEmpByRoleSn?sn=SALEMAN',panelHeight:'auto'"/></td></tr>
				<tr><td>移交目标:</td><td><input  name="afterId" id="after_query"    class="easyui-combobox"
				 data-options="valueField:'id',textField:'username',url:'/employee/queryEmpByRoleSn?sn=SALEMAN',panelHeight:'auto'"/></td></tr>
					
				
				</table>
			</fieldset>
			
		</form>
	</div>

</body>
</html>