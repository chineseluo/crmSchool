<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>共享文件</title>
    <%@ include file="common.jsp"%>
    <script type="text/javascript" src="/static/js/views/share.js"></script>
</head>
<body>
<table id="share_data">

</table>
<div id="share_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-download" plain="true" data-cmd="download">下载</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="delete">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="refresh">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-move" plain="true" data-cmd="move">转存文件</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="select">高级查询</a>
    </div>
</div>
<div id="share_dialog">
    <ul id="share_tree"></ul>
    <div id="share_bnt">
        <a class="easyui-linkbutton" iconCls="icon-movebnt" plain="true" data-cmd="save">转存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
<div id="share_adv">
    <table align="center" style="text-align: right">
        <tr>
            <td>关键字：</td><td><input id="share_combobox"></td>
            <td>类型：</td><td><input id="share_type"></td>
        </tr>
        <tr>
            <td>时间从：</td><td><input id="share_first_time" class= "easyui-datebox" data-options="width:125"></td>
            <td>到：</td><td><input id="share_end_time" class= "easyui-datebox" data-options="width:125"></td>
        </tr>
    </table>
    <div id="share_advBnt">
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advSelect">查询</a>
        <a class="easyui-linkbutton" iconCls="icon-clear_net" plain="true" data-cmd="advClear">清空</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="advCancel">取消</a>
    </div>
</div>
</body>
</html>
