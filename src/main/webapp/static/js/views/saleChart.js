$(function () {
    $("#saleChart_datagrid").datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        pagination:true,
        url:'/saleChart/list',
        fitColumns:true,
        toolbar:'#saleChart_datagrid_tb',
        columns:[
            [
                {field:'username',align:'center',width:10,formatter:employeeFormatter,title:'姓名'},
                {field:'saleDate',align:'center',width:10,title:'日期'},
                {field:'dept',align:'center',width:10,formatter:deptFormatter,title:'所属部门'},
                {field:'saleAmount',align:'center',width:10,title:'工资'},
                {field:'livesubsidy',align:'center',width:10,title:'补贴'},
                {field:'workday',align:'center',width:10,title:'工作时间'},
                {field:'totalworkday',align:'center',width:10,title:'全勤'},
                {field:'socialsecurity',align:'center',width:10,title:'社保'},
                {field:'actualsalary',align:'center',width:10,title:'实际工资'},
                {field:'remarks',align:'center',width:10,title:'备注'}
            ]
        ]
    });
    $("#saleChart_dialog").dialog({
        width:550,
        height:400,
        buttons:'#saleChart_dialog_bt',
        closed:true
    });
    $("#searchBtn").textbox({
        width:230,
        label:"关键字:",
        labelWidth:50,
        prompt:"请输入搜索关键字",
        buttonText:'搜索',
        buttonIcon:'icon-select',
        onClickButton:function(){
            var keyword = $(this).val();
            $("#saleChart_datagrid").datagrid("load",{
                keyword:keyword
            });
        }
    });
    //对按钮进行统一事件监听
    $("[data-cmd]").on("click",function(){
        var cmd = $(this).data("cmd");
        if(cmd){
            cmdObj[cmd]();
        }
    });

    //方法统一管理起来]
    var cmdObj = {
        searchDate:function () {
            var beginDate = $("#beginDate").datebox("getValue");
            var endDate = $("#endDate").datebox("getValue");
           $("#saleChart_datagrid").datagrid("load",{
               "beginDate":beginDate,
               "endDate":endDate
           })
        },
        add:function(){
            //1.清空表单数据
            $("#saleChart_form").form("clear");

            //2.设置对话框的标题
            $("#saleChart_dialog").dialog("setTitle","新增");
            //3.打开对话框
            $("#saleChart_dialog").dialog("open");
        },
        edit:function(){
            var rowData =  $("#saleChart_datagrid").datagrid("getSelected");
            if(rowData){
                //1.清空表单数据
                $("#saleChart_form").form("clear");
                //2.设置对话框的标题
                $("#saleChart_dialog").dialog("setTitle","编辑");
                //3.打开对话框
                $("#saleChart_dialog").dialog("open");
                //4.回显数据
                $("#saleChart_form").form("load",rowData);//基于同名匹配规则
            }else{
                $.messager.alert("温馨提示","请选择一条需要修改的数据.","warning");
            }

        },
        reload:function(){
            //刷新数据表格
             $("#saleChart_datagrid").datagrid("reload");
        },
        save:function(){
            var url;
            var idVal = $("[name=id]").val();
            if(idVal){
                url = "/saleChart/update";
            }else{
                url = "/saleChart/save";
            }
            $("#saleChart_form").form("submit",{
                url:url,
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            $("#saleChart_datagrid").datagrid("reload");
                            $("#saleChart_dialog").dialog("close");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        },
        cancel:function(){
            $("#saleChart_dialog").dialog("close");
        }
    }
});
function deptFormatter(value,record,index) {
    if(value){
        return value.name;
    }
    return value;
}
function employeeFormatter(value,record,index) {
    if(value){
        return value.username;
    }
    return value;
}