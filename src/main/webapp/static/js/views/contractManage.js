$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var contractManageDatagrid,contractManageDialog,contractManageForm,selfAuditBtn,selfdeptAuditBtn,selfdeptAuditeditBtn,selfdeptAuditeditfeiBtn;
	contractManageDatagrid = $("#contractManage_datagrid");
	contractManageDialog = $("#contractManage_dialog");
	contractManageForm = $("#contractManage_form");
	 selfAuditBtn = $("#selfAuditBtn");
	 selfdeptAuditBtn = $("#selfAuditBtn ,#deptAuditBtn");
	 selfdeptAuditeditBtn = $("#selfAuditBtn ,#deptAuditBtn, #moneyAuditBtn ,#editBtn");
	 selfdeptAuditeditfeiBtn = $("#selfAuditBtn ,#deptAuditBtn, #moneyAuditBtn ,#feiAuditBtn,#editBtn");

	/*
	 * 初始化数据表格 
	 */
	contractManageDatagrid.datagrid({
		url:"/contractManage/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#contractManage_datagrid_tb',
        columns:[
            [
    		{field:'contractSn',align:'center',width:10,title:'合同编号'},
    		{field:'client',align:'center',width:10,title:'合同客户',formatter:clientFormatter},
    		{field:'signTime',align:'center',width:10,title:'签到合同时间'},
    		{field:'saleMan',align:'center',width:10,title:'销售人员',formatter:saleManFormatter},
    		{field:'totalAmount',align:'center',width:10,title:'总金额'},
    		{field:'orderAmount',align:'center',width:10,title:'签到合同金额'},
    		{field:'accessory',align:'center',width:10,title:'合同附件'},
    		{field:'recentUpdateMan',align:'center',width:10,title:'最近修改人',formatter:recentUpdateManFormatter},
    		{field:'recentUpdateTime',align:'center',width:10,title:'最近修改时间'},
    		{field:'state',align:'center',width:10,title:'合同状态',formatter:stateFormatter},
    		{field:'mark',align:'center',width:10,title:'备注'},
            ]
        ],
		onClickRow:function (rowIndex,rowData) {
            console.log(rowData);
            if(rowData.state==1){
                selfAuditBtn.linkbutton("disable");
                $(" #deptAuditBtn,#moneyAuditBtn ,#feiAuditBtn,#editBtn").linkbutton("enable");
			}else if(rowData.state==2){
                $("#selfAuditBtn ,#deptAuditBtn").linkbutton("disable");
                $(" #moneyAuditBtn ,#feiAuditBtn,#editBtn").linkbutton("enable");
            }
			else if(rowData.state==3||rowData.state==4){//完成 废单按钮
                selfdeptAuditeditfeiBtn.linkbutton("disable");
            }
			else {
                selfdeptAuditeditfeiBtn.linkbutton("enable");
			}
        }

	});


    $("#searchBtn").linkbutton({
        text:'快速查询',
        iconCls:'icon-select',
        onClick:function(){
            var state = $("#bill_state").combobox("getValue");
            var beginDate = $("[name='qo.beginDate']").val();
            var endDate = $("[name='qo.endDate']").val();
            var keyword = $("[name='keyword']").val();
            console.log(beginDate,endDate);

            contractManageDatagrid.datagrid("load",{
                "state":state,
                "beginDate":beginDate,
                "endDate":endDate,
                "keyword":keyword

            });
        }
    });
    function stateFormatter(value,record,index){
        if(value==0){return "<font color='black'>合同初步形成</font>";}
        else if(value==1){return "<font color='#90ee90'>等待部门审核</font>";}
        else if(value==2){return "<font color='green'>等待财务审核</font>";}
        else if(value==3){return "合同已完成 ";}
        else if(value==4){return "<font color='red'>废单</font>";}

    }

    function clientFormatter(value,record,index){
        if(value){
            return value.name;
        }
        return value;
    }
    function recentUpdateManFormatter(value,record,index){
        if(value){
            return value.realname;
        }
        return value;
    }

    function saleManFormatter(value,record,index){
        if(value){
            return value.realname;
        }
        return value;
    }

    $("#contractManage_client").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/potentialCustom/selectAll"
    });
	/*
	 * 初始化新增/编辑对话框 
	 */
	contractManageDialog.dialog({
		width:350,
		height:380,
		closed:true,
		buttons:'#contractManage_dialog_bt'
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
				contractManageForm.form("clear");
				contractManageDialog.dialog("setTitle","新增");
				contractManageDialog.dialog("open");
			},
			edit:function(){
				var rowData = contractManageDatagrid.datagrid("getSelected");
				if(rowData){
					contractManageForm.form("clear");
					contractManageDialog.dialog("setTitle","编辑");
					contractManageDialog.dialog("open");
					if(rowData.client){
                        rowData["client.id"] = rowData.client.id;
					}

					contractManageForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = contractManageDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/contractManage/delete?contractManageId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										contractManageDatagrid.datagrid("reload");
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
        selfAudit:function(){
            var rowData = contractManageDatagrid.datagrid("getSelected");

                if(rowData){
                    $.messager.confirm("温馨提示","您确定需要审核吗？",function(yes){
                        console.log(rowData);
                        if(yes){
                            $.get("/contractManage/selfAudit?contractManageId="+rowData.id,function(data){
                                if(data.success){
                                    $.messager.alert("温馨提示",data.msg,"info",function(){
                                        contractManageDatagrid.datagrid("reload");
                                    });
                                }else{
                                    $.messager.alert("温馨提示",data.msg,"error");
                                }
                            },"json")
                        }
                    });
                }else{
                    $.messager.alert("温馨提示","请选择需要审核的数据!","warining");
                }
        },
        feiAudit:function(){
            var rowData = contractManageDatagrid.datagrid("getSelected");

                if(rowData){
                    $.messager.confirm("温馨提示","确定需要处理成废单吗？",function(yes){
                        console.log(rowData);
                        if(yes){
                            $.get("/contractManage/feiAudit?contractManageId="+rowData.id,function(data){
                                if(data.success){
                                    $.messager.alert("温馨提示",data.msg,"info",function(){
                                        contractManageDatagrid.datagrid("reload");
                                    });
                                }else{
                                    $.messager.alert("温馨提示",data.msg,"error");
                                }
                            },"json")
                        }
                    });
                }else{
                    $.messager.alert("温馨提示","请选择需要处理成废单的数据!","warining");
                }
        },
        deptAudit:function(){
				var rowData = contractManageDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要审核吗？",function(yes){
						if(yes){
								if(rowData.state==0){
									$.messager.alert("温馨提示","亲,员工审核之后才可以部门审核哦!","warining");
								}else if(rowData.state==1) {
									$.get("/contractManage/deptAudit?contractManageId=" + rowData.id, function (data) {
										if (data.success) {
											$.messager.alert("温馨提示", data.msg, "info", function () {
												contractManageDatagrid.datagrid("reload");
											});
										} else {
											$.messager.alert("温馨提示", data.msg, "error");
										}
									}, "json")
								}else {
                                    $.messager.alert("温馨提示","亲,您已经无法审核了!","warining");
								}
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要审核的数据!","warining");
				}
			},
        moneyAudit:function(){
				var rowData = contractManageDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要审核吗？",function(yes){
						if(yes){
								if(rowData.state==1||rowData.state==0){
									$.messager.alert("温馨提示","亲,部门审核之后才可以财务审核哦!","warining");
								}else if(rowData.state==2) {
									$.get("/contractManage/moneyAudit?contractManageId=" + rowData.id, function (data) {
										if (data.success) {
											$.messager.alert("温馨提示", data.msg, "info", function () {
												contractManageDatagrid.datagrid("reload");
											});
										} else {
											$.messager.alert("温馨提示", data.msg, "error");
										}
									}, "json")
								}else {
                                    $.messager.alert("温馨提示","亲,您已经无法审核了!","warining");
								}
						}
					});
				}else{
					$.messager.alert("温馨提示","请选择需要审核的数据!","warining");
				}
			},

        openbtn:function () {
            var rowData = contractManageDatagrid.datagrid("getSelected");
            if(rowData.accessory){
              open(rowData.accessory);
            }

        },

			reload:function(){
				contractManageDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/contractManage/update"
				}else{
					url = "/contractManage/save";
				}
				contractManageForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								contractManageDialog.dialog("close");
								contractManageDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				contractManageDialog.dialog("close");
			}
	}
});
