$(function () {
    var classroom_data = $("#classroom_data");
    var classroom_dialog = $("#classroom_dialog");
    var classroomForm = $("#classroomForm");
    var classroom_teacher = $("#classroom_teacher");
    var classroom_institute = $("#classroom_institute");
    classroom_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/classroom/list',
        fitColumns: true,
        toolbar: "#classroom_tb",
        columns: [
            [
                {field: 'name', align: 'center', width: 10, title: '名称'},
                {
                    field: 'classTeacher', align: 'center', width: 10, title: '班主任', formatter: function (value) {
                    return value ? value.username : '';
                }
                },
                {
                    field: 'institute', align: 'center', width: 10, title: '学院', formatter: function (value) {
                    return value ? value.name : '';
                }
                }
            ]
        ]
    });
    classroom_dialog.dialog({
        title: "新增",
        width: 250,
        height: 200,
        closed: true,
        buttons: "#classroom_bnt"
    });
    classroom_teacher.combobox({
        valueField: 'id',
        textField: 'username',
        url: "/employee/payList"
    });
    classroom_institute.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/institute/selectAll"
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        add: function () {
            classroom_dialog.dialog("setTitle", "新增");
            classroomForm.form("clear");
            classroom_dialog.dialog("open");
        },
        edit: function () {
            var getRow = classroom_data.datagrid("getSelected");
            if (getRow) {
                classroom_dialog.dialog("setTitle", "编辑");
                classroomForm.form("clear");
                if (getRow.classTeacher) {
                    getRow["classTeacher.id"] = getRow.classTeacher.id;
                }
                if (getRow.institute) {
                    getRow["institute.id"] = getRow.institute.id;
                }
                classroomForm.form("load", getRow);
                classroom_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = classroom_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/classroom/delete", {"id": getRow.id}, function (data) {
                            classroom_data.datagrid("load");
                            classroom_dialog.dialog("close");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            classroom_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                classroomForm.form("submit", {
                    url: "/classroom/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        classroom_data.datagrid("load");
                        classroom_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                classroomForm.form("submit", {
                    url: "/classroom/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        classroom_data.datagrid("load");
                        classroom_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel: function () {
            classroom_dialog.dialog("close");
        }
    }
});