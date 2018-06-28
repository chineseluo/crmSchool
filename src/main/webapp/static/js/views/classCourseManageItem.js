$(function(){
	/*
	 * 抽取所有需要用得元素.
	 */
	var classCourseManageItemDatagrid,classCourseManageItemDialog,classCourseManageItemForm,reload;
	classCourseManageItemDatagrid = $("#classCourseManageItem_datagrid");
	classCourseManageItemDialog = $("#classCourseManageItem_dialog");
	classCourseManageItemForm = $("#classCourseManageItem_form");

     reload = $("#reload");
	/*
	 * 初始化数据表格 
	 */
	classCourseManageItemDatagrid.datagrid({
		url:"/classCourseManageItem/list",
		fit:true,
		rownumbers:true,
		singleSelect:true,
		striped:true,
		//pagination:true,
		fitColumns:true,
		toolbar:'#classCourseManageItem_datagrid_tb',
        columns:[
            [
    		{field:'date',align:'center',width:10,title:'日期'},
    		{field:'weekday',align:'center',width:10,title:'周数',formatter:weekday},
    		{field:'classGrade',align:'center',width:10,title:'班级',formatter:classGradeFormatter},
    		{field:'courseName',align:'center',width:10,title:'课程名称'},
    		{field:'gradeTeacher',align:'center',width:10,title:'班主任',formatter:gradeTeacherFormatter},
    		{field:'courseTeacher',align:'center',width:10,title:'上课老师',formatter:courseTeacherFormatter},
    		{field:'classroomManage',align:'center',width:10,title:'教室',formatter:classroomFormatter},
    		{field:'remark',align:'center',width:10,title:'备注'},
    		{field:'state',align:'center',width:10,title:'状态',formatter:stateFormatter},
            ]
        ]


	});
	/*班级表格*/
	$("#class_datagrid").datagrid({
        url:"/classroom/payList",
        fit:true,
        singleSelect:true,
        striped:true,
        fitColumns:true,
        columns:[
            [
                {field:'name',align:'center',width:10}
			]
		],
        onDblClickRow:function(rowIndex, rowData){
            var classroomNameId= rowData.id;
            //alert(classroomNameId);
            classCourseManageItemDatagrid.datagrid("load",{
                "classroomNameId":classroomNameId

            });
           reload.on("click",function(){
               classCourseManageItemDatagrid.datagrid("reload");
           })
        }
	});

    $("#course_layout").layout({
        fit:true
    });
    $("#cc").layout({
        fit:true
    })
	//日历的高级查询
    var date2;
    $("#course_calendar").calendar({
        fit:true,

        onSelect: function(date){
            date2 = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
            //console.log(  date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate() );

        }


    })


    $("#searchBtn").linkbutton({
        text:'快查',
        iconCls:'icon-select',
        onClick:function(){
            var courseTeacherId = $(".course_courseTeacher").combobox("getValue");
            var roomId = $(".course_classroomManage").combobox("getValue");
            var classId = $(".course_classGrade").combobox("getValue");
            var beginDate = $("[name='qo.beginDate']").val();
            var endDate = $("[name='qo.endDate']").val();
            console.log(beginDate,endDate);

            classCourseManageItemDatagrid.datagrid("load",{
                "courseTeacherId":courseTeacherId,
                "roomId":roomId,
                "classId":classId,
                "beginDate":beginDate,
                "endDate":endDate,

            });
        }
    });
 


    $(".course_classGrade").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/classroom/payList"
    });
    $(".course_classroomManage").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/classRoomManage/payList"
    });
    $(".course_courseTeacher").combobox({
        valueField: 'id',
        textField: 'realname',
        url: "/employee/payList"
    });
    $("#course_gradeTeacher").combobox({
        valueField: 'id',
        textField: 'realname',
        url: "/employee/payList"
    });
 

	/*
	 * 初始化新增/编辑对话框 
	 */
	classCourseManageItemDialog.dialog({
		width:500,
		height:300,
		closed:true,
		buttons:'#classCourseManageItem_dialog_bt'
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
				classCourseManageItemForm.form("clear");
				classCourseManageItemDialog.dialog("setTitle","新增");
				classCourseManageItemDialog.dialog("open");
			},
			edit:function(){
				var rowData = classCourseManageItemDatagrid.datagrid("getSelected");
				if(rowData){
					classCourseManageItemForm.form("clear");
					classCourseManageItemDialog.dialog("setTitle","编辑");
					classCourseManageItemDialog.dialog("open");
					if(rowData.classGrade){
						rowData["classGrade.id"] = rowData.classGrade.id;
					}
					if(rowData.gradeTeacher){
						rowData["gradeTeacher.id"] = rowData.gradeTeacher.id;
					}
					if(rowData.courseTeacher){
						rowData["courseTeacher.id"] = rowData.courseTeacher.id;
					}
					if(rowData.classroomManage){
						rowData["classroomManage.id"] = rowData.classroomManage.id;
					}
					classCourseManageItemForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择需要编辑的数据!","warining");
				}
			},
			del:function(){
				var rowData = classCourseManageItemDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","您确定需要删除选中数据吗？",function(yes){
						if(yes){
							$.get("/classCourseManageItem/delete?classCourseManageItemId="+rowData.id,function(data){
								if(data.success){
									$.messager.alert("温馨提示",data.msg,"info",function(){
										classCourseManageItemDatagrid.datagrid("reload");
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
				classCourseManageItemDatagrid.datagrid("reload");
			},
			save:function(){
				var url;
				var idVal = $("[name='id']").val();
				if(idVal){
					url = "/classCourseManageItem/update"
				}else{
					url = "/classCourseManageItem/save";
				}
				classCourseManageItemForm.form("submit",{
					url:url,
					success:function(data){
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								classCourseManageItemDialog.dialog("close");
								classCourseManageItemDatagrid.datagrid("reload");
							});
						}else{
							$.messager.alert("温馨提示",data.msg,"error");
						}
					}
				});
			},
			cancel:function (){
				classCourseManageItemDialog.dialog("close");
			}
	}
});
function weekday(value,record,index){
    if(value==1){return "周一";}
    else if(value==2){return "周二 ";}
    else if(value==3){return "周三 ";}
    else if(value==4){return "周四 ";}
    else if(value==5){return "周五 ";}
    else if(value==6){return "周六 ";}
    else if(value==7){return "周日 ";}
}
function classroomFormatter(value,record,index){
    if(value){
        return value.name;
        console.log(value.name);
    }
    return value;
}
function gradeTeacherFormatter(value,record,index){
    if(value){
        return value.realname;
    }
    return value;
}
function classGradeFormatter(value,record,index){
    if(value){
        return value.name;
    }
    return value;
}
function courseTeacherFormatter(value,record,index){
    if(value){
        return value.realname;
    }
    return value;
}function stateFormatter(value,record,index){
    if(value==1){
        return " <font color='green'>正常</font>";

    }else if(value==0){
        return " <font color='red'>已完结</font>";
    }
}