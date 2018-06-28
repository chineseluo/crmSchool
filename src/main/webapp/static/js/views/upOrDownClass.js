$(function(){
	var upOrDownClass_datagrid=$("#upOrDownClass_datagrid");
	var upOrDownClass_dialog=$("#upOrDownClass_dialog");
	var upOrDownClass_form=$("#upOrDownClass_form");
	var upOrDownClass_datagridView=$("#upOrDownClass_datagridView");
	var upOrDownClass_dialogView=$("#upOrDownClass_dialogView");
	var upOrDownClass_formView=$("#upOrDownClass_formView");

	upOrDownClass_datagrid.datagrid({
		url:"/potentialCustom/list?upOrDown=1",
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		fit:true,
	    fitColumns:true,
		toolbar:'#upOrDownClass_toolbar',
		striped:true,
		columns:[[
							{field:"name",title:"学生姓名",width:100,align:"center"},
							{field:"totalTuition",title:"总学费",width:100,align:"center"},
							{field:"marketStream",title:"销售流水",width:100,align:"center"},
							{field:"otherTuition",title:"其他费用",width:100,align:"center"},
							{field:"trainStartTime",title:"升班/留级时间",width:100,align:"center"},
							{field:"qq",title:"QQ",width:100,align:"center"},
							{field:"telephone",title:"联系电话",width:100,align:"center"},
							{field:"beforeClass",title:"以前的班级",width:100,align:"center",formatter:beforeclassFormatter},
							{field:"currentClass",title:"流入的班级",width:100,align:"center",formatter:flowclassFormatter},
							{field:"marketingMan",title:"营销人员",width:100,align:"center",formatter:marketingmanFormatter},
							{field:"studentState",title:"状态",width:100,align:"center",formatter:studentstateFormatter},

		          ]]

	});
		upOrDownClass_dialog.dialog({
			closable:true,
			width:600,
			height:550,
			buttons:'#upOrDownClass_dialog_buttons',
			closed:true
		});
		//查看
		upOrDownClass_dialogView.dialog({
			closable:true,
			width:600,
			height:550,
			buttons:'#upOrDownClass_dialog_buttonsView',
			closed:true
		});
		var cmdObj={
				add:function(){
					upOrDownClass_dialog.dialog('open');
					upOrDownClass_dialog.dialog("setTitle",'新增');
					upOrDownClass_form.form("clear");

				},
				cancel:function (){
					upOrDownClass_dialog.dialog('close');
				},
				save:function (){
					//判断是否有id,如有就更新数据
					var id =$("[name='id']").val();
					var url;
					if (id) {
						url="/upOrDownClass_update";
					}else{
						url='/upOrDownClass_save';
					}
					upOrDownClass_form.form("submit",{
						url:url,
						onSubmit:function(param){
							var id = $("#flowclass_combobox").combobox("getValue");
							param['currentclass.id'] = id;
						},
						success:function(result){
							result=$.parseJSON(result);
							if(result.success){
								$.messager.alert("温馨提示",result.msg,'icon-smile',function(){
									upOrDownClass_dialog.dialog('close');
									upOrDownClass_datagrid.datagrid("reload");
								});
							}else{
								$.messager.alert("温馨提示",result.msg,'icon-warning',function(){

								});
							}
						}
					});
				},
				edit:function (){
					var record =upOrDownClass_datagrid.datagrid("getSelected");
					if (record) {
						upOrDownClass_dialog.dialog("open");
						upOrDownClass_dialog.dialog("setTitle","学员编辑");
						upOrDownClass_form.form("clear");
						//编辑时,给属性传递参数
						if(record.beforeclass!=null){
							record['beforeclass.id']=record.beforeclass.id;
						}
						if(record.marketingman!=null){
							record['marketingman.id']=record.marketingman.id;
						}
						if(record.flowclass!=null){
							record['flowclass.id']=record.flowclass.id;
						}
						if(record.studentstate!=null){
							record['studentstate.id']=record.studentstate.id;
						}
						upOrDownClass_form.form("load",record);

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				reload:function(){
					upOrDownClass_datagrid.datagrid("reload");
				},
				del:function(){
					var record =upOrDownClass_datagrid.datagrid("getSelected");
					if (record) {
						$.messager.confirm("温馨提示","亲,确定要删除该信息吗?",function(yes){
							if(yes){
								$.get("/upOrDownClass_deleteByPrimaryKey?id="+record.id,function(result){
									if(result.success){
										$.messager.alert("温馨提示",result.msg,'info',function(){
											alert("删除成功");
											upOrDownClass_datagrid.datagrid("reload");
										});
									}else{
										alert("删除失败");
										$.messager.alert("温馨提示",result.msg,'warning');
									}
								});
							}
						});

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				//高级查询
				upOrDownSearch:function () {
					var keyword = $("[name='keyword']").val();
					$("#upOrDownClass_datagrid").datagrid("load", {
						keyword: keyword
					});
				},
				//快速查询
				fastSearch:function () {
					var keyword = $("#searchClass").val();
					$("#upOrDownClass_datagrid").datagrid("load", {
						keyword: keyword
					});
				},
				//查看按钮
				view:function (){
					var record =upOrDownClass_datagrid.datagrid("getSelected");
					if (record) {
						upOrDownClass_dialogView.dialog("open");
						upOrDownClass_dialogView.dialog("setTitle","查看学员");
						upOrDownClass_formView.form("clear");
						//编辑时,给属性传递参数
						if(record.currentclass!=null){
							record['currentclass.id']=record.currentclass.id;
						}
						if(record.marketingman!=null){
							record['marketingman.id']=record.marketingman.id;
						}
						if(record.payway!=null){
							record['payway.id']=record.payway.id;
						}
						if(record.paystate!=null){
							record['paystate.id']=record.paystate.id;
						}
						if(record.studentstate!=null){
							record['studentstate.id']=record.studentstate.id;
						}
						upOrDownClass_formView.form("load",record);

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				cancelView:function (){
					upOrDownClass_dialogView.dialog('close');
				},


		};
		$("[data-cmd]").on("click",function(){
			var cmd =$(this).data("cmd");
			cmdObj[cmd]();
		});
	
});
	function marketingmanFormatter(value,row,index){
		return value?value.username:'';
	}
	function beforeclassFormatter(value,row,index){
		return value?value.name:'';
	}
	function studentstateFormatter(value,row,index){

        if (value) {
            if (value == 2 ) {
                return "学员升班";
            }
            if (value == 3 ) {
                return "学员留级";
            }
        }
		return '';
	}
function flowclassFormatter(value,row,index){
		return value?value.name:'';
	}
