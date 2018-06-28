$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var orderBillDatagrid,orderBillDialog,orderBillForm,selfAuditBtn,selfdeptAuditBtn,selfdeptAuditeditBtn,selfdeptAuditeditfeiBtn;
	orderBillDatagrid = $("#orderBill_datagrid");
	orderBillDialog = $("#orderBill_dialog");
	orderBillForm = $("#orderBill_form");
	 selfAuditBtn = $("#selfAuditBtn");
	 selfdeptAuditBtn = $("#selfAuditBtn ,#deptAuditBtn");
	 selfdeptAuditeditBtn = $("#selfAuditBtn ,#deptAuditBtn, #moneyAuditBtn ,#editBtn");
	 selfdeptAuditeditfeiBtn = $("#selfAuditBtn ,#deptAuditBtn, #moneyAuditBtn ,#feiAuditBtn,#editBtn");

	/*
	 * 初始化数据表格 
	 */
	orderBillDatagrid.datagrid({
		url:"/orderBill/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		pagination:true,
		fitColumns:true,
		toolbar:'#orderBill_datagrid_tb',
        columns:[
            [
    		{field:'client',align:'center',width:10,title:'订单客户',formatter:clientFormatter},
    		{field:'signTime',align:'center',width:10,title:'订单时间'},
    		{field:'saleMan',align:'center',width:10,title:'销售人员',formatter:saleManFormatter},
    		{field:'totalAmount',align:'center',width:10,title:'总金额'},
    		{field:'orderAmount',align:'center',width:10,title:'订单金额'},
    		{field:'accessory',align:'center',width:10,title:'订单附件'},
    		{field:'recentUpdateMan',align:'center',width:10,title:'最近修改人',formatter:recentUpdateManFormatter},
    		{field:'recentUpdateTime',align:'center',width:10,title:'最近修改时间'},
    		{field:'state',align:'center',width:10,title:'订单状态',formatter:stateFormatter},
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

            orderBillDatagrid.datagrid("load",{
                "state":state,
                "beginDate":beginDate,
                "endDate":endDate,
                "keyword":keyword

            });
        }
    });
    function stateFormatter(value,record,index){
        if(value==0){return "<font color='black'>生成订单</font>";}
        else if(value==1){return "<font color='#90ee90'>等待部门审核</font>";}
        else if(value==2){return "<font color='green'>等待财务审核</font>";}
        else if(value==3){return "订单合同已完成 ";}
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

    $("#orderBill_client").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/potentialCustom/selectAll"
    });
	/*
	 * 初始化新增/编辑对话框 
	 */
	orderBillDialog.dialog({
		width:350,
		height:380,
		closed:true,
		buttons:'#orderBill_dialog_bt'
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
				orderBillForm.form("clear");
				orderBillDialog.dialog("setTitle","新增");
				orderBillDialog.dialog("open");
			},
			edit:function(){
				var rowData = orderBillDatagrid.datagrid("getSelected");
				if(rowData){
					orderBillForm.form("clear");
					orderBillDialog.dialog("setTitle","编辑");
					orderBillDialog.dialog("open");
					if(rowData.client){
                        rowData["client.id"] = rowData.client.id;
					}

					orderBillForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = orderBillDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/orderBill/delete?orderBillId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										orderBillDatagrid.datagrid("reload");
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
            var rowData = orderBillDatagrid.datagrid("getSelected");

                if(rowData){
                    $.messager.confirm("温馨提示","您确定需要审核吗？",function(yes){
                        console.log(rowData);
                        if(yes){
                            $.get("/orderBill/selfAudit?orderBillId="+rowData.id,function(data){
                                if(data.success){
                                    $.messager.alert("温馨提示",data.msg,"info",function(){
                                        orderBillDatagrid.datagrid("reload");
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
            var rowData = orderBillDatagrid.datagrid("getSelected");

                if(rowData){
                    $.messager.confirm("温馨提示","确定需要处理成废单吗？",function(yes){
                        console.log(rowData);
                        if(yes){
                            $.get("/orderBill/feiAudit?orderBillId="+rowData.id,function(data){
                                if(data.success){
                                    $.messager.alert("温馨提示",data.msg,"info",function(){
                                        orderBillDatagrid.datagrid("reload");
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
				var rowData = orderBillDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要审核吗？",function(yes){
						if(yes){
								if(rowData.state==0){
									$.messager.alert("温馨提示","亲,员工审核之后才可以部门审核哦!","warining");
								}else if(rowData.state==1) {
									$.get("/orderBill/deptAudit?orderBillId=" + rowData.id, function (data) {
										if (data.success) {
											$.messager.alert("温馨提示", data.msg, "info", function () {
												orderBillDatagrid.datagrid("reload");
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
				var rowData = orderBillDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要审核吗？",function(yes){
						if(yes){
								if(rowData.state==1||rowData.state==0){
									$.messager.alert("温馨提示","亲,部门审核之后才可以财务审核哦!","warining");
								}else if(rowData.state==2) {
									$.get("/orderBill/moneyAudit?orderBillId=" + rowData.id, function (data) {
										if (data.success) {
											$.messager.alert("温馨提示", data.msg, "info", function () {
												orderBillDatagrid.datagrid("reload");
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
			var rowData = orderBillDatagrid.datagrid("getSelected");
            if(rowData.accessory){
            	open(rowData.accessory);
			}

        },
			reload:function(){
				orderBillDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/orderBill/update"
				}else{
					url = "/orderBill/save";
				}
				orderBillForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								orderBillDialog.dialog("close");
								orderBillDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				orderBillDialog.dialog("close");
			}
	}
});
