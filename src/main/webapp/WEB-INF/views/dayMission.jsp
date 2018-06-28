<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>当日任务</title>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/dayMission.js"></script>
</head>
<body>
<table id="dayMission_data"></table>
<div id="dayMission_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit" id="dayMission_edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del" id="dayMission_del">刪除</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-success" plain="true" data-cmd="win" id="dayMission_win">标志完成</a>
        <a class="easyui-linkbutton" iconCls="icon-fail" plain="true" data-cmd="lose" id="dayMission_lose">标志失败</a>
    </div>
    <div>
        日期:<input id="adv_date" type= "text" class= "easyui-datebox">
        处理人:<input id="adv_executor" type= "text" class= "easyui-combobox">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-select',plain:'true'" data-cmd="advSelect">查询</a>
    </div>
</div>
<div id="dayMission_dialog">
    <form id="dayMissionForm" method="post">
        <input type="hidden" name="id">
        <table align="center" style="text-align: right">
            <tr>
                <td>日期:</td>
                <td><input name="missionTime" type= "text" class= "easyui-datebox"></td>
                <td>处理人:</td>
                <td><input name="executor.id" id="dayMission_executor" type="text" class="easyui-combobox"></td>
            </tr>
            <tr>
                <td>任务描述:</td>
                <td colspan="3"><input name="missionInfo" type= "text" class= "easyui-textbox" multiline="true" style="width: 375px"></td>
            </tr>
            <tr>
                <td>处理描述:</td>
                <td colspan="3"><input name="handlerInfo" type= "text" class= "easyui-textbox" multiline="true" style="width: 375px"></td>
            </tr>
        </table>
    </form>
</div>
<div id="dayMission_dialogS">
    <form id="dayMissionFormS" method="post">
        <table align="center" style="text-align: right">
            <tr>
                <td>任务描述:</td>
                <td><input name="missionInfo" disabled="true" type= "text" class= "easyui-textbox" multiline="true" style="width: 355px"></td>
            </tr>
            <tr>
                <td>处理描述:</td>
                <td><input name="handlerInfo" disabled="true" type= "text" class= "easyui-textbox" multiline="true" style="width: 355px"></td>
            </tr>
        </table>
    </form>
</div>
<div id="dayMission_bnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
</body>
</html>
