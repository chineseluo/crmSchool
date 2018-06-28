$(function(){
	var lossStudent_datagrid=$("#lossStudent_datagrid");
	var lossStudent_dialog=$("#lossStudent_dialog");
	var lossStudent_form=$("#lossStudent_form");
	var lossStudent_datagridView=$("#lossStudent_datagridView");
	var lossStudent_dialogView=$("#lossStudent_dialogView");
	var lossStudent_formView=$("#lossStudent_formView");

	lossStudent_datagrid.datagrid({
		url:"/potentialCustom/list?studentState=4",
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		fit:true,
	    fitColumns:true,
		toolbar:'#lossStudent_toolbar',
		striped:true,
		columns:[
		          [
							{field:"name",title:"学生姓名",width:100,align:"center"},
							{field:"qq",title:"QQ",width:100,align:"center"},
							{field:"telephone",title:"电话",width:100,align:"center"},
							{field:"fatalisminSchool",title:"上课天数",width:100,align:"center"},
							{field:"currentClass",title:"流失班级",width:100,align:"center",formatter:currentclassFormatter},
							{field:"losssTage",title:"流失阶段",width:100,align:"center"},
							{field:"lossCause",title:"流失原因",width:100,align:"center"},
							{field:"lossTime",title:"流失时间",width:100,align:"center"},
							{field:"marketingMan",title:"营销人员",width:100,align:"center",formatter:marketingmanFormatter},
							{field:"inputMan",title:"录入人",width:100,align:"center",formatter:inputmanFormatter},
							{field:"refundment",title:"是否退款",width:100,align:"center",formatter:refundmentFormatter},
							{field:"studentState",title:"状态",width:100,align:"center",formatter:studentstateFormatter},

		          ]
        ]

	});
		lossStudent_dialog.dialog({
			closable:true,
			width:350,
			height:300,
			buttons:'#lossStudent_dialog_buttons',
			closed:true
		});
		//查看
		lossStudent_dialogView.dialog({
			closable:true,
			width:600,
			height:550,
			buttons:'#lossStudent_dialog_buttonsView',
			closed:true
		});
		var cmdObj={
				add:function(){
					lossStudent_dialog.dialog('open');
					lossStudent_dialog.dialog("setTitle",'新增');
					lossStudent_form.form("clear");

				},
				cancel:function (){
					lossStudent_dialog.dialog('close');
				},
				save:function (){
					//判断是否有id,如有就更新数据
					var id =$("[name='id']").val();
					var url;
					if (id) {
						url="/lossStudent/update";
					}else{
						url='/lossStudent_save';
					}
					lossStudent_form.form("submit",{
						url:url,
						success:function(result){
							result=$.parseJSON(result);
							if(result.success){
								$.messager.alert("温馨提示",result.msg,'icon-smile',function(){
									lossStudent_dialog.dialog('close');
									lossStudent_datagrid.datagrid("reload");
								});
							}else{
								$.messager.alert("温馨提示",result.msg,'icon-warning',function(){

								});
							}
						}
					});
				},
				edit:function (){
					var record =lossStudent_datagrid.datagrid("getSelected");
					if (record) {
						lossStudent_dialog.dialog("open");
						lossStudent_dialog.dialog("setTitle","学员编辑");
						lossStudent_form.form("clear");
						//编辑时,给属性传递参数
						if(record.currentclass!=null){
							record['currentclass.id']=record.currentclass.id;
						}
						if(record.marketingman!=null){
							record['marketingman.id']=record.marketingman.id;
						}
						if(record.handlerperson!=null){
							record['handlerperson.id']=record.handlerperson.id;
						}
						if(record.inputman!=null){
							record['inputman.id']=record.inputman.id;
						}
						if(record.studentstate!=null){
							record['studentstate.id']=record.studentstate.id;
						}
						lossStudent_form.form("load",record);

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				reload:function(){
					lossStudent_datagrid.datagrid("reload");
				},
				del:function(){
					var record =lossStudent_datagrid.datagrid("getSelected");
					if (record) {
						$.messager.confirm("温馨提示","亲,确定要删除该信息吗?",function(yes){
							if(yes){
								$.get("/lossStudent_deleteByPrimaryKey?id="+record.id,function(result){
									if(result.success){
										$.messager.alert("温馨提示",result.msg,'info',function(){
											alert("删除成功");
											lossStudent_datagrid.datagrid("reload");
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
				lossStudentSearch:function () {
					var keyword = $("[name='keyword']").val();
					$("#lossStudent_datagrid").datagrid("load", {
						keyword: keyword
					});
				},
				//快速查询
				fastSearch:function () {
					var keyword = $("#searchClass").val();
					$("#lossStudent_datagrid").datagrid("load", {
						keyword: keyword
					});
				},
				//查看按钮
				view:function (){
					var record =lossStudent_datagrid.datagrid("getSelected");
					if (record) {
						lossStudent_dialogView.dialog("open");
						lossStudent_dialogView.dialog("setTitle","查看学员");
						lossStudent_formView.form("clear");
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
						lossStudent_formView.form("load",record);

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				cancelView:function (){
					lossStudent_dialogView.dialog('close');
				},


		};
		$("[data-cmd]").on("click",function(){
			var cmd =$(this).data("cmd");
			cmdObj[cmd]();
		});
	
});
	function currentclassFormatter(value,row,index){
		return value?value.name:'';
	}
	function handlerpersonFormatter(value,row,index){
		return value?value.username:'';
	}
	function marketingmanFormatter(value,row,index){
		return value?value.username:'';
	}
	function inputmanFormatter(value,row,index){
		return value?value.username:'';
	}
	function studentstateFormatter(value,row,index){
		return "流失学员";
	}
	function refundmentFormatter(value,row,index){
		console.log(value);
		return value==1?'是':'否';
	}

