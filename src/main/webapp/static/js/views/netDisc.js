$(function () {
    $("#music_block").hide();
    $("#video_block").hide();
    var net_data = $("#net_data");
    var net_dialog = $("#net_dialog");
    var net_tree = $("#net_tree");
    var net_adv = $("#net_adv");
    var net_combobox = $("#net_combobox");
    var net_type = $("#net_type");
    var lay_tree = $("#layout_tree");
    var lay_tabs = $("#layout_tabs");
    var net_music = $("#net_music");
    var net_video = $("#net_video");
    var net_img = $("#net_img");
    //网盘列表
    net_data.datagrid({
        fit: true,
        singleSelect: true,
        rownumbers: true,
        pagination: true,
        url: '/netDisc/list',
        fitColumns: true,
        onLoadSuccess: initIcon,
        toolbar: "#net_tb",
        columns: [
            [
                {
                    field: 'text', align: 'left', width: 10, title: '文件名称', formatter: function (value, row, index) {
                    return "<a id='" + row.id + "' data-index='" + row.type.id + "' data-name='" + value + "' ondblclick='db(this)'>" + value + "</a>"
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
                {field: 'uploadTime', align: 'center', width: 10, title: '创建时间'},
                {
                    field: 'share', align: 'center', width: 10, title: '共享状态', formatter: function (value, row, index) {
                    if (row.type.id == 1) {
                        return "";
                    }
                    if (value == 0) {
                        return "无";
                    } else {
                        return "<font color='red'>共享中</font><a href='javascript:void(0)'  class='net_share' data-clipboard-text='" + basePath + "/netDisc/shareLink?uId=" + row.user.id + "&id=" + row.id + "'>链接</a>"
                    }
                }
                }
            ]
        ]
    });
    net_type.combobox({
        value: '--请选择--',
        valueField: 'id',
        textField: 'typename',
        url: "/netDisc/allType"
    });
    net_combobox.combobox({
        loader: myloader,
        mode: 'remote',
        valueField: 'text',
        textField: 'text',
        loadFilter: filter,
        hasDownArrow: false
    });
    net_adv.dialog({
        title: "高级查询",
        width: 500,
        height: 180,
        closed: true,
        buttons: "#net_advBnt"
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        upload: function () {
            $("#downfile").trigger("click");
        },
        download: function () {
            var select = net_data.datagrid("getSelected");
            if (select) {
                var text = select.text;
                var id = select.id;
                // $.post("/netDisc/download",{"name":name,"id":id})
                open("/netDisc/download?name=" + text + "&id=" + id)
            } else {
                $.messager.alert("温馨提示", "请选择一行", "error");
            }
        },
        goBack: function () {
            var pid = $("#pid").val();
            $.get("/netDisc/getParentId", {"id": pid}, function (data) {
                net_data.datagrid("load", {"parentId": data});
            });
        },
        move: function () {
            var checkValue = net_data.datagrid("getSelected");
            if (checkValue) {
                net_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        cancel: function () {
            net_dialog.dialog("close");
        },
        save: function () {
            var treeValue = net_tree.tree("getSelected");
            if (treeValue) {
                var dialogValue = net_data.datagrid("getSelected");
                if (!treeValue.id) {
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
                }
                $.get("/netDisc/move", {"id": dialogValue.id, "pId": treeValue.id}, function (data) {
                    net_tree.tree("reload");
                    net_data.datagrid("reload");
                    net_dialog.dialog("close");
                    $.messager.alert("温馨提示", data.msg, "info");
                }, "json")
            } else {
                $.messager.alert("温馨提示", "请选择目录", "info");
            }
        },
        addFolder: function () {
            $.messager.prompt("温馨提示", "请输入文件夹名称", function (r) {
                if (r.length <= 0) {
                    $.messager.alert("温馨提示", "名称不能为空", "error");
                    return;
                }

                var pid = $("#pid").val();
                $.post("/netDisc/addFolder", {"pId": pid, "name": r}, function (data) {
                    net_tree.tree("reload");
                    net_data.datagrid("reload");
                    $.messager.alert("温馨提示", data.msg, "info");
                }, "json")
            });
        },
        share: function () {
            var checkValue = net_data.datagrid("getSelected");
            if (checkValue) {
                if (checkValue.type.id == 1) {
                    $.messager.alert("温馨提示", "暂时不支持文件夹共享", "info");
                    return;
                }
                if (checkValue.share == 1) {
                    $.messager.confirm("温馨提示", "已是共享状态,是否要取消共享", function (r) {
                        if (r) {
                            $.get("/netDisc/share", {"id": checkValue.id, "share": 0}, function (data) {
                                net_data.datagrid("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            }, "json")
                        }

                    });
                    return;
                }
                $.messager.confirm("温馨提示", "是否要共享", function (r) {
                    if (r) {
                        $.get("/netDisc/share", {"id": checkValue.id, "share": 1}, function (data) {
                            net_data.datagrid("reload");
                            $.messager.alert("温馨提示", data.msg, "info");
                        }, "json")
                    }
                }, "json");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        delete: function () {
            var dialogValue = net_data.datagrid("getSelected");
            if (dialogValue) {
                if (dialogValue.type.id == 1) {
                    $.messager.confirm("温馨提示", "是否要删除选中的文件夹,该删除会删除所有子文件", function (r) {
                        if (r) {
                            $.get("/netDisc/delete", {
                                "id": dialogValue.id,
                                "typeId": dialogValue.type.id,
                                "name": dialogValue.text
                            }, function (data) {
                                net_data.datagrid("reload");
                                net_tree.tree("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            }, "json")
                        }
                    });
                    return;
                }
                $.messager.confirm("温馨提示", "是否要删除该文件", function (r) {
                    if (r) {
                        $.get("/netDisc/delete", {"id": dialogValue.id, "name": dialogValue.text}, function (data) {
                            net_data.datagrid("reload");
                            net_tree.tree("reload");
                            $.messager.alert("温馨提示", data.msg, "info");
                        })
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }

        },
        rename: function () {
            var dialogValue = net_data.datagrid("getSelected");
            if (dialogValue) {
                $.messager.prompt("温馨提示", "请输入新的文件名", function (r) {
                    if (r.length <= 0) {
                        $.messager.alert("温馨提示", "名称不能为空", "error");
                        return;
                    }
                    $.post("/netDisc/rename", {"id": dialogValue.id, "name": r}, function (data) {
                        net_data.datagrid("reload");
                        net_tree.tree("reload");
                        $.messager.alert("温馨提示", data.msg, "info");
                    }, "json")
                });
            } else {
                $.messager.alert("温馨提示", "请选择一个文件", "info");
            }
        },
        refresh: function () {
            net_tree.tree("reload");
            net_data.datagrid("reload");
        },
        select: function () {
            net_adv.dialog("open");
        },
        advCancel: function () {
            net_adv.dialog("close");
        },
        advSelect: function () {
            var keyword = net_combobox.combobox("getValue");
            var typeId = net_type.combobox("getValue");
            var shareStatus = $("#net_combobox_share").combobox("getValue");
            var minTime = $("#net_first_time").datebox("getValue");
            var maxTime = $("#net_end_time").datebox("getValue");
            var advStatus = 1;
            if (shareStatus == "--请选择--" && typeId == "--请选择--" && !keyword && !minTime && !maxTime) {
                advStatus = '';
            }
            if (shareStatus == "--请选择--") {
                shareStatus = -1;
            }
            if (typeId == "--请选择--") {
                typeId = '';
            }
            net_data.datagrid("load", {
                "keyword": keyword,
                "typeId": typeId,
                "shareStatus": shareStatus,
                "minTime": minTime,
                "maxTime": maxTime,
                "advStatus": advStatus
            })
        },
        advClear: function () {
            net_combobox.combobox("setValue");
            net_type.combobox("setValue", "--请选择--");
            $("#net_combobox_share").combobox("setValue", "--请选择--");
            $("#net_first_time").datebox("setValue");
            $("#net_end_time").datebox("setValue");
        },
        allShare: function () {
            //判断当前点击的节点是否已经创建对应的面板了?
            if (lay_tabs.tabs("exists", "共享文件")) {
                //选中选项卡
                lay_tabs.tabs("select", "共享文件");
            } else {
                //新增选项卡
                lay_tabs.tabs("add", {
                    title: "共享文件",
                    closable: true,
                    //href:node.attributes.url//只能加载远程页面中的body部分的内容
                    content: '<iframe src="/netDisc/shareDisc" style="width:100%;height:100%" frameborder="0"></iframe>'
                });
            }
        },
        myDate: function () {
            //判断当前点击的节点是否已经创建对应的面板了?
            if (lay_tabs.tabs("exists", "个人日历")) {
                //选中选项卡
                lay_tabs.tabs("select", "个人日历");
            } else {
                //新增选项卡
                lay_tabs.tabs("add", {
                    title: "个人日历",
                    closable: true,
                    //href:node.attributes.url//只能加载远程页面中的body部分的内容
                    content: '<iframe src="/selfDate" style="width:100%;height:100%" frameborder="0"></iframe>'
                });
            }
        },
        block: function () {
            net_music.dialog("open");
        },
        videoBlock: function () {
            net_video.dialog("open");
            document.getElementById("video").play()
        },
        email:function () {
            $("#email").dialog("open");
        },
        emailClear:function () {
            $("#emailForm").form("clear");
        },
        emailCancel:function () {
            $("#email").dialog("close");
        },
        emailSend:function () {
            $("#emailForm").form("submit",{
                url:"/mail/send",
                success:function (data) {
                    var data = $.parseJSON(data);
                    $.messager.alert("温馨提示",data.msg,"info");
                }
            })
        }
    };
    //文件目录
    net_tree.tree({
        url: "/netDisc/menus",
        onLoadSuccess: function (node, data) {
            net_tree.tree("collapseAll");
            var treeDate = jQuery.extend(true, {}, data);
            var a = new Array(treeDate["0"]);
            lay_tree.tree("loadData", a);
        }
    });
    net_dialog.dialog({
        title: "移动文件",
        width: 200,
        height: 250,
        closed: true,
        buttons: "#net_bnt"
    });
    lay_tree.tree({
        onLoadSuccess: function (node, data) {
            lay_tree.tree("collapseAll");
        },
        onClick: function (node) {
            lay_tabs.tabs("select", "我的网盘");
            $.get("/netDisc/list", {"parentId": node.id}, function (data) {
                net_data.datagrid("loadData", data);
            }, "json");
        }
    });
    lay_tabs.tabs({
        fit: true,
        tabHeight: 20,
        pill: true
    });
    //复制事件
    var clipboard = new Clipboard('.net_share');
    clipboard.on('success', function () {
        alert("复制成功");
    });
    //music
    net_music.dialog({
        title: "music",
        width: 350,
        height: 150,
        closed: true,
        onClose: function () {
            document.getElementById("music").pause();
            $("#music_block").hide();
        },
        minimizable: true,
        onMinimize: function () {
            $("#music_block").show();
        }
    });
    net_video.dialog({
        title: "video",
        closed: true,
        minimizable: true,
        onClose: function () {
            document.getElementById("video").pause();
            $("#video_block").hide();
        },
        onMinimize: function () {
            document.getElementById("video").pause();
            $("#video_block").show();
        }
    });
    net_img.dialog({
        title: "pic",
        width: 500,
        top:100,
        closed: true,
        maximizable: true
    });
    $("#email").dialog({
        title: "邮件管理",
        width: 450,
        height: 220,
        closed: true,
        buttons: "#emailBnt"
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
    var name = $(row).data("name");
    if (index != 1) {
        var suffix = name.substring(name.lastIndexOf("."));
    }
    if (index == 1) {
        $("#net_data").datagrid("load", {"parentId": row.id})
    } else if (index == 2) {
        $("#img").prop("src", "upload/" + row.id + suffix);
        $("#net_img").dialog("setTitle", name);
        $("#net_img").dialog("restore");
        $("#net_img").dialog("open");
    } else if (index == 6) {
        $("#music_block").hide();
        $("#net_span").html(name);
        $("#music").prop("src", "upload/" + row.id + suffix);
        $("#net_music").dialog("open");
    } else if (index == 7) {
        $("#video_block").hide();
        $("#net_video").dialog("setTitle", name);
        $("#video").prop("src", "upload/" + row.id + suffix);
        $("#net_video").dialog("open");
    }
}
function downSub() {
    $("#fileForm").form("submit", {
        url: "/netDisc/upload",
        success: function (data) {
            var value = $("#pid").val();
            $("#net_data").datagrid("reload", {"parentId": value})
            var json = $.parseJSON(data);
            $.messager.alert("温馨提示", json.msg, "info");
        }
    });
}
function copy(aLink) {
    var url = $(aLink).data("url");
    console.log(url);
}
function filter(data) {
    return data
}
//有BUG单中文无法触动请求
function myloader(param, success, error) {
    var q = param.q || '';
    if (q.length <= 0) {
        return false
    }
    $.ajax({
        url: '/netDisc/keyword',
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
