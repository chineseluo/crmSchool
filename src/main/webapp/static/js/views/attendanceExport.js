$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var attendanceExportDatagrid, attendanceExportDialog, attendanceExportForm;
    attendanceExportDatagrid = $("#attendanceExport_datagrid");
    attendanceExportDialog = $("#attendanceExport_dialog");
    attendanceExportForm = $("#attendanceExport_form");
    /*
     * 初始化数据表格 
     */
    attendanceExportDatagrid.datagrid({
        url: "/attendanceExport/list",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        pagination: true,
        fitColumns: true,
        toolbar: '#attendanceExport_datagrid_tb'
    });
    /*
     * 初始化新增/编辑对话框 
     */
    attendanceExportDialog.dialog({
        width: 300,
        height: 300,
        closed: true,
        buttons: '#attendanceExport_dialog_bt'
    });
    /*
     * 对页面按钮进行统一监听
     */
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    /*
     * 所有的操作封装到cmdObj对象中,方便管理
     */
    var cmdObj = {
        add: function () {
            attendanceExportForm.form("clear");
            attendanceExportDialog.dialog("setTitle", "新增");
            attendanceExportDialog.dialog("open");
        },

        edit: function () {
            var rowData = attendanceExportDatagrid.datagrid("getSelected");
            if (rowData) {
                attendanceExportForm.form("clear");
                attendanceExportDialog.dialog("setTitle", "编辑");
                attendanceExportDialog.dialog("open");
                if (rowData.dept)
                    rowData["dept.id"] = rowData.dept.id;
                attendanceExportForm.form("load", rowData);
            } else {
                $.messager.alert("温馨提示", "请选择需要编辑的数据!", "warining");
            }
        },
        del: function () {
            var rowData = attendanceExportDatagrid.datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要删除选中数据吗？", function (yes) {
                    if (yes) {
                        $.get("/attendanceExport/delete?attendanceExportId=" + rowData.id, function (data) {
                            if (data.success) {
                                $.messager.alert("温馨提示", data.msg, "info", function () {
                                    attendanceExportDatagrid.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的数据!", "warining");
            }
        },
        reload: function () {
            attendanceExportDatagrid.datagrid("reload");
        },
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/attendanceExport/update"
            } else {
                url = "/attendanceExport/save";
            }
            attendanceExportForm.form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            attendanceExportDialog.dialog("close");
                            attendanceExportDatagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            });
        },
        cancel: function () {
            attendanceExportDialog.dialog("close");
        },
        download:function () {
            open("/attendanceExport/download");
        }
    }
});
