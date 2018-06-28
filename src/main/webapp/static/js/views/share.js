$(function () {
    var share_data = $("#share_data");
    var share_dialog=$("#share_dialog");
    var share_tree=$("#share_tree");
    var share_adv=$("#share_adv");
    var share_type=$("#share_type");
    var share_combobox=$("#share_combobox");
    //共享列表
    share_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/netDisc/shareList',
        fitColumns: true,
        onLoadSuccess: initIcon,
        toolbar:"#share_tb",
        columns: [
            [
                {
                    field: 'text', align: 'left', width: 10, title: '文件名称',formatter: function (value, row, index) {
                    return "<a id='" + row.id + "' data-index='" + row.type.id + "' ondblclick='db(this)'>" + value + "</a>"
                }
                },
                {
                    field: 'type', align: 'center', width: 10, title: '类型', formatter: function (value, row, index) {
                    return value.typename;
                }
                },
                {
                    field: 'size', align: 'center', width: 10, title: '容量大小', formatter: function (value, row, index) {
                    if (row.type.id == 1) {
                        return "";
                    }
                    if (value < 1024) {
                        return value + "<font color='#a52a2a'>B</font>";
                    } else if (value < 1048576) {
                        return (value / 1024).toFixed(2) + "<font color='#a52a2a'>KB</font>";
                    } else {
                        return (value / 1048576).toFixed(2) + "<font color='#a52a2a'>MB</font>";
                    }

                }
                },
                {field: 'shareTime', align: 'center', width: 10, title: '共享时间'},
                {
                    field: 'user', align: 'center', width: 10, title: '用户',formatter:function (value, row, index) {
                    return value.username;
                }}
            ]
        ]
    });
    share_type.combobox({
        value: '--请选择--',
        width: 125,
        valueField: 'id',
        textField: 'typename',
        url: "/netDisc/allType"
    });
    share_combobox.combobox({
        width: 125,
        loader: myloader,
        mode: 'remote',
        valueField: 'text',
        textField: 'text',
        loadFilter: filter,
        hasDownArrow: false
    });
    share_adv.dialog({
        title: "高级查询",
        width: 400,
        height: 150,
        closed: true,
        buttons: "#share_advBnt"
    });
    	$("a[data-cmd]").on("click",function(){
    			var cmd = $(this).data("cmd");
    			if(cmd){
    				cmdObj[cmd]();
    			}
    		});
    	cmdObj={
            move: function () {
                var checkValue = share_data.datagrid("getSelected");
                if (checkValue) {
                    share_dialog.dialog("open");
                } else {
                    $.messager.alert("温馨提示", "请选择一行", "info");
                }
            },
            download: function () {
                var select = share_data.datagrid("getSelected");
                if (select) {
                    var text = select.text;
                    var id = select.id;
                    // $.post("/netDisc/download",{"name":name,"id":id})
                    open("/netDisc/download?name=" + text + "&id=" + id)
                } else {
                    $.messager.alert("温馨提示", "请选择一行", "error");
                }
            },
            cancel: function () {
                share_dialog.dialog("close");
            },
            save: function () {
                var treeValue = share_tree.tree("getSelected");
                if (treeValue) {
                    var dialogValue = share_data.datagrid("getSelected");
                  /*  if (!treeValue.id) {
                        if (!dialogValue.parentId) {
                            $.messager.alert("温馨提示", "已在当前目录", "error");
                            return;
                        }
                    } else {
                        if (treeValue.id == dialogValue.parentId) {
                            $.messager.alert("温馨提示", "已在当前目录", "error");
                            return;
                        }
                    }
                    if (dialogValue.id == treeValue.id) {
                        $.messager.alert("温馨提示", ".........这好玩不", "error");
                        return;
                    }*/
                    $.get("/netDisc/moveSave", {"id": dialogValue.id, "pId": treeValue.id}, function (data) {
                        share_tree.tree("reload");
                        share_data.datagrid("reload");
                        share_dialog.dialog("close");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }, "json")
                } else {
                    $.messager.alert("温馨提示", "请选择目录", "info");
                }
            },
            delete: function () {
                var dialogValue = share_data.datagrid("getSelected");
                if (dialogValue) {
                    if (dialogValue.type.id == 1) {
                        $.messager.confirm("温馨提示", "是否要删除选中的文件夹,该删除会删除所有子文件", function (r) {
                            if (r) {
                                $.get("/netDisc/delete", {
                                    "id": dialogValue.id,
                                    "typeId": dialogValue.type.id,
                                    "name": dialogValue.text
                                }, function (data) {
                                    share_data.datagrid("reload");
                                    share_tree.tree("reload");
                                    $.messager.alert("温馨提示", data.msg, "info");
                                }, "json")
                            }
                        });
                        return;
                    }
                    $.messager.confirm("温馨提示", "是否要删除该文件", function (r) {
                        if (r) {
                            $.get("/netDisc/delete", {"id": dialogValue.id, "name": dialogValue.text}, function (data) {
                                share_data.datagrid("reload");
                                share_tree.tree("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            })
                        }
                    });
                } else {
                    $.messager.alert("温馨提示", "请选择一行", "info");
                }

            },
            refresh: function () {
                share_tree.tree("reload");
                share_data.datagrid("reload");
            },
            select: function () {
                share_adv.dialog("open");
            },
            advCancel: function () {
                share_adv.dialog("close");
            },
            advSelect: function () {
                var keyword = share_combobox.combobox("getValue");
                var typeId = share_type.combobox("getValue");
                var minTime = $("#share_first_time").datebox("getValue");
                var maxTime = $("#share_end_time").datebox("getValue");
                if (typeId == "--请选择--") {
                    typeId = '';
                }
                share_data.datagrid("load", {
                    "keyword": keyword,
                    "typeId": typeId,
                    "minTime": minTime,
                    "maxTime": maxTime
                })
            },
            advClear: function () {
                share_combobox.combobox("setValue");
                share_type.combobox("setValue","--请选择--");
                $("#share_first_time").datebox("setValue");
                $("#share_end_time").datebox("setValue");
            }
        };
    share_tree.tree({
        url: "/netDisc/menus",
        onLoadSuccess: function (data) {
            share_tree.tree("collapseAll");
        }
    });
    share_dialog.dialog({
        title: "转存文件",
        width: 200,
        height: 250,
        closed: true,
        buttons: "#share_bnt"
    });
});
function initIcon(data) {
    if (data) {
        var rows = data.rows;
        for (var i = 0; i < rows.length; i++) {
            var code = rows[i].id;
            var bt = $("#" + code);
            bt.linkbutton({
                plain: true,
                iconCls: rows[i].type.icon,
                iconAlign: "left"
            });
        }
        $("#pid").val(data.pid);
        if (data.pid) {
            $("#goBack").linkbutton("enable");
        } else {
            $("#goBack").linkbutton("disable");
        }
    }
}
function db(row) {
    var index = $(row).data("index");
    if (index == 1) {
        $("#share_data").datagrid("load", {"parentId": row.id})
    } else if (index == 2) {
        open("/upload/9.jpg");
    }
}
function filter(data) {
    return data
}
//有BUG单中文无法触动请求
function myloader(param, success, error) {
    var q = param.q || '';
    console.log(q.length);
    if (q.length <= 0) {
        return false
    }
    $.ajax({
        url: '/netDisc/shareKeyword',
        dataType: 'json',
        data: {
            keyword: q
        },
        success: function (data) {
            success(data);

        },
        error: function () {
            error.apply(this, arguments);
        },
        type: 'post'
    });
}