$(function () {
    var charge_data = $("#charge_data");
    var charge_dialog = $("#charge_dialog");
    var chargeForm = $("#chargeForm");
    var chargeStudent = $("#charge_student");
    var chargeClassroom = $("#charge_classroom");
    var chargePayee = $("#charge_payee");
    var chargeType = $("#charge_type");
    var chargeSubject = $("#charge_subject");
    var chargeMarketing = $("#charge_marketing");
    charge_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/charge/list',
        fitColumns: true,
        toolbar: "#charge_tb",
        columns: [
            [
                {
                    field: 'student',
                    align: 'center',
                    width: 10,
                    title: '学员',
                    formatter: function (value, row, index) {
                        return value?value.name:'';
                    }
                },
                {field: 'chargeDate', align: 'center', width: 10, title: '收费时间'},
                {field: 'chargeMoney', align: 'center', width: 10, title: '收费金额'},
                {
                    field: 'classroom',
                    align: 'center',
                    width: 10,
                    title: '班级',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {
                    field: 'payee',
                    align: 'center',
                    width: 10,
                    title: '收款人',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {
                    field: 'chargeType',
                    align: 'center',
                    width: 10,
                    title: '收款方式',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {field: 'billNumber', align: 'center', width: 10, title: '收据单号'},
                {field: 'ticket', align: 'center', width: 10, title: '是否开票',formatter: function (value, row, index) {
                    if(value){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
                {
                    field: 'subject',
                    align: 'center',
                    width: 10,
                    title: '学科',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {field: 'remark', align: 'center', width: 10, title: '支票号码'},
                {
                    field: 'marketing',
                    align: 'center',
                    width: 10,
                    title: '营销人',
                    formatter: function (value, row, index) {
                        return value ? value.username : '';
                    }
                },
                {field: 'classChange', align: 'center', width: 10, title: '班级变动'}
            ]
        ]
    });

    chargeStudent.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/potentialCustom/selectAll",
        onLoadSuccess:function () {
            var data = chargeStudent.combobox("getData");
            $("#studentId").combobox("loadData",data);
        }
    });
    $("#studentId").combobox({
             valueField:'id',
             textField: 'name'
         });
    chargeClassroom.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/classroom/selectAll",
        onLoadSuccess:function () {
            var data = chargeClassroom.combobox("getData");
            $("#classroomId").combobox("loadData",data);
        }
    });
    $("#classroomId").combobox({
        valueField:'id',
        textField: 'name'
    });
    chargePayee.combobox({
        valueField: 'id',
        textField: 'username',
        url: "/employee/payList",
        onLoadSuccess:function () {
            var data = chargePayee.combobox("getData");
            $("#payeeId").combobox("loadData",data);
        }
    });
    $("#payeeId").combobox({
        valueField:'id',
        textField: 'username'
    });
    chargeType.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=payMode"
    });
    chargeSubject.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=subject",
        onLoadSuccess:function () {
            var data = chargeSubject.combobox("getData");
            $("#subjectId").combobox("loadData",data);
        }
    });
    $("#subjectId").combobox({
        valueField:'id',
        textField: 'name'
    });
    chargeMarketing.combobox({
        valueField: 'id',
        textField: 'username',
        url: "/employee/payList"
    });
    charge_dialog.dialog({
        title: "新增",
        width: 550,
        height: 280,
        closed: true,
        buttons: "#charge_bnt"
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        add: function () {
            charge_dialog.dialog("setTitle", "新增");
            chargeForm.form("clear");
            charge_dialog.dialog("open");
        },
        edit: function () {
            var getRow = charge_data.datagrid("getSelected");
            if (getRow) {
                charge_dialog.dialog("setTitle", "编辑");
                chargeForm.form("clear");
                if (getRow.student) {
                    getRow["student.id"] = getRow.student.id;
                }
                if (getRow.classroom) {
                    getRow["classroom.id"] = getRow.classroom.id;
                }
                if (getRow.payee) {
                    getRow["payee.id"] = getRow.payee.id;
                }
                if (getRow.chargeType) {
                    getRow["chargeType.id"] = getRow.chargeType.id;
                }
                if (getRow.subject) {
                    getRow["subject.id"] = getRow.subject.id;
                }
                if (getRow.marketing) {
                    getRow["marketing.id"] = getRow.marketing.id;
                }
                chargeForm.form("load", getRow);
                if(getRow.ticket){
                    $("#ticket").switchbutton("check");
                }
                charge_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = charge_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/charge/delete", {"id": getRow.id}, function (data) {
                            charge_data.datagrid("load");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            charge_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                chargeForm.form("submit", {
                    url: "/charge/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        charge_data.datagrid("load");
                        charge_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                chargeForm.form("submit", {
                    url: "/charge/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        charge_data.datagrid("load");
                        charge_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel:function () {
            charge_dialog.dialog("close");
        },
        advSelect: function () {
            var studentId = $("#studentId").datebox("getValue");
            var chargeDate = $("#chargeDate").datebox("getValue");
            var chargeMoney = $("#chargeMoney").textbox("getValue");
            var classroomId = $("#classroomId").combobox("getValue");
            var payeeId = $("#payeeId").combobox("getValue");
            var subjectId = $("#subjectId").combobox("getValue");
            charge_data.datagrid("load", {
                "studentId": studentId,
                "chargeDate": chargeDate,
                "chargeMoney": chargeMoney,
                "classroomId": classroomId,
                "payeeId": payeeId,
                "subjectId": subjectId
            });

        },
        advClear: function () {
            $("#advForm").form("clear");
        },
        advCancel: function () {
            advDialog.dialog("close");
        },
        advOpen:function () {
            advDialog.dialog("open");
        },
        download:function () {
            open("/charge/download");
        }
    }

    var advDialog=$("#advDialog");
       advDialog.dialog({
               title:"高级查询",
               width: 550,
               height: 180,
               closed: true,
               buttons:"#adv_bnt"
           });
});