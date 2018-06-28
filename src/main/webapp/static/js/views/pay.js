$(function () {
    var pay_data = $("#pay_data");
    var pay_dialog = $("#pay_dialog");
    var payForm = $("#payForm");
    var cashier = $("#pay_cashier");
    var brokerage = $("#pay_brokerage");
    var mode = $("#pay_mode");
    var type = $("#pay_type");
    var small = $("#pay_small");
    var sharetype = $("#pay_shareType");
    var subject = $("#pay_subject");
    var advDialog = $("#advDialog");
    pay_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/pay/list',
        fitColumns: true,
        toolbar: "#pay_tb",
        columns: [
            [
                {
                    field: 'payDate',
                    align: 'center',
                    width: 10,
                    title: '支出时间',
                    formatter: function (value, row, index) {
                        return value;
                    }
                },
                {field: 'payMoney', align: 'center', width: 10, title: '支出金额'},
                {field: 'info', align: 'center', width: 10, title: '支出说明'},
                {
                    field: 'cashier',
                    align: 'center',
                    width: 10,
                    title: '出纳人',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {
                    field: 'brokerage',
                    align: 'center',
                    width: 10,
                    title: '经手人',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {
                    field: 'payMode',
                    align: 'center',
                    width: 10,
                    title: '支付方式',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {
                    field: 'payType',
                    align: 'center',
                    width: 10,
                    title: '支出类型',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {
                    field: 'paySmall',
                    align: 'center',
                    width: 10,
                    title: '支出小类',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {field: 'billNumber', align: 'center', width: 10, title: '支票号码'},
                {field: 'shareCost', align: 'center', width: 10, title: '共享费用'},
                {
                    field: 'shareType',
                    align: 'center',
                    width: 10,
                    title: '共享类型',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {
                    field: 'subject', align: 'center', width: 10, title: '学科', formatter: function (value, row, index) {
                    return value ? value.name : '';
                }
                },
                {
                    field: 'auditStatus',
                    align: 'center',
                    width: 10,
                    title: '审核状态',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "<font color='red'>未审核</font>"
                        } else {
                            return "<font color='green'>审核</font>"
                        }
                    }
                }
            ]
        ]
    });
    cashier.combobox({
        valueField: 'id',
        textField: 'username',
        url: "/employee/payList",
        onLoadSuccess: function () {
            var data = cashier.combobox("getData");
            $("#advCashierId").combobox("loadData", data);
            brokerage.combobox("loadData", data);
            $("#advBrokerageId").combobox("loadData", data);
        }
    });
    $("#advCashierId").combobox({
        valueField: 'id',
        textField: 'username'
    });
    brokerage.combobox({
        valueField: 'id',
        textField: 'username'
    });
    $("#advBrokerageId").combobox({
        valueField: 'id',
        textField: 'username'
    });
    mode.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=payMode"
    });
    type.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=payType"
    });
    small.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=paySmall"
    });
    sharetype.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=shareType"
    });
    subject.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=subject"
    });

    pay_dialog.dialog({
        title: "新增",
        width: 530,
        height: 280,
        closed: true,
        buttons: "#pay_bnt"
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    $("#advPayModeId").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=payMode"
    });
    $("#advSubjectId").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=subject"
    });
    advDialog.dialog({
        title: "查询",
        width: 530,
        height: 180,
        closed: true,
        buttons: "#adv_bnt"
    });
    cmdObj = {
        add: function () {
            pay_dialog.dialog("setTitle", "新增");
            payForm.form("clear");
            pay_dialog.dialog("open");
        },
        edit: function () {
            var getRow = pay_data.datagrid("getSelected");
            if (getRow) {
                pay_dialog.dialog("setTitle", "编辑");
                payForm.form("clear");
                if (getRow.cashier) {
                    getRow["cashier.id"] = getRow.cashier.id;
                }
                if (getRow.brokerage) {
                    getRow["brokerage.id"] = getRow.brokerage.id;
                }
                if (getRow.payMode) {
                    getRow["payMode.id"] = getRow.payMode.id;
                }
                if (getRow.payType) {
                    getRow["payType.id"] = getRow.payType.id;
                }
                if (getRow.paySmall) {
                    getRow["paySmall.id"] = getRow.paySmall.id;
                }
                if (getRow.shareType) {
                    getRow["shareType.id"] = getRow.shareType.id;
                }
                if (getRow.subject) {
                    getRow["subject.id"] = getRow.subject.id;
                }
                payForm.form("load", getRow);
                pay_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = pay_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/pay/delete", {"id": getRow.id}, function (data) {
                            pay_data.datagrid("load");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            pay_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                payForm.form("submit", {
                    url: "/pay/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        pay_data.datagrid("load");
                        pay_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                payForm.form("submit", {
                    url: "/pay/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        pay_data.datagrid("load");
                        pay_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel: function () {
            pay_dialog.dialog("close");
        },
        downloadJxl: function () {
            open("/pay/downloadJxl")
        },
        advOpen: function () {
            advDialog.dialog("open");
        },
        advSelect: function () {
            var payDate = $("#advPayDate").datebox("getValue");
            var payMoney = $("#advPayMoney").textbox("getValue");
            var cashierId = $("#advCashierId").combobox("getValue");
            var brokerageId = $("#advBrokerageId").combobox("getValue");
            var payModeId = $("#advPayModeId").combobox("getValue");
            var subjectId = $("#advSubjectId").combobox("getValue");
            pay_data.datagrid("load", {
                "payDate": payDate,
                "payMoney": payMoney,
                "cashierId": cashierId,
                "brokerageId": brokerageId,
                "payModeId": payModeId,
                "subjectId": subjectId
            });

        },
        advClear: function () {
            $("#advForm").form("clear");
        },
        advCancel: function () {
            advDialog.dialog("close");
        },
        audit: function () {
            var getRow = pay_data.datagrid("getSelected");
            if (getRow) {
                if (getRow.auditStatus == 0) {
                    $.messager.confirm("温馨提示", "是否审核", function (r) {
                        if (r) {
                            $.get("/pay/audit", {"id": getRow.id,"status":1}, function (data) {
                                pay_data.datagrid("load");
                                $.messager.alert("温馨提示", data.msg, "info");
                            }, "json")
                        }
                    });
                } else {
                    $.messager.alert("温馨提示", "已是审核状态", "info");
                }
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        cancelAudit: function () {
            var getRow = pay_data.datagrid("getSelected");
            if (getRow) {
                if (getRow.auditStatus == 1) {

                    $.messager.confirm("温馨提示", "是否取消审核", function (r) {
                        if (r) {
                            $.get("/pay/audit", {"id": getRow.id,"status":0}, function (data) {
                                pay_data.datagrid("load");
                                $.messager.alert("温馨提示", data.msg, "info");
                            }, "json")
                        }
                    });
                }else{
                    $.messager.alert("温馨提示", "还未审核状态", "info");
                }
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        }
    }
});