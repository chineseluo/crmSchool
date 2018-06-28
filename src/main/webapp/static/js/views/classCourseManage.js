$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var classCourseManageDatagrid,classCourseManageDialog,classCourseManageForm;
	classCourseManageDatagrid = $("#classCourseManage_datagrid");
	classCourseManageDialog = $("#classCourseManage_dialog");
	classCourseManageForm = $("#classCourseManage_form");
	/*
	 * 初始化数据表格 
	 */
	classCourseManageDatagrid.datagrid({
		url:"/classCourseManage/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#classCourseManage_datagrid_tb'
	});
	/*
	 * 初始化新增/编辑对话框 
	 */
	classCourseManageDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#classCourseManage_dialog_bt'
	});
	/*
	 * 对页面按钮进行统一监听
	 */
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	/*
	 * 所有的操作封装到cmdObj对象中,方便管理
	 */
	var cmdObj = {
			 add:function(){
				classCourseManageForm.form("clear");
				classCourseManageDialog.dialog("setTitle","新增");
				classCourseManageDialog.dialog("open");
			},
			edit:function(){
				var rowData = classCourseManageDatagrid.datagrid("getSelected");
				if(rowData){
					classCourseManageForm.form("clear");
					classCourseManageDialog.dialog("setTitle","编辑");
					classCourseManageDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					classCourseManageForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = classCourseManageDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/classCourseManage/delete?classCourseManageId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										classCourseManageDatagrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"error");
								}
							},"json")
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要删除的数据!","warining");
				}
			},
			reload:function(){
				classCourseManageDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/classCourseManage/update"
				}else{
					url = "/classCourseManage/save";
				}
				classCourseManageForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								classCourseManageDialog.dialog("close");
								classCourseManageDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				classCourseManageDialog.dialog("close");
			}
	}
});
