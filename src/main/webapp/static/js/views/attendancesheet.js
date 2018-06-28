$(function(){
	//对页面中的元素进行抽取.
	//方法太凌乱,希望统一管理
	//按钮在JS统一进行监听
	var attendancesheetDatagrid,attendancesheetEditBtnAndQuitBtn,attendancesheetDialog,attendancesheetForm,attendancesheetSearchBtn;
	attendancesheetDatagrid = $("#attendancesheet_datagrid");
	attendancesheetEditBtnAndQuitBtn = $("#attendancesheet_editBtn,#attendancesheet_quitBtn");
	attendancesheetDialog = $("#attendancesheet_dialog");
	attendancesheetForm = $("#attendancesheet_form");
	attendancesheetSearchBtn = $("#searchBtn");
	//数据表格
	attendancesheetDatagrid.datagrid({
		fit:true,
		rownumbers:true,
		singleSelect:true,
		pagination:true,
		url:'/attendancesheet/list',
		fitColumns:true,
		toolbar:'#attendancesheet_datagrid_tb',
		columns:[
			[
				{field:'id',align:'center',width:10,title:'编号'},
            	{field:'employee1',align:'center',width:10,formatter:employeeFormatter,title:'用户姓名'},
                {field:'ip',align:'center',width:10,title:'签到ip'},
                {field:'signintime',align:'center',width:10,formatter:signFormatter,title:'签到时间'},
                {field:'signouttime',align:'center',width:10,formatter:signFormatter,title:'签退时间'},
                {field:'state',align:'center',width:10,formatter:stateFormatter,title:'状态'},
                {field:'employee2',align:'center',width:10,formatter:employee1Formatter,title:'补签人'},
                {field:'retroactivetime',align:'center',width:10,formatter:signFormatter,title:'补签时间'}
                /*,{field:'latedays',align:'center',width:10,title:'迟到天数'},
            	{field:'earlyleavedays',align:'center',width:10,title:'早退天数'},
            	{field:'attendancedays',align:'center',width:10,title:'出勤天数'}*/
			]
		],
		onClickRow:function(rowIndex,rowData){
			//判断当前记录中的状态的值.
			if(rowData.state==1){
				//员工已经离职了,编辑和离职按钮应该变灰.
				attendancesheetEditBtnAndQuitBtn.linkbutton("disable");
			}else{
				//启用按钮
				attendancesheetEditBtnAndQuitBtn.linkbutton("enable");
			}
		}
	});
	//对话框
	attendancesheetDialog.dialog({
		width:250,
		height:380,
		buttons:'#attendancesheet_dialog_bt',
		closed:true
	});
    attendancesheetSearchBtn.textbox({
		width:230,
		label:"关键字:",
        labelWidth:50,
        prompt:"请输入搜索关键字",
        buttonText:'搜索',
        buttonIcon:'icon-search',
        onClickButton:function(){
			var keyword = $(this).val();
            attendancesheetDatagrid.datagrid("load",{
            	keyword:keyword
			});
		}
    });

	//对按钮进行统一事件监听
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	
	//方法统一管理起来]
	var cmdObj = {
			add:function(){
				//1.清空表单数据
				attendancesheetForm.form("clear");
				//2.设置对话框的标题
				attendancesheetDialog.dialog("setTitle","新增");
				//3.打开对话框
				attendancesheetDialog.dialog("open");
			},
			edit:function(){
				var rowData = attendancesheetDatagrid.datagrid("getSelected");
				if(rowData){
					//1.清空表单数据
					attendancesheetForm.form("clear");
					//2.设置对话框的标题
					attendancesheetDialog.dialog("setTitle","新增");
					//3.打开对话框
					attendancesheetDialog.dialog("open");
					//特殊数据的处理
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					//4.回显数据
					attendancesheetForm.form("load",rowData);//基于同名匹配规则
					//回显角色信息.
					//[1,3]----->List<Long>
					$.post("/role/queryRoleIdListForEmployeeForm?attendancesheetId="+rowData.id,function(data){
						$("#roleId").combobox("setValues",data);
					}),"json";
					
				}/*else{
					$.messager.alert("温馨提示","请选择一条需要修改的数据.","warning");
				}*/
				
			},
			quit:function(){
				var rowData = attendancesheetDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要离职该员工吗?",function(yes){
						if(yes){
							$.get("/attendancesheet/quit?id="+rowData.id,function(data){
								if(data.success){
                                    attendancesheetDatagrid.datagrid("reload");
									$.messager.alert("温馨提示",data.msg,"info");
								}else{
									$.messager.alert("温馨提示",data.msg,"error");
								}
							},"json")
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要离职的员工记录.","warning");
				}
			},
			reload:function(){
				//刷新数据表格
				attendancesheetDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/attendancesheet/update";
				}else{
					url = "/attendancesheet/save";
				}
				attendancesheetForm.form("submit",{
					url:url,
					onSubmit:function(param){
						//获取所有的角色信息
						var roleIds = $("#roleId").combobox("getValues");
						//把角色信息放入到表单中
						for(var i=0;i<roleIds.length;i++){
							param["roles["+i+"].id"] = roleIds[i];
						}
						return true;
					},
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							//提示消息,当点确定的时候,关闭对话框,刷新数据表格
							$.messager.alert("温馨提示",data.msg,"info",function(){
								attendancesheetDialog.dialog("close");
								attendancesheetDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function(){
                attendancesheetDialog.dialog("close");
			},
			signin:function(){
				$.get("/attendancesheet/save",function(data){
				$.messager.alert("温馨提示",data.msg,"info");
				attendancesheetDatagrid.datagrid("reload");
				})
			},
			update:function(){
				$.get("/attendancesheet/update",function(data){
					$.messager.alert("温馨提示","恭喜您,签退成功");
					attendancesheetDatagrid.datagrid("reload");
				})
			},
			update1:function(){
				
				var rowData = attendancesheetDatagrid.datagrid("getSelected");
				if(rowData){
					$.get("/attendancesheet/update1?id="+rowData.id,function(data){
						$.messager.alert("温馨提示","恭喜您,补签成功");
						attendancesheetDatagrid.datagrid("reload");
					})
					
				}else{
					$.messager.alert("温馨提示","请选择需要补签的记录");
				}
	
			}
	}
});
function stateFormatter(value,record,index){
	if(value==0){
		return "<font color='green'>正常</font>";
	}else if(value==1){
		return "<font color='red'>不正常</font>";
	}else{
		return '';
	}
}
function signFormatter(value,record,index){
	if(value){
		if(record.state==0){
			return "<font color='green'>"+value+"</font>";
		}else if(record.state==1){
			return "<font color='red'>"+value+"</font>";
		}
	}else{
		return '';
	}
	
}
function adminFormatter(value,record,index){
	if(value){
		return "是";
	}else{
		return "否";
	}
}
function deptFormatter(value,record,index){
	if(value){
		return value.name;
	}
	return '';
}
function employeeFormatter(value,record,index){
	if(value){
		return value.username;
	}
	return '';
}
function employee1Formatter(value,record,index){
	if(value){
		return value.id;
	}
	return '';
}