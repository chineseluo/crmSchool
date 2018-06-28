$(function () {
    var potentialCustom_data = $("#potentialCustom_data");
    var potentialCustom_dialog = $("#potentialCustom_dialog");
    var bfmStu_dialog = $("#bfmStu_dialog");
    var potentialCustom_look_dialog = $("#potentialCustom_look_dialog");
    var potentialCustom_search_dialog = $("#potentialCustom_search_dialog");
    var examRegister_dialog = $("#examRegister_dialog");
    var trackstudent_dialog = $("#trackstudent_dialog");

    var potentialCustomForm = $("#potentialCustomForm");
    var potentialCustomLookForm = $("#potentialCustomLookForm");
    var bfmStu_dialog_form = $("#bfmStu_dialog_form");
    var examRegister_form = $("#examRegister_form");
    var trackstudent_form = $("#trackstudent_form");

    var marketingMan_id = $("#marketingMan_id");
    var intentionSchoolRegion_id = $("#intentionSchoolRegion_id");
    var source_id = $("#source_id");
    var education_id = $("#education_id");
    var region_id = $("#region_id");
    var workYear_id = $("#workYear_id");
    var intentionClass_id = $("#intentionClass_id");
    var intentionLevel_id = $("#intentionLevel_id");
    var currentState_id = $("#currentState_id");
    var clientType_id = $("#clientType_id");
    var intentionSubject_id = $("#intentionSubject_id");


    potentialCustom_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/potentialCustom/list?studentState=0',
        fitColumns: true,
        toolbar: "#potentialCustom_tb",
        columns: [
            [
                {
                    field: 'name',
                    align: 'center',
                    width: 10,
                    title: '学员'

                },
                {
                    field: 'marketingMan',
                    align: 'center',
                    width: 10,
                    title: '销售人员',
                    formatter: function (value, row, index) {
                        return value ? value.username : "";
                    }
                },
                {field: 'vistitTime', align: 'center', width: 10, title: '约访时间'},
                {
                    field: 'nextFollowUpTime',
                    align: 'center',
                    width: 10,
                    title: '下次跟进时间'

                },

                {
                    field: 'qq',
                    align: 'center',
                    width: 10,
                    title: 'qq号码'

                },
                {
                    field: 'telephone',
                    align: 'center',
                    width: 10,
                    title: '电话号码'
                },
                {
                    field: 'schoolOrTrainOrganization',
                    align: 'center',
                    width: 10,
                    title: '学校'

                },
                {
                    field: 'intentionLevel', align: 'center', width: 10, title: '意向程度',
                    formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {
                    field: 'intentionSchoolRegion', align: 'center', width: 10, title: '意向校区',
                    formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {
                    field: 'intentionClass', align: 'center', width: 10, title: '意向班级',
                    formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {
                    field: 'currentState', align: 'center', width: 10, title: '当前状态',
                    formatter: function (value, row, index) {
                        return value ? value.name : "";
                    }
                },
                {field: 'remark', align: 'center', width: 10, title: '备注'}

            ]
        ]
    });
    /***************************combox 的加载*****************************/
    marketingMan_id.combobox({

        valueField: 'id',
        textField: 'username',
        url: "/employee/queryEmpByRoleSn?sn=SALEMAN"
    });
    intentionSchoolRegion_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=intentionSchoolRegion"
    });
    source_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=src"
    });
    source_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=src"
    });
    education_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=educationRecord"
    });
    region_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=area"
    });
    workYear_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=workYear"
    });
    intentionClass_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/classroom/payList"
    });
    intentionLevel_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=intentionGrade"
    });
    currentState_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=currentStatu"
    });
    clientType_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=clientType"
    });
    intentionSubject_id.combobox({

        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=intentionMajor"
    });


    /***********************************dialog 的初始化和加载*****************************/
    potentialCustom_dialog.dialog({
        title: "新增",
        width: 800,
        height: 490,
        closed: true,
        buttons: "#potentialCustom_bnt"
    });
    trackstudent_dialog.dialog({
        title: "学员跟踪",
        width: 800,
        height: 490,
        closed: true,
        buttons: "#trackstudent_dialog_buttons"
    });
    potentialCustom_look_dialog.dialog({
        title: "新增",
        width: 800,
        height: 490,
        closed: true

    });
    bfmStu_dialog.dialog({
        title: "转正",
        width: 800,
        height: 490,
        closed: true,
        buttons: "#bfmStu_dialog_bt"

    });
    examRegister_dialog.dialog({
        title: "考试管理",
        width: 350,
        height: 350,
        closed: true,
        buttons: "#examRegister_dialog_bt"

    });

    potentialCustom_search_dialog.dialog({
        title: "高级查询",
        width: 800,
        height: 500,
        closed: true,
        buttons: "#potentialCustom_search_bnt"
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        add: function () {
            // 改变当前的dialog 的状态
            potentialCustom_dialog.find("input").prop("disabled", false);

            potentialCustom_dialog.dialog("setTitle", "新增");
            potentialCustomForm.form("clear");
            potentialCustom_dialog.dialog("open");
        },
        edit: function () {
            // 改变当前的dialog 的状态
            potentialCustom_dialog.find("input").prop("disabled", false);

            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                potentialCustom_dialog.dialog("setTitle", "编辑");
                potentialCustomForm.form("clear");

                if (getRow.marketingMan) {
                    getRow["marketingMan.id"] = getRow.marketingMan.id;
                }
                if (getRow.intentionSchoolRegion) {
                    getRow["intentionSchoolRegion.id"] = getRow.intentionSchoolRegion.id;
                }
                if (getRow.otherMarketingMan) {
                    getRow["otherMarketingMan.id"] = getRow.otherMarketingMan.id;
                }
                if (getRow.source) {
                    getRow["source.id"] = getRow.source.id;
                }
                if (getRow.education) {
                    getRow["education.id"] = getRow.education.id;
                }
                if (getRow.region) {
                    getRow["region.id"] = getRow.region.id;
                }
                if (getRow.workYear) {
                    getRow["workYear.id"] = getRow.workYear.id;
                }
                if (getRow.intentionClass) {
                    getRow["intentionClass.id"] = getRow.intentionClass.id;
                }
                if (getRow.intentionLevel) {
                    getRow["intentionLevel.id"] = getRow.intentionLevel.id;
                }
                if (getRow.currentState) {
                    getRow["currentState.id"] = getRow.currentState.id;
                }
                if (getRow.clientType) {
                    getRow["clientType.id"] = getRow.clientType.id;
                }
                if (getRow.schoolClient) {
                    getRow["schoolClient.id"] = getRow.schoolClient.id;
                }
                if (getRow.currentState) {
                    getRow["currentState.id"] = getRow.currentState.id;
                }
                if (getRow.intentionSubject) {
                    getRow["intentionSubject.id"] = getRow.intentionSubject.id;
                }


                potentialCustomForm.form("load", getRow);
                if (getRow.zeroPay) {
                    $("#zeroPayYes").prop("checked", "checked");

                } else {
                    $("#zeroPayYes").prop("checked", "checked");

                }
                potentialCustom_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/potentialCustom/delete", {"id": getRow.id}, function (data) {
                            potentialCustom_data.datagrid("load");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            potentialCustom_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                potentialCustomForm.form("submit", {
                    url: "/potentialCustom/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        potentialCustom_data.datagrid("load");
                        potentialCustom_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                potentialCustomForm.form("submit", {
                    url: "/potentialCustom/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        potentialCustom_data.datagrid("load");
                        potentialCustom_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        saveExamRegister: function () {


            examRegister_form.form("submit", {
                url: "/examManage/examRegister",
                onSubmit: function (param) {
                    param['student.id'] = $("#examRegister_id").val();
                    param['name'] = $("#examName_id").val();
                },
                success: function (data) {
                    data = $.parseJSON(data);

                    examRegister_dialog.dialog("close");
                    $.messager.alert("温馨提示", data.msg, "info");
                }
            });

        },
        saveFormalStudent: function () {
            var id = $("[name='id']").val();

            bfmStu_dialog_form.form("submit", {
                url: "/potentialCustom/saveFormalStudent",
                onSubmit:function (param) {
                    param['studentState'] = 1;

                },
                success: function (data) {
                    data = $.parseJSON(data);
                    potentialCustom_data.datagrid("load");
                    bfmStu_dialog.dialog("close");
                    $.messager.alert("温馨提示", data.msg, "info");
                }
            });

        }
        ,
        cancel: function () {
            potentialCustom_dialog.dialog("close");
            potentialCustom_search_dialog.dialog("close");
            bfmStu_dialog.dialog("close");
            potentialCustom_look_dialog.dialog("close");
            examRegister_dialog.dialog("close");
            trackstudent_dialog.dialog("close");

        },
        downloadJxl: function () {
            open("/potentialCustom/downloadJxl")
        },
        lookup: function () {
            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                potentialCustom_look_dialog.dialog("setTitle", "查看");


                if (getRow.marketingMan) {
                    getRow["marketingMan.name"] = getRow.marketingMan.name;
                }
                if (getRow.intentionSchoolRegion) {
                    getRow["intentionSchoolRegion.name"] = getRow.intentionSchoolRegion.name;
                }
                if (getRow.source) {
                    getRow["source.name"] = getRow.source.name;
                }
                if (getRow.education) {
                    getRow["education.name"] = getRow.education.name;
                }
                if (getRow.region) {
                    getRow["region.name"] = getRow.region.name;
                }
                if (getRow.workYear) {
                    getRow["workYear.name"] = getRow.workYear.name;
                }
                if (getRow.intentionClass) {
                    getRow["intentionClass.name"] = getRow.intentionClass.name;
                }
                if (getRow.intentionLevel) {
                    getRow["intentionLevel.name"] = getRow.intentionLevel.name;
                }
                if (getRow.currentState) {
                    getRow["currentState.name"] = getRow.currentState.name;
                }
                if (getRow.clientType) {
                    getRow["clientType.name"] = getRow.clientType.name;
                }
                if (getRow.currentState) {
                    getRow["currentState.name"] = getRow.currentState.name;
                }
                if (getRow.intentionSubject) {
                    getRow["intentionSubject.name"] = getRow.intentionSubject.name;
                }

                if (getRow.zeroPay) {
                    $("#zeroPayYes").prop("checked", "checked");

                } else {
                    $("#zeroPayYes").prop("checked", "checked");

                }

                potentialCustomLookForm.form("load", getRow);
                potentialCustom_look_dialog.find("input").prop("readonly", true);
                potentialCustom_look_dialog.find("input").prop("disabled", true);

                potentialCustom_look_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        search: function () {
            potentialCustom_search_dialog.dialog("open");
        },
        submitSearch: function () {
            //  获取查询语句中的所有的参数
            var schoolType = $("#potentialCustom_search_dialog").find("[name='schoolType']").val();
            var intentionGrade = $("#potentialCustom_search_dialog").find("[name='intentionGrade']").val();
            var workTime = $("#potentialCustom_search_dialog").find("[name='workTime']").val();
            var currentState = $("#potentialCustom_search_dialog").find("[name='currentState']").val();
            var collegeBeginTimeMin = $("#potentialCustom_search_dialog").find("[name='collegeBeginTimeMin']").val();
            var collegeBeginTimeMax = $("#potentialCustom_search_dialog").find("[name='collegeBeginTimeMax']").val();
            var intentionMajor = $("#potentialCustom_search_dialog").find("[name='intentionMajor']").val();
            var educationRecord = $("#potentialCustom_search_dialog").find("[name='educationRecord']").val();
            // 获取里面的参数
            potentialCustom_data.datagrid("load", {
                schoolType: schoolType,
                intentionGrade: intentionGrade,
                workTime: workTime,
                currentState: currentState,
                collegeBeginTimeMin: collegeBeginTimeMin,
                collegeBeginTimeMax: collegeBeginTimeMax,
                intentionMajor: intentionMajor,
                educationRecord: educationRecord
            });
            potentialCustom_search_dialog.dialog("close");

        },
        becomeFormalStudent: function () {
            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                bfmStu_dialog.dialog("setTitle", "转正");

                if (getRow.marketingMan) {
                    getRow["marketingMan.id"] = getRow.marketingMan.id;
                }
                if (getRow.intentionSchoolRegion) {
                    getRow["intentionSchoolRegion.id"] = getRow.intentionSchoolRegion.id;
                }
                if (getRow.source) {
                    getRow["source.id"] = getRow.source.id;
                }
                if (getRow.education) {
                    getRow["education.id"] = getRow.education.id;
                }
                if (getRow.region) {
                    getRow["region.id"] = getRow.region.id;
                }
                if (getRow.workYear) {
                    getRow["workYear.id"] = getRow.workYear.id;
                }
                if (getRow.intentionClass) {
                    getRow["intentionClass.id"] = getRow.intentionClass.id;
                }
                if (getRow.intentionLevel) {
                    getRow["intentionLevel.id"] = getRow.intentionLevel.id;
                }
                if (getRow.currentState) {
                    getRow["currentState.id"] = getRow.currentState.id;
                }
                if (getRow.clientType) {
                    getRow["clientType.id"] = getRow.clientType.id;
                }
                if (getRow.currentState) {
                    getRow["currentState.id"] = getRow.currentState.id;
                }
                if (getRow.intentionSubject) {
                    getRow["intentionSubject.id"] = getRow.intentionSubject.id;
                }


                bfmStu_dialog_form.form("load", getRow);

                if (getRow.zeroPay) {
                    $("#zeroPayYes").prop("checked", "checked");

                } else {
                    $("#zeroPayNot").prop("checked", "checked");

                }
                bfmStu_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }

        },
        examRegister: function () {
            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                examRegister_dialog.dialog("setTitle", "考试管理");

                if (getRow.intentionSchoolRegion) {
                    getRow["intentionSchoolRegion.id"] = getRow.intentionSchoolRegion.id;
                }
                if (getRow.intentionClass) {
                    getRow["intentionClass.id"] = getRow.intentionClass.id;
                }


                examRegister_form.form("clear");
                examRegister_form.form("load", getRow);


                examRegister_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reackStudent: function () {

            // 改变当前的dialog 的状态

            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                trackstudent_dialog.dialog("setTitle", "编辑");
                trackstudent_form.form("clear");

                if( getRow.marketingMan != null){
                    getRow["marketingMan.name"] = getRow.marketingMan.username;
                }

                    getRow['student.name']=getRow.name;
                    getRow['student.id']=getRow.id;
                    getRow['student.qq']=getRow.qq;
                    getRow['student.telephone']=getRow.telephone;

                if( getRow.currentState != null){
                    getRow['student.currentState.id']=getRow.currentState.id;
                }
                if(getRow.intentionLevel != null){
                    getRow['student.intentionLevel.id']=getRow.intentionLevel.id;
                }
                if(getRow.intentionClass != null){
                    getRow['student.intentionClass.id']=getRow.intentionClass.id;
                }

                console.log(getRow);
                trackstudent_form.form("load", getRow);

                trackstudent_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        // 学员跟踪的保存
        track_student_save: function () {

            trackstudent_form.form("submit", {
                url: "/trackStudent/save",
                onSubmit:function (param) {
                    param['student.id'] = $("#trackStudent_id").val();

                }
                ,
                success: function (data) {
                    data = $.parseJSON(data);
                    potentialCustom_data.datagrid("load");
                    trackstudent_dialog.dialog("close");
                    $.messager.alert("温馨提示", data.msg, "info");
                }
            });

        }
        ,
        sentToCustomPool:function () {
            var getRow = potentialCustom_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否放入客户池", function (r) {
                    if (r) {
                        $.get("/potentialCustom/changeStudentState", {"id": getRow.id,'studentState':-1}, function (data) {
                            potentialCustom_data.datagrid("load");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        }
    }


});