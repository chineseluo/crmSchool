$(function () {
    var first = 1;
    var selfDayMission_data = $("#selfDayMission_data");
    var selfDayMission_dialog = $("#selfDayMission_dialog");
    var msgDialog = $("#msgDialog");
    var selfDayMission_dialogS = $("#selfDayMission_dialogS");
    var selfDayMissionForm = $("#selfDayMissionForm");
    var selfDayMissionFormS = $("#selfDayMissionFormS");
    $("#main_menu").tree({
        url: '/systemMenu/indexMenu',
        onClick: function (node) {
            var mainTabs = $("#main_tabs");
            //判断当前点击的节点是否已经创建对应的面板了?
            if (mainTabs.tabs("exists", node.text)) {
                //选中选项卡
                mainTabs.tabs("select", node.text);
            } else {
                //新增选项卡
                //找到选项卡,往选项卡中添加面板
                mainTabs.tabs("add", {
                    title: node.text,
                    closable: true,
                    //href:node.attributes.url//只能加载远程页面中的body部分的内容
                    content: '<iframe src="' + node.attributes.url + '" style="width:100%;height:100%" frameborder="0"></iframe>'
                });
            }
        }
    });
    //
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        selfDayMission_edit: function () {
            var getRow = selfDayMission_data.datagrid("getSelected");
            if (getRow) {
                selfDayMissionForm.form("clear");
                selfDayMissionForm.form("load", getRow);
                selfDayMission_dialog.dialog("open");
            } else {
                $.messager.alert("温馨提示", "请选择一行", "info");
            }
        },
        selfSave: function () {
            selfDayMissionForm.form("submit", {
                url: "/dayMission/selfUpdate",
                success: function (data) {
                    data = $.parseJSON(data);
                    selfDayMission_data.datagrid("load");
                    selfDayMission_dialog.dialog("close");
                    $.messager.alert("温馨提示", data.msg, "info");
                }
            });
        },
        selfCancel: function () {
            selfDayMission_dialog.dialog("close");
        },
        advSelect: function () {
            var missionTime = $("#missionTime").datebox("getValue");
            selfDayMission_data.datagrid("load", {
                "missionTime": missionTime
            });

        }

    };
    $("#main_tabs").tabs({
        fit: true,
        pill: true
    });
    selfDayMission_dialog.dialog({
        title: "修改",
        width: 300,
        height: 250,
        closed: true,
        buttons: "#selfDayMission_bnt"
    });
    msgDialog.dialog({
        title: "消息",
        //href:'/static/im/main.html',
        width: 1100,
        height: 650,
        closed: true
    });
    selfDayMission_dialogS.dialog({
        title: "查看",
        width: 300,
        height: 160,
        closed: true
    });
    selfDayMission_data.datagrid({
        width: 350,
        height: 400,
        singleSelect: true,
        url: '/dayMission/selfList',
        fitColumns: true,
        toolbar: "#selfDayMission_tb",
        onLoadSuccess: function (data) {
            var rows = data.rows;
            if(rows.length>0){
                if(rows[0].missionTime == new Date().format("yyyy-MM-dd").toString()){
                    for (var i = 0; i < rows.length; i++) {
                        if (first == 1) {
                            if (rows[i].missionStatus == 0) {
                                $.messager.alert("温馨提示", "<font color='red'><h3>今天你还有任务没完成，请及时完成</h3></font>", "info");
                                first++;
                                return;
                            }
                        }
                    }
                }
            }
        },
        onDblClickRow: function (index, row) {
            selfDayMissionFormS.form("clear");
            selfDayMissionFormS.form("load", row);
            selfDayMission_dialogS.dialog("open");
        },
        columns: [
            [
                {field: 'missionTime', align: 'center', width: 10, title: '日期'},
                {
                    field: 'missionInfo',
                    align: 'center',
                    width: 10,
                    title: '任务描述',
                    formatter: function (value, row, index) {
                        if (value) {
                            if (value.length > 5) {
                                return value.substring(0, 5) + ".....";
                            }
                            return value;
                        } else {
                            return '';
                        }
                    }
                },
                {
                    field: 'handlerInfo',
                    align: 'center',
                    width: 10,
                    title: '处理描述',
                    formatter: function (value, row, index) {
                        if (value) {
                            if (value.length > 5) {
                                return value.substring(0, 5) + ".....";
                            }
                            return value;
                        } else {
                            return '';
                        }
                    }
                },
                {
                    field: 'missionStatus',
                    align: 'center',
                    width: 10,
                    title: '状态',
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "<font color='#1e90ff'>进行中</font>";
                        } else if (value == 1) {
                            return "<font color='green'>完成</font>";
                        } else if (value == 2) {
                            return "<font color='red'>失败</font>";
                        }
                    }
                }
            ]
        ]
    });
    $.get("/attendancesheet/sign", function (data) {
        var signList = data;
        calUtil.init(signList, '');
        $("#sign").linkbutton({
            iconCls: "icon-sign",
            plain: "true",
            onClick: function () {
                var day = new Date().getDate();
                $.get("/attendancesheet/save", function (data) {
                    if (data.success) {
                        calUtil.init(signList, {"signDay": day, "status": data.status});
                    }
                    $.messager.alert("温馨提示", data.msg, "info");
                });
            }
        });
    }, "json");

    /*******************数据爬虫********************/
    $.get("crawler/lookForUrl",function (data) {

        // 设置到div 中
        var addTemplate ;
        var ulScroll = $("#ulScroll");
        for (var i = 0 ; i < data.length ; i++) {
            // addTemplate = "<a href='javascript:openUrl("+myUrl+"); style='text-decoration: none'><font style='color: red'>"+data[i].linkText+"</font></a><br>";
            addTemplate = "<li style='list-style-type: none'><a style='text-decoration: none' href='"+data[i].linkHref+"'  target='_blank'><font style='color: red;font-size: 15px;'>"+data[i].linkText+"</font></a><br></li>"
            ulScroll.append(addTemplate)

        }

        /*/!*开启滚动*!/
        setInterval(roll,1000);
        function roll(){
            crwelerContent.append(crwelerContent.first());
            crwelerContent.fire().remove();

        }*/


    },"json");

    $("#msgButton").linkbutton({
        iconCls:'icon-preSales',
        plain:'true',
        toggle:'true',
        onClick:function () {
            if ($(this).hasClass("l-btn-plain-selected")) {
                $("#msgDialog").dialog("open");
            }else {
                $("#msgDialog").dialog("close");

            }
        }
    });



    /*菜单的快捷键*/
    $(".tabs").bind("contextmenu", function (e) {
        // 禁用掉浏览器的默认的菜单事件
        e.preventDefault();
        $('#mm').menu('show', {
            left: e.clientX -10,
            top: e.clientY -10
        });

    });

});

$(function(){
    $("#crewlerUrlList").textSlider({
        line:4,
        speed:500,
        timer:3000
    });
});


function openUrl() {
      console.log($(this).data("crtUrl"));

    // window.windowopen($(this).data("myUrl"),"top=10,left=10,width=1200,height=800");

}

function closeAllTabs() {
    var tabLength = $("#main_tabs").tabs("tabs").length;
    for (var i = 0; i < tabLength; i++) {
        $("#main_tabs").tabs("close", 0);
    }
}
function closeRightTabs() {
    var tab = $('#main_tabs').tabs('getSelected');
    var index = $('#main_tabs').tabs('getTabIndex', tab);
    var tabLength = $("#main_tabs").tabs("tabs").length;
    for (var i =  tabLength; i >index; i --) {
        $("#main_tabs").tabs("close",i);
    }
}
function closeLeftTabs() {
    var tab = $('#main_tabs').tabs('getSelected');
    var index = $('#main_tabs').tabs('getTabIndex', tab);
    for (var i = 0; i < index; i++) {
        $("#main_tabs").tabs("close", 0);
    }
}
Date.prototype.format =function(format)
{
    var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
        (this.getFullYear()+"").substr(4- RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length==1? o[k] :
                ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}

$(function(){
    $("#crewlerUrlList").textSlider({line:1,speed:1000,timer:1000});
});