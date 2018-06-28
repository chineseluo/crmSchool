$(function(){
	var potentialCustomPool_datagrid = $("#potentialCustomPool_datagrid");
	var potentialCustomPool_dialog = $("#potentialCustomPool_dialog");
	var potentialCustomPool_dialog_form = $("#potentialCustomPool_dialog_form");
	var potentialCustomPool_dialog_view = $("#potentialCustomPool_dialog_view");
	var potentialCustomPool_dialog_form_view = $("#potentialCustomPool_dialog_form_view");
	potentialCustomPool_datagrid.datagrid({
//		title:"潜在客户池",
		fit:true,
		fitColumns:true,
		url:"/potentialCustomPool/list?studentState=-1",
		rownumbers:true,
		pagination:true,
		checkOnSelect:false,
		singleSelect:true,
		selectOnCheck:false,
		toolbar:"#potentialCustomPool_datagrid_tb",
		columns:[[
		          {field:"name",title:"姓名",width:100,align:"center"},
		          {field:"marketingMan",title:"营销人员",width:100,align:"center",formatter:marketingManFormat},
// {field:"111",title:"跟踪次数",width:100,align:"center"},
// {field:"111",title:"最后跟踪时间",width:100,align:"center"},
		          {field:"currentState",title:"在做什么",width:100,align:"center",formatter:currentStateFormat},
		          {field:"qq",title:"QQ",width:100,align:"center"},
		          {field:"telephone",title:"电话",width:100,align:"center"},
		          {field:"gender",title:"性别",width:100,align:"center",formatter:genderFormat},
		          {field:"schoolOrTrainOrganization",title:"学校",width:100,align:"center"},
		          {field:"intentionLevel",title:"意向班级",width:100,align:"center",formatter:intentionclassFormat},
		          {field:"remark",title:"备注",width:100,align:"center"},
		          {field:"clientType",title:"客户类型",width:100,align:"center",formatter:clientTypeFormat},
		          {field:"studentstate",title:"状态",width:100,align:"center",formatter:studentstateFormat}
// ,{field:"111",title:"未跟踪",width:1,align:"center"}
		        ]]
	});
	potentialCustomPool_dialog.dialog({
		width:900,
		height:500,
		buttons:"#potentialCustomPool_dialog_bt",
		closed:true
	});
	potentialCustomPool_dialog_view.dialog({
		width:900,
		height:500,
		buttons:"#potentialCustomPool_dialog_bt_view",
		closed:true
	});
	$("#potentialCustomPool_dialog_remove").dialog({
		width:400,
		height:340,
		buttons:"#potentialCustomPool_dialog_bt_remove",
		closed:true
	});
	
	$("[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		cmdObj[cmd]();
	});
	
	var cmdObj = {
			add:function(){
				potentialCustomPool_dialog_form.form("clear");
				potentialCustomPool_dialog.dialog("open");
				potentialCustomPool_dialog.dialog("setTitle","新增");
			},
			save:function(){
				// 判断是否有id,如有就更新数据
			    var id = $("[name='id']").val();
			    console.log(id);
			    var url;
			    if (id) {
			        url = "/potentialCustomPool_update";
			    } else {
			        url = '/potentialCustomPool_save';
			    }
			    potentialCustomPool_dialog_form.form("submit", {
			            url: url,
			            success: function (result) {
			                result = $.parseJSON(result);
			                if (result.success) {
			                    $.messager.alert("温馨提示", result.msg, 'icon-smile', function () {
			                    	potentialCustomPool_dialog.dialog('close');
			                        potentialCustomPool_datagrid.datagrid("reload");
			                    });
			                } else {
			                    $.messager.alert("温馨提示", result.msg, 'icon-warning');
			                }
			            }
			    });
			},
			edit:function(){
				var rowData = potentialCustomPool_datagrid.datagrid("getSelected");
				console.log(rowData);
				if(rowData){
					potentialCustomPool_dialog.dialog("open");
					potentialCustomPool_dialog.dialog("setTitle","编辑");
					potentialCustomPool_dialog_form.form("clear");
					
					if(rowData.education){
						rowData['education.name'] = rowData.education.name;
					}
					if(rowData.workYear){
						rowData['workYear.name'] = rowData.workYear.name;
					}
					if(rowData.intentionSubject){
						rowData['intentionSubject.name'] = rowData.intentionSubject.name;
					}
					if(rowData.clientType){
						rowData['clientType.name'] = rowData.clientType.name;
					}
					if(rowData.marketingMan){
						rowData['marketingMan.name'] = rowData.marketingMan.name;
					}
					if(rowData.intentionSchoolRegion){
						rowData['intentionSchoolRegion.name'] = rowData.intentionSchoolRegion.name;
					}
					if(rowData.source){
						rowData['source.name'] = rowData.source.name;
					}
					if(rowData.currentState){
						rowData['currentState.name'] = rowData.currentState.name;
					}
					if(rowData.intentionclass){
						rowData['intentionclass.name'] = rowData.intentionclass.name;
					}
					if(rowData.othermarketingMan){
						rowData['othermarketingMan.name'] = rowData.othermarketingMan.name;
					}
					if(rowData.inputMan){
						rowData['inputMan.name'] = rowData.inputMan.name;
					}
					if(rowData.schoolClient){
						rowData['schoolClient.name'] = rowData.schoolClient.name;
					}
					if(rowData.region){
						rowData['region.name'] = rowData.region.name;
					}
					if(rowData.intentionLevel){
						rowData['intentionLevel.name'] = rowData.intentionLevel.name;
					}
					
					potentialCustomPool_dialog_form.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据","info");
				}
			},
			del:function(){
				var rowData = potentialCustomPool_datagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定要删除选中的数据吗?",function(r){
						if(r){
							$.get("/potentialCustom/delete?id="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										potentialCustomPool_datagrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"warning");
								}
							},'json');
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要删除的数据","info");
				}
			},
			view:function(){
				var rowData = potentialCustomPool_datagrid.datagrid("getSelected");
				if(rowData){
					potentialCustomPool_dialog_view.dialog("open");
					potentialCustomPool_dialog_view.dialog("setTitle","客户跟踪信息");
					potentialCustomPool_dialog_form_view.form("clear");
					
					if(rowData.education){
						rowData['education.name'] = rowData.education.name;
					}
					if(rowData.workYear){
						rowData['workYear.name'] = rowData.workYear.name;
					}
					if(rowData.intentionSubject){
						rowData['intentionSubject.name'] = rowData.intentionSubject.name;
					}
					if(rowData.clientType){
						rowData['clientType.name'] = rowData.clientType.name;
					}
					if(rowData.marketingMan){
						rowData['marketingMan.username'] = rowData.marketingMan.username;
					}
					if(rowData.intentionSchoolRegion){
						rowData['intentionSchoolRegion.name'] = rowData.intentionSchoolRegion.name;
					}
					if(rowData.source){
						rowData['source.name'] = rowData.source.name;
					}
					if(rowData.currentState){
						rowData['currentState.name'] = rowData.currentState.name;
					}
					if(rowData.intentionClass){
						rowData['intentionClass.name'] = rowData.intentionClass.name;
					}
					if(rowData.otherMarketingMan){
						rowData['otherMarketingMan.name'] = rowData.otherMarketingMan.username;
					}
					if(rowData.inputMan){
						rowData['inputMan.username'] = rowData.inputMan.username    ;
					}
					if(rowData.schoolClient){
						rowData['schoolClient.name'] = rowData.schoolClient.school;
					}
					if(rowData.region){
						rowData['region.name'] = rowData.region.name;
					}
					if(rowData.intentionLevel){
						rowData['intentionLevel.name'] = rowData.intentionLevel.name;
					}
					
					potentialCustomPool_dialog_form_view.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要查看的学员","info");
				}
			},
			remove:function(){
				var rowData = potentialCustomPool_datagrid.datagrid("getSelected");
				console.log(rowData);
				if(rowData){
                    if(rowData.marketingMan) {
                        rowData['marketingMan.id'] = rowData.marketingMan.id;
                    }
					$("#potentialCustomPool_dialog_remove").dialog("open");
					$("#potentialCustomPool_dialog_remove").dialog("setTitle","移交");
					$("#potentialCustomPool_dialog_form_remove").form("clear");
					$("#potentialCustomPool_dialog_form_remove").form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要移交的学员","info");
				}	
			},
			removePotentialClientPool:function(){
				$("#potentialCustomPool_dialog_form_remove").form("submit", {
		            url: "/potentialCustomPool/removePotentialCustomPool",
		            onSubmit:function (param) {
                        param['before.id'] = $("#before_id").val();
                        param['client.name'] = $("#client_name").val();
                        param['client.id'] = $("#client_id").val();
                    },
		            success: function (result) {
		                result = $.parseJSON(result);
		                if (result.success) {
		                    $.messager.alert("温馨提示", result.msg, 'icon-smile', function () {
		                    	$("#potentialCustomPool_dialog_remove").dialog("close");
		                        potentialCustomPool_datagrid.datagrid("reload");
		                    });
		                } else {
		                    $.messager.alert("温馨提示", result.msg, 'icon-warning');
		                }
		            }
				});
			},
			restore:function(){
				var rowData = potentialCustomPool_datagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定要还原选中的数据吗?",function(r){
						if(r){
							$.get("/potentialCustom/changeStudentState?id="+rowData.id+"&studentState=0",function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										potentialCustomPool_datagrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"warning");
								}
							},'json');
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要还原的数据","info");
				}
			},
			//导出客户池中的学员
			exportStudent:function(){
//				console.log($("#query").searchbox("getValue"));
				window.location.href="/potentialCustomPool_export?keyword="+$("#keywordquery").searchbox("getValue");
			},
			//查询所有
			queryAll:function(){
				$("#keywordquery").searchbox("setValue",'');
				var url = '/potentialCustomPool_list';
	            var options = potentialCustomPool_datagrid.datagrid('options');
	            options.url = url;
	            options.queryParams = {
	            		keyword:''
	            };
	            potentialCustomPool_datagrid.datagrid('load');
			},
			reset:function(){
				potentialCustomPool_dialog_form.form("clear");
			},
			cancel:function(){
				potentialCustomPool_dialog.dialog("close");
				$("#potentialCustomPool_dialog_remove").dialog("close");
			},
			reload:function(){
				potentialCustomPool_datagrid.datagrid("reload");
			},
			ok:function(){
				potentialCustomPool_dialog_view.dialog("close");
			}
	};
	//显示营销人员
	function marketingManFormat(value,row,index){
		if(value){
			return value.realname;
		}
		return value;
	}
	//显示性别
	function genderFormat(value,row,index){
//		console.log(value);
		if(value==0){
			return '男';
		}else if(value==1){
			return '女';
		}else{
			return '其他';
		}
	}
	//显示意向班级
	function intentionclassFormat(value,row,index){
		if(value){
			return value.name;
		}
		return value;
	}
	//显示客户类型
	function clientTypeFormat(value,row,index){
		if(value){
			return value.name;
		}
		return value;
	}
	//显示当前状态
	function currentStateFormat(value,row,index){
		if(value){
			return value.name;
		}
		return value;
	}
	//显示状态
	function studentstateFormat(value,row,index){
//		console.log(value);
		if(value){
			return value.name;
		}
		return value; 
	}
});
	//搜索
	function keyword_query(value,name){
	//	console.log(value,name);
		//高级查询
		$("#potentialCustomPool_datagrid").datagrid("load",{"keyword":value});
	}