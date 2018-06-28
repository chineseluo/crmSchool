$(function () {
    var linkman_data = $("#linkman_data");
    var linkman_dialog = $("#linkman_dialog");
    var linkmanForm = $("#linkmanForm");
    var linkmanSchool = $("#linkman_school");
    var linkmanLinkManStatus = $("#linkman_linkManStatus");
    var linkmanSee = $("#linkman_see");
    var linkmanAdv = $("#linkman_adv");
    linkman_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/linkman/list',
        fitColumns: true,
        toolbar: "#linkman_tb",
        columns: [
            [
                {field: 'name', align: 'center', width: 10, title: '姓名'},
                {
                    field: 'school',
                    align: 'center',
                    width: 10,
                    title: '所属学校',
                    formatter: function (value, row, index) {
                        return value ? value.name : '';
                    }
                },
                {field: 'job', align: 'center', width: 10, title: '职务'},
                {field: 'phone', align: 'center', width: 10, title: '电话'},
                {field: 'qq', align: 'center', width: 10, title: 'QQ'},
                {field: 'email', align: 'center', width: 10, title: '邮箱'},
                {
                    field: 'main',
                    align: 'center',
                    width: 10,
                    title: '是否主要联系人',
                    formatter: function (value, row, index) {
                        if (value) {
                            return "是";
                        } else {
                            return "否";
                        }
                    }
                }
            ]
        ]
    });
    
    linkmanAdv.dialog({
        title: "高级查询",
        width: 300,
        height: 180,
        closed: true,
        buttons: "#linkman_bntAdv"
    });
    linkmanSchool.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=school"
    });
    $("#linkman_advSchool").combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=school"
    });
    linkmanLinkManStatus.combobox({
        valueField: 'id',
        textField: 'name',
        url: "/systemDictionaryItem/payList?sn=linkmanStatus"
    });
    linkman_dialog.dialog({
        title: "新增",
        width: 680,
        height: 250,
        closed: true,
        buttons: "#linkman_bnt"
    });
    linkmanSee.dialog({
        title: "查看",
        width: 680,
        height: 200,
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
            linkman_dialog.dialog("setTitle", "新增");
            linkmanForm.form("clear");
            $("#radioF").prop("checked", "checked");
            linkman_dialog.dialog("open");
        },
        edit: function () {
            var getRow = linkman_data.datagrid("getSelected");
            if (getRow) {
                linkman_dialog.dialog("setTitle", "编辑");
                linkmanForm.form("clear");
                if (getRow.school) {
                    getRow["school.id"] = getRow.school.id;
                }
                if (getRow.linkManStatus) {
                    getRow["linkManStatus.id"] = getRow.linkManStatus.id;
                }
                linkmanForm.form("load", getRow);
                if (getRow.main) {
                    $("#radioT").prop("checked", "checked");
                } else {
                    $("#radioF").prop("checked", "checked");
                }
                linkman_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        del: function () {
            var getRow = linkman_data.datagrid("getSelected");
            if (getRow) {
                $.messager.confirm("温馨提示", "是否删除", function (r) {
                    if (r) {
                        $.get("/linkman/delete", {"id": getRow.id}, function (data) {
                            linkman_data.datagrid("load");
                            linkman_dialog.dialog("close");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        reload: function () {
            linkman_data.datagrid("load");
        },
        save: function () {
            var id = $("[name='id']").val();
            if (id) {
                linkmanForm.form("submit", {
                    url: "/linkman/update",
                    success: function (data) {
                        data = $.parseJSON(data);
                        linkman_data.datagrid("load");
                        linkman_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            } else {
                linkmanForm.form("submit", {
                    url: "/linkman/save",
                    success: function (data) {
                        data = $.parseJSON(data);
                        linkman_data.datagrid("load");
                        linkman_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }
                });
            }
        },
        cancel: function () {
            linkman_dialog.dialog("close");
        },
        allSelect: function () {

            var getRow = linkman_data.datagrid("getSelected");
            if (getRow) {
                $("#linkman_see input:input").each(function (index, item) {
                    $(item).prop("disabled", "true");
                });
                linkmanSee.form("clear");
                if (getRow.school) {
                    getRow["school.name"] = getRow.school.name;
                }
                if (getRow.linkManStatus) {
                    getRow["linkManStatus.name"] = getRow.linkManStatus.name;
                }
                console.log(getRow.main);
                if (getRow.main) {
                    getRow.main = "是";
                } else {
                    getRow.main = "否";
                }
                if (getRow.sex == 1) {
                    getRow.sex = "男";
                }
                if (getRow.sex == 0) {
                    getRow.sex = "女";
                }
                if (getRow.sex == 2) {
                    getRow.sex = "保密";
                }
                linkmanSee.form("load", getRow);
                linkman_data.datagrid("reload");
                linkmanSee.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        advSelect: function () {
            linkmanAdv.dialog("open");
        },
        advQuery:function () {
            var keyword = $("#keyword").val();
            var school = $("#linkman_advSchool").combobox("getValue");
            var main = $("#linkman_advMain").combobox("getValue");
            linkman_data.datagrid("load",{
                "keyword":keyword,
                "school":school,
                "main":main
            })
        },
        reset:function () {
            $("#linkmanFormA").form("clear");
        },
        advCancel:function () {
            linkmanAdv.dialog("close");
        }
    }
});