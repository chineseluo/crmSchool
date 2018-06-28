$(function () {
    var formalStudent_datagrid = $("#formalStudent_datagrid");
    var formalStudent_dialog = $("#formalStudent_dialog");
    var formalStudent_form = $("#formalStudent_form");

    var formalStudent_dialogView = $("#formalStudent_dialogView");
    var formalStudent_formView = $("#formalStudent_formView");

    var formalStudent_dialog_classTransfer = $("#formalStudent_dialog_classTransfer");
    var formalStudent_form_classTransfer = $("#formalStudent_form_classTransfer");

    var formalStudent_dialog_payment = $("#formalStudent_dialog_payment");
    var formalStudent_form_payment = $("#formalStudent_form_payment");

    formalStudent_datagrid.datagrid({
        url: "/potentialCustom/list?formal_studentState=1",
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        fit: true,
        fitColumns: true,
        toolbar: '#formalStudent_toolbar',
        striped: true,
        columns: [[
            {field: "name", title: "真实姓名", width: 100, align: "center"},
            {field: "marketingMan", title: "营销人员", width: 100, align: "center", formatter: marketingmanFormatter},
            {field: "totalTuition", title: "总学费", width: 100, align: "center"},
            {field: "sss", title: "待缴学费", width: 100, align: "center", formatter: dueTutionFormatter},
            {field: "defraiedTuition", title: "已付学费", width: 100, align: "center"},
            {field: "payState", title: "缴费状态", width: 100, align: "center", formatter: paystateFormatter},
            {field: "trainStartTime", title: "入学时间", width: 100, align: "center"},
            {field: "schoolOrTrainOrganization", title: "学校", width: 100, align: "center"},
            {field: "qq", title: "QQ", width: 100, align: "center"},
            {field: "telephone", title: "电话", width: 100, align: "center"},
            {field: "currentClass", title: "所在班级", width: 100, align: "center", formatter: currentclassFormatter},
            {field: "payWay", title: "付款方式", width: 100, align: "center", formatter: paywayFormatter},
            {field: "studentState", title: "状态", width: 100, align: "center", formatter: studentstateFormatter},
            {field: "inform", title: "通知", width: 100, align: "center", formatter: function (value,row,index) {
                if(value==0){
                    return "未通知";
                }else {
                    return "通知";
                }
            }}
        ]],
        onClickRow: function (rowindex, rowdata) {

        },

    });
    formalStudent_dialog.dialog({
        closable: true,
        width: 400,
        height: 350,
        buttons: '#formalStudent_dialog_buttons',
        closed: true
    });
    //查看
    formalStudent_dialogView.dialog({
        closable: true,
        width: 600,
        height: 550,
        buttons: '#formalStudent_dialog_buttonsView',
        closed: true
    });
    //转班
    formalStudent_dialog_classTransfer.dialog({
        closable: true,
        width: 600,
        height: 200,
        buttons: '#formalStudent_dialog_buttonsclassTransfe',
        closed: true
    });
    //付款
    formalStudent_dialog_payment.dialog({
        closable: true,
        width: 600,
        height: 200,
        buttons: '#formalStudent_dialog_buttons_payment',
        closed: true
    });
    var cmdObj = {
        add: function () {
            formalStudent_dialog.dialog('open');
            formalStudent_dialog.dialog("setTitle", '新增学员');
            formalStudent_form.form("clear");

        },
        cancel: function () {
            formalStudent_dialog.dialog('close');
        },
        save: function () {
            //判断是否有id,如有就更新数据
            var id = $("[name='id']").val();
            var url;

            url = "/formalStudent/update";

            formalStudent_form.form("submit", {
                url: url,
                onSubmit: function (param) {
                    /*var id = $("#currentclass_combobox").combobox("getValue");
                     param['beforeclass.id'] = id;*/
                },
                success: function (result) {
                    result = $.parseJSON(result);
                    if (result.success) {
                        $.messager.alert("温馨提示", result.msg, 'icon-smile', function () {
                            formalStudent_dialog.dialog('close');
                            formalStudent_datagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", result.msg, 'icon-warning', function () {

                        });
                    }
                }
            });
        },
        edit: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                formalStudent_dialog.dialog("open");
                formalStudent_dialog.dialog("setTitle", "学员编辑");
                formalStudent_form.form("clear");
                //编辑时,给属性传递参数
                if (record.currentclass != null) {
                    record['currentclass.id'] = record.currentclass.id;
                }
                if (record.marketingMan != null) {
                    record['marketingMan.id'] = record.marketingMan.id;
                }
                if (record.payway != null) {
                    record['payway.id'] = record.payway.id;
                }
                if (record.paystate != null) {
                    record['paystate.id'] = record.paystate.id;
                }
                if (record.studentstate != null) {
                    record['studentstate.id'] = record.studentstate.id;
                }
                if (record.inform != null) {
                    record['inform.id'] = record.inform.id;
                }
                formalStudent_form.form("load", record);

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        reload: function () {
            formalStudent_datagrid.datagrid("reload");
        },
        del: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                $.messager.confirm("温馨提示", "亲,确定要删除该信息吗?", function (yes) {
                    if (yes) {
                        $.get("/deleteByPrimaryKey?id=" + record.id, function (result) {
                            if (result.success) {
                                $.messager.alert("温馨提示", result.msg, 'info', function () {
                                    alert("删除成功");
                                    formalStudent_datagrid.datagrid("reload");
                                });
                            } else {
                                alert("删除失败");
                                $.messager.alert("温馨提示", result.msg, 'warning');
                            }
                        });
                    }
                });

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        //高级查询按钮
        formalSearch: function () {
            var keyword = $("[name='keyword']").val();
            $("#formalStudent_datagrid").datagrid("load", {
                keyword: keyword
            });
        },
        //快速查询按钮
        fastSearch: function () {
            var keyword = $("#searchClass").val();
            $("#formalStudent_datagrid").datagrid("load", {
                keyword: keyword
            });
        },
        //休学按钮
        dropOut: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                $.messager.confirm("温馨提示", "亲,确定设置该学员为休学吗?", function (yes) {
                    if (yes) {
                        $.get("/formalStudent/updateStudentStateToDropOut?id=" + record.id, function (result) {
                            if (result.success) {
                                $.messager.alert("温馨提示", result.msg, 'info', function () {
                                    formalStudent_datagrid.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", result.msg, 'warning');
                            }
                        });
                    }
                });

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        //流失按钮
        loss: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                $.messager.confirm("温馨提示", "确定该学员流失了吗?", function (yes) {
                    if (yes) {
                        $.get("/formalStudent/updateStudentStateToLoss?id=" + record.id, function (result) {
                            if (result.success) {
                                $.messager.alert("温馨提示", result.msg, 'info', function () {
                                    formalStudent_datagrid.datagrid("reload");
                                });
                            } else {
                                $.messager.alert("温馨提示", result.msg, 'warning');
                            }
                        });
                    }
                });

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        //查看按钮
        view: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                formalStudent_dialogView.dialog("open");
                formalStudent_dialogView.dialog("setTitle", "查看学员");
                formalStudent_formView.form("clear");
                //编辑时,给属性传递参数
                if (record.currentclass != null) {
                    record['currentclass.id'] = record.currentclass.id;
                }
                if (record.marketingman != null) {
                    record['marketingman.id'] = record.marketingman.id;
                }
                if (record.payway != null) {
                    record['payway.id'] = record.payway.id;
                }
                if (record.paystate != null) {
                    record['paystate.id'] = record.paystate.id;
                }
                if (record.studentstate != null) {
                    record['studentstate.id'] = record.studentstate.id;
                }
                formalStudent_formView.form("load", record);

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        cancelView: function () {
            formalStudent_dialogView.dialog('close');
        },
        //转班按钮
        classTransfer: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                formalStudent_dialog_classTransfer.dialog("open");
                formalStudent_dialog_classTransfer.dialog("setTitle", "转班");
                formalStudent_dialog_classTransfer.form("clear");
                //编辑时,给属性传递参数
                if (record.currentClass != null) {
                    record['beforeClass.id'] = record.currentClass.id;
                    record['currentClass.id'] = record.currentClass.id;
                    record["currentClass_name"] = record.currentClass.name;
                }
                formalStudent_form_classTransfer.form("load", record);

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        //转班_保存
        save_classTransfer: function () {
            //判断是否有id,如有就更新数据
            var url;

            url = "/formalStudent/updateClass";

            formalStudent_form_classTransfer.form("submit", {
                url: url,
                onSubmit: function (param) {
                },
                success: function (result) {
                    result = $.parseJSON(result);
                    if (result.success) {
                        $.messager.alert("温馨提示", result.msg, 'icon-smile', function () {
                            formalStudent_dialog_classTransfer.dialog('close');
                            formalStudent_datagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", result.msg, 'icon-warning', function () {

                        });
                    }
                }
            });
        },
        //转班_取消
        cancel_classTransfer: function () {
            formalStudent_dialog_classTransfer.dialog('close');
        },
        //付款按钮
        payment: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if (record) {
                formalStudent_dialog_payment.dialog("open");
                formalStudent_dialog_payment.dialog("setTitle", "付款");
                formalStudent_dialog_payment.form("clear");
                formalStudent_form_payment.form("load", record);

            } else {
                $.messager.alert("温馨提示", "请选择一条数据", 'icon-warning');
            }
        },
        //付款_保存
        save_payment: function () {
            //判断是否有id,如有就更新数据
            var id = $("#payment_id").val();
            var url;
            if (id) {
                url = "/formalStudent/payment";
            } else {
                url = '/formalStudent_save';
            }
            formalStudent_form_payment.form("submit", {
                url: url,
                onSubmit:function (param) {
                    param.payment = $("[name=payment]").val();

                },
                success: function (result) {
                    result = $.parseJSON(result);
                    if (result.success) {
                        $.messager.alert("温馨提示", result.msg, 'icon-smile', function () {
                            formalStudent_dialog_payment.dialog('close');
                            formalStudent_datagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", result.msg, 'icon-warning', function () {

                        });
                    }
                }
            });
        },
        //付款_取消
        cancel_payment: function () {
            formalStudent_dialog_payment.dialog('close');
        },
        //贷款
        loan: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            formalStudent_form_payment.form("submit", {
                url: "/student_updatePaywayToLoan?id=" + record.id,
                success: function (result) {
                    result = $.parseJSON(result);
                    if (result.success) {
                        $.messager.alert("温馨提示", result.msg, 'icon-smile', function () {
                            formalStudent_dialog_payment.dialog('close');
                            formalStudent_datagrid.datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", result.msg, 'icon-warning', function () {
                        });
                    }
                }
            });
        },
        //通知
        inform: function () {
            var record = formalStudent_datagrid.datagrid("getSelected");
            if(record){
                $.get("/mail/updateInformById",{"id":record.id,"email":record.email},function (data) {
                    if(data.success){
                        formalStudent_datagrid.datagrid("reload");
                        $.messager.alert("温馨提示",data.msg,"info");
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                });
            }else{
                $.messager.alert("温馨提示","请选择一行","info");
            }

        }


    };
    $("[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        cmdObj[cmd]();
    });

});
function marketingmanFormatter(value, row, index) {
    return value ? value.username : '';
}
function currentclassFormatter(value, row, index) {
    return value ? value.name : '';
}
function paywayFormatter(value, row, index) {
    return value ? value.name : '';
}
function studentstateFormatter(value, row, index) {
    if (value) {
        if (value == 1) {
            return "正式学员";
        } else if (value == 2) {

            return "升班学员";
        } else if (value == 3) {
            return "留级学员";

        } else if (value == 4) {
            return "学员流失";

        } else if (value == 5) {
            return "学员休学";
        }

    }

}


function paystateFormatter(value, row, index) {
    return value ? value.name : '';
}
function informFormatter(value, row, index) {
    return value ? value.name : '';
}
function dueTutionFormatter(value, row, index) {
    return row.totalTuition && row.defraiedTuition ? row.totalTuition - row.defraiedTuition : '';
}
