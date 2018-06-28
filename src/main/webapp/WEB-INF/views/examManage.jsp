<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="common.jsp"%>
<script type="text/javascript" src="/static/js/views/examManage.js"></script>
<style type="text/css">
.fieldset-border {
   border: 1px solid #D4D4D4;
   border-radius: 5px 5px 5px 5px;
}
</style>
<title>考试管理首页</title>
</head>
<body>
<!-- =============================================数据表格================================================================== -->

	<table id="exammanage_datagrid"></table>
<!-- =============================================数据表格上方的按钮============================================================== -->
	
	<div id="exammanage_toolbar">
	
		<%--<a class="easyui-linkbutton" iconCls="icon-add" plain="true"
			data-cmd="add">新增</a>
        <a class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" data-cmd="edit" id="edit_btn">编辑</a>
		<a class="easyui-linkbutton" iconCls="icon-no" plain="true"
			data-cmd="del">删除</a>--%>
		<a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true"
			data-cmd="reload">刷新</a>
		<%--<a class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" id="observeBtn"
			data-cmd="observe">查看</a>--%>
		<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true"
			data-cmd="updateResult">登记考试结果</a>
		<div style="float: right;">
		<input class="easyui-searchbox" data-options="prompt:'关键字查询',searcher:doSearch" style="width:300px;"></input>
		
		</div>
	
		
	</div>
<!-- =============================================弹窗下方的按钮============================================================== -->
		<!-- 新增弹窗 -->
		<div id="exammanage_dialog_buttons">
		<a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true"
			data-cmd="save">保存</a> <a class="easyui-linkbutton"
			iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
		<!-- 查询弹窗 -->
		<div id="exammanage_dialogOfQuery_buttons">
		<a class="easyui-linkbutton" iconCls="icon-select" plain="true"
			data-cmd="supersearch">查询</a> <a class="easyui-linkbutton"
			iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
	</div>
		<!-- 登记结果弹窗 -->
		<div id="exammanage_resultdialog_buttons">
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true"
			data-cmd="saveResult">登记考试结果</a> <a class="easyui-linkbutton"
			iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
	</div>
<!-- =============================================新增和编辑的弹窗============================================================== -->
	<div id="exammanage_dialog">
		<form method="post" id="exammanage_form">
			<input type="hidden" name="id" />
			<fieldset class="fieldset-border">
				<legend>基本信息</legend>
				<table>
				<tr><td>考试名称:</td><td><input name="name" id="exam_name" class="easyui-validatebox easyui-textbox"  data-options="required:true"/></td> </tr>
				<tr><td>考试编号: </td><td><input  class="easyui-validatebox easyui-textbox" name="sn" /></td> </tr>
				<tr><td>学生姓名:</td><td><input id="student_name"  name="student.id" class="easyui-combobox easyui-validatebox"
                           data-options="required:true,valueField:'id',textField:'name',url:'',panelHeight:'auto'" /></td> </tr>
				<tr><td>考试时间:</td><td><input class="easyui-datebox" name="examtime" /></td></tr>
				
				<tr><td>备注:</td><td><input class="easyui-textbox" name="examremark" /></td> </tr>
				
				</table>
			</fieldset>
			
		</form>
	</div>

<!-- =============================================查看的弹窗============================================================== -->
	<div id="exammanage_dialogOflistall">
		<form method="post" id="exammanage_listallform">
			<input type="hidden" name="id" />
			<fieldset class="fieldset-border">
				<legend>基本信息</legend>
				<table>
				<tr>
					<td>考试名称:</td><td><input name="name" style="border-style: none;" readonly="readonly"/></td>
					<td>考试编号: </td><td><input  name="sn" style="border-style: none;" readonly="readonly" /></td>
					<td>学生姓名</td><td><input name="studentName" style="border-style: none;" readonly="readonly"/></td> </tr>
				<tr>
					<td>营销人员:</td><td><input name="studentMarket" style="border-style: none;" readonly="readonly"/></td>
					<td>&nbsp;QQ:&nbsp;</td><td><input name="studentQQ" style="border-style: none;" readonly="readonly"/></td>
					<td>电话:</td><td><input name="studentTel" style="border-style: none;" readonly="readonly"/></td> </tr>
				<tr>
					<td>意向班级: </td><td><input name="studentClass"  style="border-style: none" readonly="readonly" /> </td>
					<td>考试时间</td><td><input name="examtime" style="border-style: none;" readonly="readonly"/></td>
					<td>考试结果</td><td><input name="examresult" style="border-style: none;" readonly="readonly"/></td> </tr>
				<tr>
					<td>备注: </td><td><input name="examremark"  style="border-style: none" readonly="readonly" /> </td>
					<td>最后处理人:</td><td><input name="employee.name" style="border-style: none;" readonly="readonly"/></td>
					 </tr>
				</table>
			</fieldset>
			
		</form>
	</div>
<!-- =============================================登记考试结果的弹窗============================================================== -->
	<div id="exammanage_resultdialog">
		<form method="post" id="exammanage_resultform">
			<input type="hidden" name="id" />
			<fieldset class="fieldset-border">
				<legend>基本信息</legend>
				<table>
				<tr><td>考试结果:</td><td><input class="easyui-textbox" name="examResult" /></td></tr>
				
				</table>
			</fieldset>
			
		</form>
	</div>
</body>
</html>