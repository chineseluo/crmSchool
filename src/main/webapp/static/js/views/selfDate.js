$(function () {
    var add = $("#addDialog");
    var edit = $("#editDialog");
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            right: 'month,agendaWeek,agendaDay',
            center: 'title'
        },
        firstDay: 1,
        editable: true,
        height:800,
        timeFormat: 'H:mm',
        axisFormat: 'H:mm',
        dayClick: function (date) {
            $("#removeDate").linkbutton("disable");
            $("#addForm").form("clear");
            date = $.fullCalendar.formatDate(date, "yyyy-MM-dd HH:mm");
            $("#start").datetimebox("setValue", date);
            add.dialog("open");
        },
        eventClick: function (event) {
            $("#removeDate").linkbutton("enable");
            $("#addForm").form("clear");
            event.start = $.fullCalendar.formatDate(event.start, "yyyy-MM-dd HH:mm");
            event.end = $.fullCalendar.formatDate(event.end, "yyyy-MM-dd HH:mm");
            $("#addForm").form("load", event);
            add.dialog("open")
        },
        events: function (start, end, callback) {
            //转化格式
            start = $.fullCalendar.formatDate(start, "yyyy-MM-dd HH:mm");
             end = $.fullCalendar.formatDate(end, "yyyy-MM-dd HH:mm");
            $.post("/selfDate/list", {"start": start, "end": end}, function (data) {
                callback(data);
            })
        }
    });
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    cmdObj = {
        save: function () {
            $("#addForm").form("submit", {
                url: "/selfDate/addEvent",
                success: function (data) {
                    data = $.parseJSON(data);
                    //重新加载数据
                    $('#calendar').fullCalendar("refetchEvents");
                    add.dialog("close");
                    $.messager.alert("温馨提示", data.msg, "info");
                }
            });
        },
        cancel: function () {
            add.dialog("close");
        },
        remove:function () {
            var id = $("input[name='id']").val();
            $.get("/selfDate/delete",{"id":id},function (data) {
                $('#calendar').fullCalendar("refetchEvents");
                add.dialog("close");
                $.messager.alert("温馨提示",data.msg,"info");
            },"json");
        }
    };
    add.dialog({
        title: "添加事件",
        width: 350,
        height: 280,
        closed: true,
        buttons: "#addBnt"
    });
});