<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单合同管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/orderBill.js"></script>
</head>
<body>
	<!-- 数据表格 -->
	<table id="orderBill_datagrid">

	</table>
	<!-- 新增编辑对话框 -->
	<div id="orderBill_dialog">
		<form id="orderBill_form" method="post" enctype="multipart/form-data">
		<table align="center" style="margin-top: 15px;">
			<input type="hidden" name="id">
<div style="margin-top: 15px" align="center">
	<div>
		<input type="text" name="client.id" id="orderBill_client" class="easyui-textbox" data-options="label:'订单客户:',labelPosition:'top', width:150">
	</div>
	<div>
		<input type="text" name="signTime" class="easyui-datebox" data-options="label:'签到时间:',labelPosition:'top', width:150">
	</div>


	<div>
		<input type="text" name="totalAmount" class="easyui-textbox" data-options="label:'总金额:',labelPosition:'top', width:150">
	</div>
	<div>
		<input type="text" name="orderAmount" class="easyui-textbox" data-options="label:'订单金额:',labelPosition:'top', width:150">
	</div>
	<div align="center">
		<input type="file" name="pic"  data-options="label:'上传文件:',labelPosition:'top'">
	</div>
	<div>
		<input type="text" name="mark" class="easyui-textbox" data-options="label:'备注:',labelPosition:'top', width:150">
	</div>

</div>
		</table>
		</form>
	</div>
	<!-- 数据表格CRUD按钮 -->
	<div id="orderBill_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
			<a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" id="editBtn" data-cmd="edit">編輯</a>
			<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
		</div>
		<div>
			关键字:<input name="keyword" class="easyui-textbox" data-options="prompt:'关键字查询'"/>
			日期:<input name="qo.beginDate" class="easyui-datebox" data-options="prompt:'开始时间'" />
			---<input name="qo.endDate" class="easyui-datebox" data-options="prompt:'结束时间'"/>
			订单状态查询:
			<input type="text" name="state.id" id="bill_state" class="easyui-combobox"
				   data-options="panelHeight:'auto',prompt:'审核状态查询',valueField:'id',textField:'name',
	data:[{id:'0',name:'生成订单状态'},{id:'1',name:'自我审核状态'},{id:'2',name:'部门审核状态'},{id:'3',name:'财务审核状态'},{id:'4',name:'废单状态'}], width:150">


			<a class="easyui-linkbutton" iconCls="icon-select" id="searchBtn" >搜索</a>

			<a class="easyui-linkbutton" iconCls="icon-audit" id="selfAuditBtn" data-cmd="selfAudit">审核</a>
			<a class="easyui-linkbutton" iconCls="icon-audit" id="deptAuditBtn" data-cmd="deptAudit">部门审核</a>
			<a class="easyui-linkbutton" iconCls="icon-audit" id="moneyAuditBtn" data-cmd="moneyAudit">财务审核</a>
			<a class="easyui-linkbutton" iconCls="icon-cancelAudit" id="feiAuditBtn" data-cmd="feiAudit">成为废单</a>


			<a class="easyui-linkbutton" iconCls="icon-select"  data-cmd="openbtn" >打开附件</a>
		</div>

	</div>
	<!-- 对话框保存取消按钮 -->
	<div id="orderBill_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
</body>
</html>