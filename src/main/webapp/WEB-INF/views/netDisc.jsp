<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>个人网盘</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path;
    %>
    <script type="text/javascript">
        var basePath = '<%=basePath%>';
    </script>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/clipboard.min.js"></script>
    <script type="text/javascript" src="/static/js/views/netDisc.js"></script>
</head>
<body class="easyui-layout" style="border: none">
<div data-options="region:'west',title:'网盘管理'" style="width:150px;border: none">
    <div>
        <ul id="layout_tree"></ul>
    </div>
    <div><a class="easyui-linkbutton" iconCls="icon-share" plain="true" data-cmd="allShare">共享文件</a></div>
    <div><a class="easyui-linkbutton" iconCls="icon-date" plain="true" data-cmd="myDate">日程安排</a></div>
    <div><a class="easyui-linkbutton" iconCls="icon-email" plain="true" data-cmd="email">邮箱管理</a></div>
</div>
<div data-options="region:'center'" style="background:#eee;">
    <div id="layout_tabs">
        <div title="我的网盘">
            <table id="net_data"></table>
        </div>
    </div>
</div>
<div id="net_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-upload" plain="true" data-cmd="upload">上传</a>
        <a class="easyui-linkbutton" iconCls="icon-download" plain="true" data-cmd="download">下载</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="delete">删除</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="refresh">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-rename" plain="true" data-cmd="rename">重命名</a>
        <a class="easyui-linkbutton" iconCls="icon-addfolder" plain="true" data-cmd="addFolder">新建文件夹</a>
        <a class="easyui-linkbutton" iconCls="icon-move" plain="true" data-cmd="move">移动文件</a>
        <a id="goBack" class="easyui-linkbutton" iconCls="icon-return" plain="true" data-cmd="goBack">返回上一层</a>
        <a class="easyui-linkbutton" iconCls="icon-share" plain="true" data-cmd="share">共享文件</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="select">高级查询</a>
        <a id="music_block" class="easyui-linkbutton" iconCls="icon-music" plain="true" data-cmd="block">音乐</a>
        <a id="video_block" class="easyui-linkbutton" iconCls="icon-video" plain="true" data-cmd="videoBlock">视频</a>
    </div>
</div>
<form id="fileForm" method="post" enctype="multipart/form-data">
    <input id="pid" type="hidden" name="parentId">
    <input name="file" type="file"
           style="display: none;" id="downfile" onchange="downSub()">
</form>
<div id="net_dialog">
    <ul id="net_tree"></ul>
    <div id="net_bnt">
        <a class="easyui-linkbutton" iconCls="icon-movebnt" plain="true" data-cmd="save">移动</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
<div id="net_adv">
    <table align="center" style="text-align: right">
        <tr>
            <td>关键字：</td><td><input id="net_combobox"></td>
            <td>共享状态：</td><td><input id="net_combobox_share" class="easyui-combobox" data-options="
                                                    value:'--请选择--',
                                                    valueField:'label',
                                                    textField: 'value',
                                                    data: [{
                                                        label: '0',
                                                        value: '无'
                                                    },{
                                                        label: '1',
                                                        value: '共享中'
                                                    }]"/>

            </td>
        </tr>
        <tr>
            <td>时间从：</td><td><input id="net_first_time" class="easyui-datebox"></td>
            <td>到：</td><td><input id="net_end_time" class="easyui-datebox" ></td>
        </tr>
        <tr>
            <td>类型：</td><td><input id="net_type"></td>
        </tr>
    </table>
    <div id="net_advBnt">
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advSelect">查询</a>
        <a class="easyui-linkbutton" iconCls="icon-clear_net" plain="true" data-cmd="advClear">清空</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="advCancel">取消</a>
    </div>
</div>
<div id="net_music">
    <div style="padding-top: 40px" align="center"><span id="net_span"></span><br/>
        <audio id="music" controls="controls" autoplay="autoplay"></audio>
    </div>
</div>
<div id="net_video" align="center">
    <div>
        <video id="video" width="320" height="240" controls="controls"></video>
    </div>
</div>
<div id="net_img">
    <div>
        <img id="img" width="100%"/>
    </div>
</div>
<div id="email">
    <form id="emailForm" method="post">
        <table align="center">
            <tr>
                <td>
                    员工:
                </td>
                <td>
                    <input name="employee" class="easyui-combobox" data-options="
                            valueField: 'email',
                            textField: 'username',
                            multiple:true,
                            url:'/employee/payList',
                           ">
                </td>
                <td>
                    学员:
                </td>
                <td>
                    <input name="potential" class="easyui-combobox" data-options="
                            valueField:'email',
                            textField:'name',
                            multiple:true,
                            url:'/potentialCustom/selectAll',
                          ">
                </td>
            </tr>
            <tr>
                <td>
                    标题:
                </td>
                <td>
                    <input name="title" class="easyui-textbox" required="required" >
                </td>
            </tr>
            <tr>
                <td>
                    内空:
                </td>
                <td colspan="3">
                    <input name="contents" class="easyui-textbox" multiline="true" style="width: 328px" required="required">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="emailBnt">
    <a class="easyui-linkbutton" iconCls="icon-send" plain="true" data-cmd="emailSend">发送</a>
    <a class="easyui-linkbutton" iconCls="icon-clear_net" plain="true" data-cmd="emailClear">清空</a>
    <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="emailCancel">取消</a>
</div>
</body>
</html>
