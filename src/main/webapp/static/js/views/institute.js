$(function () {
    var institute_data = $("#institute_data");
    var institute_dialog = $("#institute_dialog");
    var instituteForm = $("#instituteForm");
    institute_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/institute/list',
        fitColumns: true,
        toolbar: "#institute_tb",
        columns: [
            [
                {field: 'sn', align: 'center', width: 10, title: '编号'},
                {field: 'name', align: 'center', width: 10, title: '名称'}
            ]
        ]
    });
    institute_dialog.dialog({
        title: "新增",
        width: 250,
        height: 150,
        closed: true,
        buttons: "#institute_bnt"
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        add: function () {
            institute_dialog.dialog("setTitle", "新增");
            instituteForm.form("clear");
            institute_dialog.dialog("open");
        },
        edit: function () {
            var getRow = institute_data.datagrid("getSelected");
            if (getRow) {
                institute_dialog.dialog("setTitle", "编辑");
                instituteForm.form("clear");
                instituteForm.form("load", getRow);
                institute_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = institute_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/institute/delete", {"id": getRow.id}, function (data) {
                            institute_data.datagrid("load");
                            institute_dialog.dialog("close");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            institute_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                instituteForm.form("submit", {
                    url: "/institute/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        institute_data.datagrid("load");
                        institute_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                instituteForm.form("submit", {
                    url: "/institute/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        institute_data.datagrid("load");
                        institute_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel: function () {
            institute_dialog.dialog("close");
        }
    }
});