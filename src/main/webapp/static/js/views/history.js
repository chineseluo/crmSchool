$(function() {
	var history_datagrid = $("#history_datagrid");
	var history_dialog = $("#history_dialog");
	var history_dialogOfQuery = $("#history_dialogOfQuery");
	var history_dialogOflistall = $("#history_dialogOflistall");
	var history_form = $("#history_form");
	var history_superQueryForm = $("#history_superQueryForm");
	var history_listallform = $("#history_listallform");
	var data =0;//用于显示全部或者隐藏部分
//=============================================数据表格===================================================================== 

	history_datagrid.datagrid({
		url : "/history/list",
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		fit : true,
		fitColumns : true,
		toolbar : '#history_toolbar',
		striped : true,
		columns : [ [ 
		              {field : 'id',title : 'ID',width : 100}, 
		              {field : 'client',title : '客户名称',width : 100,formatter :clientFormatter},
		              {field : 'date',title : '移交日期',width : 100}, 
		              {field : 'reason',title : '移交原因',width : 100}, 
		              {field : 'before',	title : '原拥有人',width : 100,formatter : beforeFormatter}, 
		              {field : 'after',	title : '移交目标',	width : 100,formatter : afterFormatter}
		              ] ]
			});


//=============================================高级查询的弹窗====================================================================== 
	
	history_dialogOfQuery.dialog({
		closable : true,
		width : 'auto',
		height : 'auto',
		buttons : '#history_dialogOfQuery_buttons',
		closed : true
	});
	
	
	var cmdObj = {
// ===================================================新增按钮=============================================================
		add : function() {
			history_dialog.dialog('open');
			history_dialog.dialog("setTitle", '新增');
			history_form.form("clear");

		},
//=================================================== 取消按钮==============================================================
		cancel : function() {
			history_dialog.dialog('close');
			history_dialogOfQuery.dialog('close');
		},
//=================================================== 保存按钮==============================================================
		save : function() {
			//必填项验证
			var validate_name = $("#validate_name").val();
			var validate_school = $("#validate_school").val();
			var validate_position = $("#validate_position").val();
			if(!validate_name){
				$.messager.alert("温馨提示", "请填写必填项", 'warning')
				return;
			}
			if(!validate_school){
				$.messager.alert("温馨提示", "请填写必填项", 'warning')
				return;
			}
			if(!validate_position){
				$.messager.alert("温馨提示", "请填写必填项", 'warning')
				return;
			}
			// 判断是否有id,如有就更新数据
			var id = $("[name='id']").val();
			var url;
			if (id) {
				url = "/history_update";
			} else {
				url = '/history_save';
			}
			history_form.form("submit", {
				url : url,
				onSubmit : function(param) {

				},
				success : function(result) {
					result = $.parseJSON(result);
					if (result.success) {
						$.messager.alert("温馨提示", result.msg, 'info',
								function() {
									history_dialog.dialog('close');
									history_datagrid.datagrid("reload");
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
			var record = history_datagrid.datagrid("getSelected");
			
			if (record) {
				var html = $.ajax({
					url : "/history_selectById?id="+record.id,
					async : false
				}).responseText;
				html = $.parseJSON(html);
				history_dialog.dialog("open");
				history_dialog.dialog("setTitle", "联系人编辑");
				history_form.form("clear");
				// 处理学校数据
				if (record.school) {
					html["school.id"] = record.school.id;
				}
				history_form.form("load", html);

			} else {
				$.messager.alert('温馨提示', '请选择要编辑的数据', 'warning');
			}
		},
//========================================================= 刷新==========================================================
		reload : function() {
			history_datagrid.datagrid("load",{});
		},
		
		
//========================================================= 删除===========================================================
		del : function() {
			var record = history_datagrid.datagrid("getSelected");
			if (record) {
				$.messager.confirm("温馨提示","亲,确定要删除该数据吗?",function(yes) {
						if (yes) {$.get("/history_delete?id="+ record.id,function(result) {
								if (result.success) 
									{$.messager.alert("温馨提示",result.msg,'info',function() {
											history_datagrid.datagrid("reload");});
								} else {$.messager.alert("温馨提示",result.msg,'warning');
								}
								});
							}
						});
			} else {
				$.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
			}
		},
//=================================================== 显示全部============================================================
		showAll : function() {
			if(data==0){
				history_datagrid.datagrid('showColumn','college');
				history_datagrid.datagrid('showColumn','sex');
				history_datagrid.datagrid('showColumn','address');
				history_datagrid.datagrid('fixColumnSize');
				data=1;
			}else{
				history_datagrid.datagrid('hideColumn','college');
				history_datagrid.datagrid('hideColumn','sex');
				history_datagrid.datagrid('hideColumn','address');
				history_datagrid.datagrid('fixColumnSize');
				data=0;
			}
		},
//=====================================================高级查询=============================================================
		superQuery:function(){
			history_dialogOfQuery.dialog('open');
			history_dialogOfQuery.dialog("setTitle", '高级查询');
			history_dialogOfQuery.form("clear");
		},
//=====================================================查看查询=============================================================
		observe:function(){
			var record = history_datagrid.datagrid("getSelected");
			if (record) {
				var html = $.ajax({
					url : "/history_selectById?id="+record.id,
					async : false
				}).responseText;
				html = $.parseJSON(html);
				history_dialogOflistall.dialog("open");
				history_dialogOflistall.dialog("setTitle", "查看详细信息");
				history_listallform.form("clear");
				// 处理学校数据
				if (record.school) {
					html["schoolName"] = record.school.name;
				}
				if(html.state==true){
					html.state='是';
				}else{
					html.state='否';
				}
				history_listallform.form("load", html);

			} else {
				$.messager.alert('温馨提示', '请选择要查看的数据', 'warning');
			}
		},
//=====================================================查询按钮=============================================================
		supersearch:function(){
			 var name = $("#name_query").val();
			 var begindate = $("#begindate_query").val();
			 var enddate = $("#enddate_query").val();
			 var beforeId = $("#before_query").val();
			 var afterId = $("#after_query").val();
			 history_dialogOfQuery.dialog('close');
			history_datagrid.datagrid("load", {
				    "name": name,
				    "begindate": begindate,
				    "enddate": enddate,
				    "beforeId": beforeId,
				    "afterId": afterId
			});
		}

	};
	$("[data-cmd]").on("click", function() {
		var cmd = $(this).data("cmd");
		cmdObj[cmd]();
	});

});
function beforeFormatter(value, row, index) {
	return value ? value.username : '';
}
function afterFormatter(value, row, index) {
	return value ? value.username : '';
}
function clientFormatter(value, row, index) {
    if (row != null && row.client != null) {
	    return  row.client.name ;
    }
    return "";
}

function doSearch(value) {
	 var keyword =value;
	 $("#history_datagrid").datagrid("load", {
		 "keyword":keyword
	 });
}
