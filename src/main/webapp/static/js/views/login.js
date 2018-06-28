
$(function () {
    $("#loginBtn").on("click",function () {
        $("#loginForm").form("submit",{
            url:"/login",
            success:function (data) {
                var data  = $.parseJSON(data);
                if (data.success) {
                    window.location.href="/main";
                }else {
                    $.messager.alert("温馨提示",data.msg);

                }
            }
        });
    });
});