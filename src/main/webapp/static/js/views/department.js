$(function () {
    //对页面中的元素进行抽取.
    //方法太凌乱,希望统一管理
    //按钮在JS统一进行监听
    var departmentDatagrid, departmentDialog, departmentForm;
    departmentDatagrid = $("#department_datagrid");
    departmentDialog = $("#department_dialog");
    departmentForm = $("#department_form");
    //渲染数据表格
    departmentDatagrid.datagrid({
        fit: true,
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        url: '/department/list',//发请求到后台请求数据
        fitColumns: true,
        toolbar: '#department_datagrid_tb',
        columns: [
            [
                {field: 'sn', align: 'center', width: 10, title: '部门编号'},
                {field: 'name', align: 'center', width: 10, title: '部门名称'}
            ]
        ]
    });
    //对话框
    departmentDialog.dialog({
        width: 250,
        height: 380,
        buttons: '#department_dialog_bt',
        closed: true
    });

    //对按钮进行统一事件监听
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });

    //方法统一管理起来]
    var cmdObj = {
        add: function () {
            //1.清空表单数据
            departmentForm.form("clear");
            //2.设置对话框的标题
            departmentDialog.dialog("setTitle", "新增");
            //3.打开对话框
            departmentDialog.dialog("open");
        },
        edit: function () {
            var rowData = departmentDatagrid.datagrid("getSelected");
            if (rowData) {
                //1.清空表单数据
                departmentForm.form("clear");
                //2.设置对话框的标题
                departmentDialog.dialog("setTitle", "新增");
                //3.打开对话框
                departmentDialog.dialog("open");
                //特殊数据的处理
                if (rowData.dept)
                    rowData["dept.id"] = rowData.dept.id;
                //4.回显数据
                departmentForm.form("load", rowData);//基于同名匹配规则
                //回显角色信息.
                //[1,3]----->List<Long>
                $.post("/role/queryRoleIdListForEmployeeForm?departmentId=" + rowData.id, function (data) {
                    $("#roleId").combobox("setValues", data);
                }), "json";

            } else {
                $.messager.alert("温馨提示", "请选择一条需要修改的数据.", "warning");
            }

        },
        reload: function () {
            //刷新数据表格
            departmentDatagrid.datagrid("reload");
        },
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/department/update";
            } else {
                url = "/department/save";
            }
            departmentForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            departmentDialog.dialog("close");
                            departmentDatagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            });
        },
        cancel: function () {
            departmentDialog.dialog("close");
        }
    }
});

function deptFormatter(value, record, index) {
    if (value) {
        return value.name;
    }
    return value;
}
