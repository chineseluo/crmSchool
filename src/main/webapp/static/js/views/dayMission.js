$(function () {
    var dayMission_data = $("#dayMission_data");
    var dayMission_dialog = $("#dayMission_dialog");
    var dayMission_dialogS = $("#dayMission_dialogS");
    var dayMissionFormS = $("#dayMissionFormS");
    var dayMissionForm = $("#dayMissionForm");
    dayMission_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/dayMission/list',
        fitColumns: true,
        toolbar:"#dayMission_tb",
        onSelect:function (index, row) {
            if(row.missionTime == new Date().format("yyyy-MM-dd")){
                $("#dayMission_edit").linkbutton("enable");
                $("#dayMission_del").linkbutton("enable");
            }else{
                $("#dayMission_edit").linkbutton("disable");
                $("#dayMission_del").linkbutton("disable");
            }
            if(row.missionStatus==0){
                $("#dayMission_win").linkbutton("enable");
                $("#dayMission_lose").linkbutton("enable");
            }else{
                $("#dayMission_win").linkbutton("disable");
                $("#dayMission_lose").linkbutton("disable");
            }
        },
        onDblClickRow:function (index,row) {
            dayMissionFormS.form("clear");
            dayMissionFormS.form("load", row);
            dayMission_dialogS.dialog("open");
        },

        columns: [
            [
                {field: 'missionTime', align: 'center', width: 10, title: '日期'},
                {
                    field: 'executor',
                    align: 'center',
                    width: 10,
                    title: '处理人',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {field: 'missionInfo', align: 'center', width: 10, title: '任务描述',formatter: function (value, row, index) {
                    if(value){
                        if(value.length>10){
                            return value.substring(0,10)+".....";
                        }
                        return value;
                    }else {
                        return '';
                    }
                }},
                {field: 'handlerInfo', align: 'center', width: 10, title: '处理描述',formatter: function (value, row, index) {
                    if(value){
                        if(value.length>10){
                            return value.substring(0,10)+".....";
                        }
                        return value;
                    }else {
                        return '';
                    }
                }},
                {
                    field: 'missionStatus',
                    align: 'center',
                    width: 10,
                    title: '状态',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "<font color='#1e90ff'>进行中</font>";
                        } else if (value == 1) {
                            return "<font color='green'>完成</font>";
                        } else if (value == 2) {
                            return "<font color='red'>失败</font>";
                        }
                    }
                }
            ]
        ]
    });
     $("#dayMission_executor,#adv_executor").combobox({
             valueField:'id',
             textField: 'username',
             url:"/employee/payList"
         });
    dayMission_dialog.dialog({
        title: "新增",
        width: 480,
        height: 250,
        closed: true,
        buttons: "#dayMission_bnt"
    });
    dayMission_dialogS.dialog({
        title: "查看",
        width: 480,
        height: 160,
        closed: true
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        add: function () {
            dayMission_dialog.dialog("setTitle", "新增");
            dayMissionForm.form("clear");
            dayMission_dialog.dialog("open");
        },
        edit: function () {
            var getRow = dayMission_data.datagrid("getSelected");
            if (getRow) {
                dayMission_dialog.dialog("setTitle", "编辑");
                dayMissionForm.form("clear");
                if(getRow.executor){
                    getRow["executor.id"]=getRow.executor.id;
                }
                dayMissionForm.form("load", getRow);
                dayMission_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = dayMission_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/dayMission/delete", {"id": getRow.id}, function (data) {
                            dayMission_data.datagrid("load");
                            dayMission_dialog.dialog("close");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            dayMission_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                dayMissionForm.form("submit", {
                    url: "/dayMission/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        dayMission_data.datagrid("load");
                        dayMission_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                dayMissionForm.form("submit", {
                    url: "/dayMission/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        dayMission_data.datagrid("load");
                        dayMission_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel: function () {
            dayMission_dialog.dialog("close");
        },
        win:function () {
            var getRow = dayMission_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否标示完成", function (r) {
                    if (r) {
                        $.get("/dayMission/updateStatusById", {"id": getRow.id,"missionStatus":1}, function (data) {
                            dayMission_data.datagrid("reload");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        lose:function () {
            var getRow = dayMission_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否标示失败", function (r) {
                    if (r) {
                        $.get("/dayMission/updateStatusById", {"id": getRow.id,"missionStatus":2}, function (data) {
                            dayMission_data.datagrid("reload");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        advSelect:function () {
            var missionTime = $("#adv_date").datebox("getValue");
            var executor = $("#adv_executor").textbox("getValue");
            dayMission_data.datagrid("load",{
                "missionTime":missionTime,
                "executorId":executor
            });
        }
    }
});
Date.prototype.format =function(format)
{
    var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
        (this.getFullYear()+"").substr(4- RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length==1? o[k] :
                ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}
