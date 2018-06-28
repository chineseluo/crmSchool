<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台首页</title>
    <%@include file="common.jsp" %>
    <link rel="stylesheet" type="text/css" href="/static/css/sign2.css">
    <script type="text/javascript" src="/static/js/roll/jQuery.textSlider.js"></script>
    <script type="text/javascript" src="/static/js/views/main.js"></script>
    <script type="text/javascript" src="/static/js/calendar2.js"></script>
</head>
<body>
    <div class="easyui-layout" fit="true">
        <div data-options="region:'north'" style="height:80px ">
            <div style="float: left;">
                <img src="/static/images/title.png" alt="" width="700" height="60">

        </div>
        <div style="float: right;margin-right: 15px;">
            <span style="padding-top: 100px"><iframe width="320" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5&site=12"></iframe></span>
            <div style="float: right;margin-top: 20px"><a href="/logout" style="text-decoration: none" ><img src="/static/js/jquery-easyui/themes/icons/exit.png"> </a></div>
            <div style="float:right;margin-top: 28px"><font style="font-weight:bold;"><shiro:principal property="realname"></shiro:principal>,您好！</font></div>
        </div>
    </div>
    <div data-options="region:'west',title:'菜单'" style="width:200px;">
        <!-- 菜单树 -->
        <ul id="main_menu"></ul>
    </div>
    <div data-options="region:'center',border:false">
        <div id="main_tabs">
            <div title="欢迎页" closable="true">
                <div class="easyui-layout" fit="true">
                    <div data-options="region:'west',border:0" style="width:400px;text-align: center">
                        <h3>当日任务</h3>
                        <table id="selfDayMission_data"></table>
                        <div id="selfDayMission_tb">
                            <div>
                                <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true"
                                   data-cmd="selfDayMission_edit">修改任务</a>
                                日期:<input id="missionTime" name="missionTime" type="text" class="easyui-datebox"><a
                                    plain="true" data-cmd="advSelect" class="easyui-linkbutton"
                                    data-options="iconCls:'icon-select'">查询</a>
                            </div>
                        </div>
                        <div id="selfDayMission_dialog">
                            <form id="selfDayMissionForm" method="post">
                                <input type="hidden" name="id">
                                <table align="center" style="text-align: right">
                                    <tr>
                                        <td>任务描述:</td>
                                        <td>
                                            <input name="missionInfo" type="text" class="easyui-textbox"
                                                   multiline="true"
                                                   readonly="readonly" style="width: 200px">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>处理描述:</td>
                                        <td>
                                            <input name="handlerInfo" type="text" class="easyui-textbox"
                                                   multiline="true"
                                                   style="width: 200px">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>状态:</td>
                                        <td style="text-align: left">
                                            <input name="missionStatus" class="easyui-combobox" data-options="
                                                valueField: 'label',
                                                textField: 'value',
                                                data: [
                                                {
                                                    label: '0',
                                                    value: '进行中'
                                                },
                                                {
                                                    label: '1',
                                                    value: '成功'
                                                },{
                                                    label: '2',
                                                    value: '失败'
                                                }]">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div id="selfDayMission_dialogS">
                            <form id="selfDayMissionFormS" method="post">
                                <input type="hidden" name="id">
                                <table align="center" style="text-align: right">
                                    <tr>
                                        <td>任务描述:</td>
                                        <td>
                                            <input name="missionInfo" type="text" class="easyui-textbox"
                                                   multiline="true"
                                                   disabled="true" style="width: 200px">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>处理描述:</td>
                                        <td>
                                            <input name="handlerInfo" type="text" class="easyui-textbox"
                                                   multiline="true"
                                                   disabled="true" style="width: 200px">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div id="selfDayMission_bnt">
                            <div>
                                <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="selfSave">保存</a>
                                <a class="easyui-linkbutton" iconCls="icon-cancelAudit" plain="true"
                                   data-cmd="selfCancel">取消</a>
                            </div>
                        </div>
                    </div>
                    <div data-options="region:'center'">
                        <div id="calendar"></div>

                            <div>
                                <%--<center>--%>
                                    <%--<fieldset style="border-color:darkgrey">--%>
                                        <%--<legend><font style="font-size: 20px;color:#0052A3">实时网络动态</font></legend>--%>
                                            <%--<div id="crewlerUrlList">--%>
                                                <%--<div class="scrollText">--%>
                                                    <%--<ul id="ulScroll">--%>

                                                    <%--</ul>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                    <%--</fieldset>--%>
                                <%--</center>--%>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div data-options="region:'south'" style="height:30px;">
            <div style="float:left;margin-left: 45%">
                <center>版权信息</center>
            </div>
            <%--<div style="float: right">--%>
                <%--<a id="msgButton">消息</a>--%>
            <%--</div>--%>
        </div>
    </div>


    <div id="msgDialog">
         <iframe src="/static/im/main.html" style="width: 100%;height: 100%" frameborder="0">
       </iframe>

    </div>


    <%--菜单的按钮--%>
    <div id="mm" class="easyui-menu" style="width:130px;">
        <div data-options="iconCls:'icon-refreshNet'" >刷新页面</div>
        <div data-options="iconCls:'icon-alldelete'" onclick="closeAllTabs()">关闭所有</div>
        <div data-options="iconCls:'icon-leftdelete'" onclick="closeLeftTabs()">关闭左边</div>
        <div data-options="iconCls:'icon-rightdelete'" onclick="closeRightTabs()">关闭右边</div>
    </div>
</body>
</html>