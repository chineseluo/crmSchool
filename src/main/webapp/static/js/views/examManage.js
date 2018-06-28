$(function() {
	var exammanage_datagrid = $("#exammanage_datagrid");
	var exammanage_dialog = $("#exammanage_dialog");
	var exammanage_resultdialog = $("#exammanage_resultdialog");//登记考试结果弹窗
	var exammanage_dialogOfQuery = $("#exammanage_dialogOfQuery");
	var exammanage_dialogOflistall = $("#exammanage_dialogOflistall");
	var exammanage_form = $("#exammanage_form");
	var exammanage_resultform = $("#exammanage_resultform");//登记考试结果表单
	var exammanage_superQueryForm = $("#exammanage_superQueryForm");
	var exammanage_listallform = $("#exammanage_listallform");
	var data =0;//用于显示全部或者隐藏部分
//=============================================数据表格===================================================================== 

	exammanage_datagrid.datagrid({
		url : "/examManage/list",
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		fit : true,
		fitColumns : true,
		toolbar : '#exammanage_toolbar',
		striped : true,
		columns : [ [ 
		              {field : 'id',title : 'ID',width : 100}, 
		              {field : 'name',title : '考试名称',width : 100},
		              {field : 'sn',title : '考试编号',width : 100}, 
		              {field : '1',title : '学生姓名',width : 100,
                          formatter: function (value, row, index) {
		                        if(row.student != null){
                                    return row ? row.student.name : "";
                                }
                          }
                      },
		              {field : '2',title : '营销人员',width : 100,
                          formatter: function (value, row, index) {
                              if ( row != null && row.student != null
                                && row.student.marketingMan != null
                                  && row.student.marketingMan.username != null
                              ) {
                                return row.student.marketingMan.username;
                              }
                            return "";
                          }
                      },
		              {field : '3',	title : 'QQ',width : 100,
                          formatter: function (value, row, index) {
                              if ( row != null && row.student != null
                                  && row.student.qq != null
                              ) {
                                  return row.student.qq;
                              }
                              return "";
                          }
                      },
		              {field : '4',	title : '电话',width : 100,
                          formatter: function (value, row, index) {
                              if ( row != null && row.student != null
                                  && row.student.telephone != null
                              ) {
                                  return row.student.telephone;
                              }
                              return "";
                          }
                      },
		              {field : '5',	title : '意向班级',width : 100,
                          formatter: function (value, row, index) {
                              if ( row != null && row.student != null
                                  && row.student.intentionClass != null
                                  && row.student.intentionClass.name != null
                              ) {
                                  return row.student.intentionClass.name;
                              }
                              return "";
                          }
                      },
		              {field : 'examtime',title : '考试时间',width : 100},
		              {field : 'examResult',title : '考试结果',width :100},
		              {field : 'examremark',title : '备注',width : 100},
		              {field : 'employee',title : '最后处理人',width : 100,
                          formatter: function (value, row, index) {
                              return value ? value.username : "";
                          }
                      }
		              ] ]
			});
//=============================================新增和编辑的弹窗====================================================================== 

	exammanage_dialog.dialog({
		closable : true,
		width : 'auto',
		height : 'auto',
		buttons : '#exammanage_dialog_buttons',
		closed : true
	});
//=============================================登记考试结果的弹窗====================================================================== 
	
	exammanage_resultdialog.dialog({
		closable : true,
		width : 'auto',
		height : 'auto',
		buttons : '#exammanage_resultdialog_buttons',
		closed : true
	});
//=============================================查看的弹窗====================================================================== 
	
	exammanage_dialogOflistall.dialog({
		closable : true,
		width : 700,
		height : "auto",
		closed : true
	});

	var cmdObj = {
// ===================================================新增按钮=============================================================
		add : function() {
			exammanage_dialog.dialog('open');
			exammanage_dialog.dialog("setTitle", '新增');
			exammanage_form.form("clear");

		},
//=================================================== 取消按钮==============================================================
		cancel : function() {
			exammanage_dialog.dialog('close');
			exammanage_dialogOfQuery.dialog('close');
			exammanage_resultdialog.dialog('close');
		},
//=================================================== 保存按钮==============================================================
		save : function() {
			//必填项验证
			var exam_name = $("#exam_name").val();
			var student_name = $("#student_name").val();
			if(!exam_name){
				$.messager.alert("温馨提示", "请填写必填项", 'warning')
				return;
			}
			if(!student_name){
				$.messager.alert("温馨提示", "请填写必填项", 'warning')
				return;
			}
			
			// 判断是否有id,如有就更新数据
			var id = $("[name='id']").val();
			var url;
			if (id) {
				url = "/exammanage_update";
			} else {
				url = '/exammanage_save';
			}
			exammanage_form.form("submit", {
				url : url,
				onSubmit : function(param) {

				},
				success : function(result) {
					result = $.parseJSON(result);
					if (result.success) {
						$.messager.alert("温馨提示", result.msg, 'info',
								function() {
									exammanage_dialog.dialog('close');
									exammanage_datagrid.datagrid("reload");
								});
					} else {
						$.messager.alert("温馨提示", result.msg, 'warning',
								function() {

								});
					}
				}
			});
		},
//======================================================== 编辑按钮=========================================================
		edit : function() {
			var record = exammanage_datagrid.datagrid("getSelected");
			
			if (record) {
				var html = $.ajax({
					url : "/exammanage_selectById?id="+record.id,
					async : false
				}).responseText;
				html = $.parseJSON(html);
				exammanage_dialog.dialog("open");
				exammanage_dialog.dialog("setTitle", "编辑");
				exammanage_form.form("clear");
				// 处理学校数据
				if (record.studentName) {
					html["student.id"] = html.student.id;
				}
				exammanage_form.form("load", html);

			} else {
				$.messager.alert('温馨提示', '请选择要编辑的数据', 'warning');
			}
		},
//========================================================= 刷新==========================================================
		reload : function() {
			exammanage_datagrid.datagrid("load",{});
		},
		
		
//========================================================= 删除===========================================================
		del : function() {
			var record = exammanage_datagrid.datagrid("getSelected");
			if (record) {
				$.messager.confirm("温馨提示","亲,确定要删除该数据吗?",function(yes) {
						if (yes) {$.get("/exammanage_delete?id="+ record.id,function(result) {
								if (result.success) 
									{$.messager.alert("温馨提示",result.msg,'info',function() {
											exammanage_datagrid.datagrid("reload");});
								} else {$.messager.alert("温馨提示",result.msg,'warning');
								}
								});
							}
						});
			} else {
				$.messager.alert("温馨提示", "请选择一条数据", 'warning');
			}
		},
//=================================================== 显示全部============================================================
		showAll : function() {
			if(data==0){
				exammanage_datagrid.datagrid('showColumn','college');
				exammanage_datagrid.datagrid('showColumn','sex');
				exammanage_datagrid.datagrid('showColumn','address');
				exammanage_datagrid.datagrid('fixColumnSize');
				data=1;
			}else{
				exammanage_datagrid.datagrid('hideColumn','college');
				exammanage_datagrid.datagrid('hideColumn','sex');
				exammanage_datagrid.datagrid('hideColumn','address');
				exammanage_datagrid.datagrid('fixColumnSize');
				data=0;
			}
		},

//=====================================================查看查询=============================================================
		observe:function(){
			var record = exammanage_datagrid.datagrid("getSelected");
			console.log(record)
			if (record) {
				
				exammanage_dialogOflistall.dialog("open");
				exammanage_dialogOflistall.dialog("setTitle", "查看详细信息");
				exammanage_listallform.form("clear");
				// 处理学校数据
				if (record.employee) {
					record["employee.name"] = record.employee.username;
				}
                if ( record.student != null
                    && record.student.marketingMan != null
                    && record.student.marketingMan.username != null
                ) {
                   record.studentMarket = record.student.marketingMan.username;
                }
                if ( record != null && record.name != null
                ) {
                   record.studentName = record.student.name;
                }

                if ( record != null && record.student != null
                    && record.student.qq != null
                ) {
                    return record.studentQQ = record.student.qq;
                }
                if ( record != null && record.student != null
                    && record.student.telephone != null
                ) {
                    record.studentTel = record.student.telephone ;
                }

                if ( record != null && record.student != null
                    && record.student.intentionClass != null
                    && record.student.intentionClass.name != null
                ) {
                   record.studentClass = record.student.intentionClass.name;
                }

				exammanage_listallform.form("load", record);

			} else {
				$.messager.alert('温馨提示', '请选择要查看的数据', 'warning');
			}
		},
//=====================================================查询按钮=============================================================
		supersearch:function(){
			 var name = $("#name_query").val();
			 var schoolId = $("#schoolId_query").val();
			 var tel = $("#tel_query").val();
			 var qq = $("#qq_query").val();
			 var email = $("#email_query").val();
			 var position = $("#position_query").val();
			 var college = $("#college_query").val();
			 var sex = $("#sex_query").val();
			 var state=$("input:checked").val();
			 exammanage_dialogOfQuery.dialog('close');
			exammanage_datagrid.datagrid("load", {
				    "name": name,
				    "schoolId": schoolId,
				    "tel": tel,
				    "qq": qq,
				    "email": email,
				    "position": position,
				    "college": college,
				    "sex": sex,
				    "state": state
			});
		},
//===============================================================================		
		updateResult:function(){
			var record = exammanage_datagrid.datagrid("getSelected");
			if (record) {
			exammanage_resultdialog.dialog('open');
			exammanage_resultdialog.dialog("setTitle", '登记考试结果');
			exammanage_resultform.form("clear");
			exammanage_resultform.form("load", record);
			}else{
				$.messager.alert("温馨提示", "请选择一条数据", 'warning');
			}
		},
		saveResult:function(){
			exammanage_resultform.form("submit", {
				url : '/examManage/updateResult',
				
				success : function(result) {
					result = $.parseJSON(result);
					if (result.success) {
						$.messager.alert("温馨提示", result.msg, 'info',
								function() {
							exammanage_resultdialog.dialog('close');
									exammanage_datagrid.datagrid("reload");
								});
					} else {
						$.messager.alert("温馨提示", result.msg, 'warning',
								function() {

								});
					}
				}
			});
		}
		
		
		

	};
	$("[data-cmd]").on("click", function() {
		var cmd = $(this).data("cmd");
		cmdObj[cmd]();
	});

});



function doSearch(value) {
	 var keyword =value;
	 $("#exammanage_datagrid").datagrid("load", {
		 "keyword":keyword
	 });
}
