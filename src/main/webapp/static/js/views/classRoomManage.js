$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var classRoomManageDatagrid,classRoomManageDialog,classRoomManageForm,classRoomManageSearchBtn;
	classRoomManageDatagrid = $("#classRoomManage_datagrid");
	classRoomManageDialog = $("#classRoomManage_dialog");
	classRoomManageForm = $("#classRoomManage_form");
	var classRoomManageSearchBtn = $("#searchBtn");
	/*
	 * 初始化数据表格 
	 */
	classRoomManageDatagrid.datagrid({
		url:"/classRoomManage/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#classRoomManage_datagrid_tb',
		columns:[
			[
				{field:'name',title:'名称',width:10,align:'center'},
				{field:'address',title:'地址',width:10,align:'center'},
				{field:'seatNumber',title:'座位数',width:10,align:'center'},
				{field:'state',title:'状态',width:10,align:'center',formatter:function (value,record,index) {
					if(value==0){
                        return "<font color='green'>未使用</font>"
					}else if(value==1){
                        return "<font color='red'>占用</font>"
                    }
                }}
			]
		]
	});
    classRoomManageSearchBtn.textbox({
        width:150,
        labelWidth:50,
        prompt:"请输入关键字",
        buttonText:'搜索',
        buttonIcon:'icon-search',
        onClickButton:function(){
            var keyword = $(this).val();
            classRoomManageDatagrid.datagrid("load",{
                keyword:keyword
            });
        }
    });

	/*
	 * 初始化新增/编辑对话框
	 */
	classRoomManageDialog.dialog({
		width:300,
		height:300,
		closed:true,
		buttons:'#classRoomManage_dialog_bt'
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
				classRoomManageForm.form("clear");
				classRoomManageDialog.dialog("setTitle","新增");
				classRoomManageDialog.dialog("open");
			},
			edit:function(){
				var rowData = classRoomManageDatagrid.datagrid("getSelected");
				if(rowData){
					classRoomManageForm.form("clear");
					classRoomManageDialog.dialog("setTitle","编辑");
					classRoomManageDialog.dialog("open");
					if(rowData.dept)
						rowData["dept.id"] = rowData.dept.id;
					classRoomManageForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = classRoomManageDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/classRoomManage/delete?classRoomManageId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										classRoomManageDatagrid.datagrid("reload");
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
				classRoomManageDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/classRoomManage/update"
				}else{
					url = "/classRoomManage/save";
				}
				classRoomManageForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								classRoomManageDialog.dialog("close");
								classRoomManageDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				classRoomManageDialog.dialog("close");
			}
	}
});
