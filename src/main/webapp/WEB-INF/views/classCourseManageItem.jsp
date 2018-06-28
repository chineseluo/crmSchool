<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程安排明细管理</title>
<%@include file="common.jsp" %>
<script type="text/javascript" src="/static/js/views/classCourseManageItem.js"></script>
</head>
<body>
<div id="course_layout" class="easyui-layout">
	<div data-options="region:'west',title:'West'" style="width:220px;">

		<div id="cc" class="easyui-layout" >
			<div data-options="region:'north',title:'日期'"  style="height:270px;">
				<div id="course_calendar" class="easyui-calendar" ></div>
			</div>

			<div data-options="region:'center',title:'班级',split:true" >
				<!-- 班级数据表格 -->
				<table id="class_datagrid">
				</table>
			</div>

		</div>

	</div>

 <div data-options="region:'center'" >

	 <!-- 数据表格 -->
	 <table id="classCourseManageItem_datagrid">
	 </table>
	 <!-- 新增编辑对话框 -->
	 <div id="classCourseManageItem_dialog">
		 <form id="classCourseManageItem_form" method="post">
			 <table align="center" style="margin-top: 15px;">
				 <input type="hidden" name="id">

				 <tr>
					 <td>日期:</td>
					 <td><input type="text" name="date" class="easyui-datebox"  data-options=" width:150"></td>
					 <td>星期:</td>
					 <td><input type="text" name="weekday" class="easyui-combobox"
								data-options="panelHeight:'auto',valueField:'id',textField:'name',
			   data:[{id:'1',name:'一'},{id:'2',name:'二'},{id:'3',name:'三'},{id:'4',name:'四'},{id:'5',name:'五'},{id:'6',name:'六'},{id:'3',name:'日'}], width:150"></td>
				 </tr>

				 </tr>


				 <tr >
					 <td>班级:</td>
					 <td><input type="text" name="classGrade.id" class="course_classGrade" class="easyui-combobox"  data-options=" width:150"></td>
					 <td>课程名称:</td>
					 <td><input type="text"  name="courseName" class="easyui-textbox"  data-options=" width:150"></td>
				 </tr>

				 <tr>
					 <td>班主任:</td>
					 <td><input type="text" name="gradeTeacher.id" id="course_gradeTeacher" class="easyui-combobox" data-options="panelHeight:'auto' ,width:150"></td>
					 <td>上课老师:</td>
					 <td><input type="text" name="courseTeacher.id" required="required" class="course_courseTeacher" class="easyui-combobox"  data-options="panelHeight:'auto' ,width:150"></td>
				 </tr>
				 <tr>
					 <td>教室:</td>
					 <td><input type="text" name="classroomManage.id" required="required" class="course_classroomManage" class="easyui-combobox"  data-options=" panelHeight:'auto',width:150"></td>
					 <td>状态:</td>
					 <td><input type="text" name="state" class="easyui-combobox"
								data-options="panelHeight:'auto',valueField:'id',textField:'name',data:[{id:'1',name:'正常'},{id:'0',name:'已完结'}], width:150"></td>
				 </tr>
				 <tr></tr>
				 <tr></tr>
				 <tr>
					 <td>备注:</td>
					 <td colspan="3"><input type="text" name="remark" class="easyui-textbox" data-options=" width:380 ,height:40"></td>
				 </tr>


			 </table>
		 </form>
	 </div>
	 <!-- 数据表格CRUD按钮 -->
	 <div id="classCourseManageItem_datagrid_tb">

			 <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
			 <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
			 <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
			 <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>

		 <div >


			 <input type="text"  name="classGrade.id" class="course_classGrade" class="easyui-combobox"  data-options="prompt:'班级', panelHeight:'auto',width:80">

			 <input type="text"  name="courseTeacher.id" class="course_courseTeacher" class="easyui-combobox"  data-options="prompt:'老师',panelHeight:'auto' ,width:80">
			 <input type="text"  name="classroomManage.id" class="course_classroomManage" class="easyui-combobox"  data-options="prompt:'教室', panelHeight:'auto',width:80">

			 日期:<input name="qo.beginDate" class="easyui-datebox" />
			 ---<input name="qo.endDate" class="easyui-datebox" />
			 <a class="easyui-linkbutton" id="searchBtn" ></a>
		 </div>
	 </div>
	 <!-- 对话框保存取消按钮 -->
	 <div id="classCourseManageItem_dialog_bt">
		 <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
		 <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" data-cmd="cancel">取消</a>
	 </div>




 </div>
</div>
</body>
</html>