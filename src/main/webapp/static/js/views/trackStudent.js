$(function(){
	var trackstudent_datagrid=$("#trackstudent_datagrid");
	var trackstudent_dialog=$("#trackstudent_dialog");
	var trackstudent_form=$("#trackstudent_form");

	var trackstudent_dialogView=$("#trackstudent_dialogView");
	var trackstudent_formView=$("#trackstudent_formView");
    var show_photo = $("#show_photo");

	trackstudent_datagrid.datagrid({
		url:"/trackStudent/list",
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		fit:true,
	    fitColumns:true,
		toolbar:'#trackstudent_toolbar',
		striped:true,
		columns:[[
							{field:"trackTime",title:"时间",width:100,align:"center"},
							{field:"student",title:"客户",width:100,align:"center",formatter:studentFormatter},
							{field:"marketingman",title:"咨询人员",width:100,align:"center",formatter:marketingmanFormatter},
							{field:"nextVisitTime",title:"下次访问时间",width:100,align:"center"},
						    {field:"trackAim",title:"跟进目的",width:100,align:"center"},
							{field:"intentionleve",title:"意向程度",width:100,align:"center",formatter:intentionlevelFormatter},
                            {field:"qq",title:"QQ",width:100,align:"center",formatter:QQFormatter},
							{field:"telephone",title:"联系电话",width:100,align:"center",formatter:telephoneFormatter},
							{field:"consulttype",title:"咨询方式",width:100,align:"center",formatter:consulttypeFormatter},
							{field:"summary",title:"摘要",width:100,align:"center"},
		          ]],
					onClickRow: function (rowindex, rowdata) {
                        console.log(rowdata.fileAddress);
                        show_photo.dialog("open");
                        show_photo.dialog("setTitle","聊天记录显示");
                        $("#show_photo_img").prop("src",rowdata.fileAddress);
                    }

	});
		trackstudent_dialog.dialog({
			closable:true,
			width:880,
			height:550,
			buttons:'#trackstudent_dialog_buttons',
			closed:true
		});
    show_photo.dialog({
			closable:true,
            fit:true,
			closed:true
		});
		//查看
		trackstudent_dialogView.dialog({
			closable : true,
			width : 880,
			height : 550,
			buttons:'#trackstudent_dialog_buttonsView',
			closed : true
		});
		var cmdObj={
				add:function(){
					trackstudent_dialog.dialog('open');
					trackstudent_dialog.dialog("setTitle",'新增学员');
					trackstudent_form.form("clear");

				},
				cancel:function (){
					trackstudent_dialog.dialog('close');
				},
				save:function (){
					//判断是否有id,如有就更新数据
					var id =$("[name='id']").val();
					var url;
					if (id) {
						url="/trackStudent/update";
					}else{
						url='/trackstudent_save';
					}
					trackstudent_form.form("submit",{
						url:url,
						success:function(result){
							result=$.parseJSON(result);
							if(result.success){
								$.messager.alert("温馨提示",result.msg,'icon-smile',function(){
									trackstudent_dialog.dialog('close');
									trackstudent_datagrid.datagrid("reload");
								});
							}else{
								$.messager.alert("温馨提示",result.msg,'icon-warning',function(){
								});
							}
						}
					});
				},
				edit:function (){
					var record =trackstudent_datagrid.datagrid("getSelected");
					if (record) {

						trackstudent_dialog.dialog("setTitle","学员编辑");
						trackstudent_form.form("clear");
						//编辑时,给属性传递参数
						if(record.consultType!=null){
							record['consultType.id']=record.consultType.id;
						}
						if(record.student!=null ){
							record['student.name']=record.student.name;
						}
						if(record.student!=null ){
							record['student.id']=record.student.id;
						}

						if(record.school!=null){
							record['school.id']=record.school.id;
						}
						if(record.student!=null){
							record['student.qq']=record.student.qq;
						}
						if(record.student!=null){
							record['student.telephone']=record.student.telephone;
						}
						if(record.student != null && record.student.marketingMan!=null){
							record['marketingMan.name']=record.student.marketingMan.username;
						}
						if(record.student !=null && record.student.currentState != null){
							record['student.currentState.id']=record.student.currentState.id;
						}
						if(record.student != null && record.student.intentionLevel != null){
							record['student.intentionLevel.id']=record.student.intentionLevel.id;
						}
						if(record.student!=null && record.student.intentionClass != null){
							record['student.intentionClass.id']=record.student.intentionClass.id;
						}

						trackstudent_form.form("load",record);
                        trackstudent_dialog.dialog("open");

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				reload:function(){
					trackstudent_datagrid.datagrid("reload");
				},
				del:function(){
					var record =trackstudent_datagrid.datagrid("getSelected");
					if (record) {
						$.messager.confirm("温馨提示","亲,确定要删除该信息吗?",function(yes){
							if(yes){
								$.get("/trackStudent/delete?id="+record.id,function(result){
									if(result.success){
										$.messager.alert("温馨提示",result.msg,'info',function(){
											trackstudent_datagrid.datagrid("reload");
										});
									}else{
										$.messager.alert("温馨提示",result.msg,'warning');
									}
								});
							}
						});

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				//高级查询按钮
				formalSearch:function () {
					var keyword = $("[name='keyword']").val();
					$("#trackstudent_datagrid").datagrid("load", {
						keyword: keyword
					});
				},
				//查看按钮
				view:function (){
					var record =trackstudent_datagrid.datagrid("getSelected");
					if (record) {
						trackstudent_dialogView.dialog("open");
						trackstudent_dialogView.dialog("setTitle","查看学员");
						trackstudent_formView.form("clear");
						//编辑时,给属性传递参数
						if(record.talktype!=null){
							record['talktype.id']=record.talktype.id;
						}
						if(record.student.marketingman!=null){
							record['marketingman.id']=record.student.marketingman.id;
						}
						if(record.student!=null){
							record['student.id']=record.student.id;
						}
						if(record.school!=null){
							record['school.id']=record.school.id;
						}
						if(record.schoollinkman!=null){
							record['schoollinkman.id']=record.schoollinkman.id;
						}
						if(record.currentstate!=null){
							record['currentstate.id']=record.student.currentstate.id;
						}
						if(record.intentionleve!=null){
							record['intentionleve.id']=record.student.intentionleve.id;
						}
						if(record.intentionclass!=null){
							record['intentionclass.id']=record.student.intentionclass.id;
						}
						record['telephone']=record.student.telephone;
						record['qq']=record.student.qq;
						trackstudent_formView.form("load",record);

					}else{
						$.messager.alert("温馨提示","请选择一条数据",'icon-warning');
					}
				},
				cancelView:function (){
				trackstudent_dialogView.dialog('close');
				}



		};
		$("[data-cmd]").on("click",function(){
			var cmd =$(this).data("cmd");
			cmdObj[cmd]();
		});

});
	function marketingmanFormatter(value,row,index){
		if(row.consultPerson !=null  ){
		return row?row.consultPerson.username:'';
		}
	}
	function intentionlevelFormatter(value,row,index){
		if(row.student !=null && row.student.intentionLevel!=null ){
		return row?row.student.intentionLevel.name:'';
		}
	}
	function QQFormatter(value,row,index){
        if(row.student !=null ) {

            return row ? row.student.qq : '';
        }
	}
	function telephoneFormatter(value,row,index){
	    if (row.student != null ){
		    return row?row.student.telephone:'';

        }
	}
	function studentFormatter(value,row,index){
	    if(row.student != null){

		    return row?row.student.name:'';
        }
	}
	function consulttypeFormatter(value,row,index){
        if(row.consultType != null){
		    return row?row.consultType.name:'';

        }
	}
