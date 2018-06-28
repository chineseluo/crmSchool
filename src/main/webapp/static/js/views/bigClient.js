$(function () {
    var bigClient_data = $("#bigClient_data");
    var bigClient_dialog = $("#bigClient_dialog");
    var bigClientForm = $("#bigClientForm");
    var train_dialog = $("#train_dialog");
    var train_data = $("#train_data");
    var train_editDialog = $("#train_editDialog");
    var trainForm = $("#trainForm");
    var bigClient_dialogS = $("#bigClient_dialogS");
    var bigClient_advDialog=$("#bigClient_advDialog");
    bigClient_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/bigClient/list',
        fitColumns: true,
        toolbar: "#bigClient_tb",
        columns: [
            [
                {field: 'school', align: 'center', width: 10, title: '学校'},
                {field: 'address', align: 'center', width: 10, title: '地址'},
                {field: 'schoolType', align: 'center', width: 10, title: '类型'},
                {field: 'department', align: 'center', width: 10, title: '部门'},
                {
                    field: 'marketing',
                    align: 'center',
                    width: 10,
                    title: '营销人员',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {
                    field: 'follow',
                    align: 'center',
                    width: 10,
                    title: '跟进人员',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {
                    field: 'linkman',
                    align: 'center',
                    width: 10,
                    title: '联系人',
                    formatter: function (value, row, index) {
                        return value ? $.map(value, function (item) {
                            return item.name;
                        }) : "";
                    }
                },
                {
                    field: 'trains',
                    align: 'center',
                    width: 10,
                    title: '实训次数',
                    formatter: function (value, row, index) {
                        return value.length > 0 ? value.length : '无';
                    }
                },
                {field: 'signNumber', align: 'center', width: 10, title: '签约次数'},
                {
                    field: 'cooperationSchool',
                    align: 'center',
                    width: 10,
                    title: '合作高校',
                    formatter: function (value, row, index) {
                        if (value) {
                            return "是";
                        } else {
                            return "否";
                        }
                    }
                },
                {field: 'hotspotLevel', align: 'center', width: 10, title: '客户价值'},
                {
                    field: 'starLevel',
                    align: 'center',
                    width: 10,
                    title: '星级',
                    formatter: function (value, row, index) {
                        return "<font color='red'>" + value + "</font>";
                    }
                }
            ]
        ]
    });
    $("#bigClient_marketing").combobox({
        valueField: 'id',
        textField: 'username',
        url: "/employee/payList",
        onLoadSuccess:function () {
            var data = $("#bigClient_marketing").combobox("getData");
            $("#bigClient_follow").combobox("loadData",data);
            $("#bigClient_advMarketing").combobox("loadData",data);
            var mm=$("#mm");
            for (var i = 0; i < data.length; i++) {
                var dataId=data[i].id;
                mm.menu("appendItem",{
                    text: data[i].username,
                    id:dataId,
                    iconCls: 'icon-person',
                    onclick: function(){
                        var id=this.id;
                        var getRow = bigClient_data.datagrid("getSelected");
                        if (getRow) {
                            $.messager.confirm("温馨提示","是否要移交",function (r) {
                                if(r){
                                   $.get("/bigClient/updateFollowById",{"fId":id,"id":getRow.id},function (msg) {
                                       bigClient_data.datagrid("reload");
                                       $.messager.alert("温馨提示",msg.msg,"info");
                                   })
                                }
                                return;
                            });
                        }else {
                            $.messager.alert("温馨提示","请选择一行","info");
                        }
                    }
                })
            }
        }
    });
    $("#bigClient_school,#bigClient_advSchool").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=school"
    });
    $("#bigClient_follow").combobox({
        valueField: 'id',
        textField: 'username'
    });
    $("#bigClient_advMarketing").combobox({
        valueField: 'id',
        textField: 'username'
    });
    $("#bigClient_schoolType,#bigClient_advSchoolType").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=schoolType"
    });
    $("#bigClient_education").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=education"
    });
    $("#bigClient_region").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=region"
    });
    $("#bigClient_schoolProperties").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=schoolProperties"
    });
    $("#bigClient_eductionalsystme").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=eductionalsystme"
    });
    $("#bigClient_hotspotLevel").combobox({
        valueField: 'name',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=hotspotLevel"
    });

    bigClient_dialog.dialog({
        title: "新增",
        width: 760,
        height: 400,
        closed: true,
        buttons: "#bigClient_bnt"
    });
    bigClient_dialogS.dialog({
        title: "查看",
        width: 760,
        height: 410,
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
            bigClient_dialog.dialog("setTitle", "新增");
            bigClientForm.form("clear");
            bigClient_dialog.dialog("open");
        },
        edit: function () {
            var getRow = bigClient_data.datagrid("getSelected");
            if (getRow) {
                bigClient_dialog.dialog("setTitle", "编辑");
                bigClientForm.form("clear");
                if (getRow.marketing) {
                    getRow["marketing.id"] = getRow.marketing.id;
                }
                if (getRow.follow) {
                    getRow["follow.id"] = getRow.follow.id;
                }
                bigClientForm.form("load", getRow);
                if (getRow.cooperationSchool) {
                    $("#radioT").prop("checked", "checked");
                } else {
                    $("#radioF").prop("checked", "checked");
                }
                bigClient_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = bigClient_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/bigClient/delete", {"id": getRow.id}, function (data) {
                            bigClient_data.datagrid("load");
                            bigClient_dialog.dialog("close");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            bigClient_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                bigClientForm.form("submit", {
                    url: "/bigClient/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        bigClient_data.datagrid("load");
                        bigClient_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                bigClientForm.form("submit", {
                    url: "/bigClient/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        bigClient_data.datagrid("load");
                        bigClient_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel: function () {
            bigClient_dialog.dialog("close");
        },
        train: function () {
            var getRow = bigClient_data.datagrid("getSelected");
            if (getRow) {
                var options = train_data.datagrid("options");
                options.url = "/train/list?bigClientId=" + getRow.id;
                train_data.datagrid("load");
                train_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        trainAdd: function () {
            train_editDialog.dialog("setTitle", "新增");
            trainForm.form("clear");
            train_editDialog.dialog("open");
        },
        trainEdit: function () {
            var getRow = train_data.datagrid("getSelected");
            if (getRow) {
                train_editDialog.dialog("setTitle", "编辑");
                trainForm.form("clear");
                trainForm.form("load", getRow);
                train_editDialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        trainDel: function () {
            var getRow = train_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/train/delete", {"id": getRow.id}, function (data) {
                            train_data.datagrid("load");
                            train_editDialog.dialog("close");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        trainReload: function () {
            train_data.datagrid("load");
        },
        trainSave: function () {
            var id = $("#trainId").val();
            if (id) {
                trainForm.form("submit", {
                    url: "/train/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        train_data.datagrid("load");
                        train_editDialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                var getRow = bigClient_data.datagrid("getSelected");
                trainForm.form("submit", {
                    url: "/train/save",
                    onSubmit: function (value) {
                        value.bigClientId = getRow.id;
                    },
                    success: function (data) {
                        data = $.parseJSON(data);
                        train_data.datagrid("load");
                        train_editDialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        trainCancel: function () {
            train_editDialog.dialog("close");
        },
        allSelect: function () {
            var getRow = bigClient_data.datagrid("getSelected");
            if (getRow) {
                $("#bigClientFormS").form("clear");
                if (getRow.marketing) {
                    getRow["marketing.username"] = getRow.marketing.username;
                }
                if (getRow.follow) {
                    getRow["follow.username"] = getRow.follow.username;
                }
                $("#bigClientFormS").form("load", getRow);
                if (getRow.cooperationSchool) {
                    $("#radioTS").prop("checked", "checked");
                } else {
                    $("#radioFS").prop("checked", "checked");
                }
                $("#bigClientFormS :input").prop("disabled",true);
                bigClient_dialogS.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        advSelect:function () {
            bigClient_advDialog.dialog("open");
        },
        advSave:function () {
            var school = $("#bigClient_advSchool").combobox("getValue");
            var marketing = $("#bigClient_advMarketing").combobox("getValue");
            var schoolType = $("#bigClient_advSchoolType").combobox("getValue");
            var starLevel = $("#advStarLevel").combobox("getValue");
            bigClient_data.datagrid("load",{
               "school":school,
                "marketing":marketing,
                "schoolType":schoolType,
                "starLevel":starLevel
            });
        },
        advCancel:function () {
            bigClient_advDialog.dialog("close");
        },
        advReload:function () {
            $("#advForm").form("clear");
        }
    };
    bigClient_advDialog.dialog({
            title:"高级查询",
            width: 530,
            height: 150,
            closed: true,
            buttons:"#bigClient_advBnt"
        });
    //======================================train
    train_editDialog.dialog({
        title: "新增",
        width: 530,
        height: 280,
        closed: true,
        buttons: "#train_bnt"
    });
    train_dialog.dialog({
        title: "实训",
        width: 600,
        height: 400,
        closed: true,
        onClose: function () {
            bigClient_data.datagrid("reload");
        }
    });
    train_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        fitColumns: true,
        toolbar: "#train_tb",
        columns: [
            [
                {field: 'trainDate', align: 'center', width: 10, title: '实训时间'},
                {field: 'trainInfo', align: 'center', width: 10, title: '实训内容'},
                {field: 'trainAddress', align: 'center', width: 10, title: '实训地点'},
                {field: 'trainResult', align: 'center', width: 10, title: '实训效果'},
                {field: 'remark', align: 'center', width: 10, title: '备注'}
            ]
        ]
    });
});
function transfer(id) {
    alert(id);
}