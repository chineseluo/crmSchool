<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>相关联系人</title>
    <%@ include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/linkman.js"></script>
</head>
<body>
<table id="linkman_data"></table>
<div id="linkman_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-newAdd" plain="true" data-cmd="add">新增</a>
        <a class="easyui-linkbutton" iconCls="icon-blueEdit" plain="true" data-cmd="edit">編輯</a>
        <a class="easyui-linkbutton" iconCls="icon-delete" plain="true" data-cmd="del">刪除</a>
        <a class="easyui-linkbutton" iconCls="icon-see" plain="true" data-cmd="allSelect">查看全部</a>
        <a class="easyui-linkbutton" iconCls="icon-refreshNet" plain="true" data-cmd="reload">刷新</a>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advSelect">高级查询</a>
    </div>
</div>
<div id="linkman_dialog">
    <form id="linkmanForm" method="post">
        <input type="hidden" class="easyui-textbox" name="id">
        <table align="center" style="text-align: right">
            <tr>
                <td>姓名:</td>
                <td><input name="name" class="easyui-textbox"></td>
                <td>学校:</td>
                <td><input name="school.id" id="linkman_school" class="easyui-combobox"></td>
                <td>称呼:</td>
                <td><input name="call" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="phone" class="easyui-textbox"></td>
                <td>QQ:</td>
                <td><input name="qq" class="easyui-textbox"></td>
                <td>Email:</td>
                <td><input name="email" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>主要联系人:</td>
                <td align="left"><input id="radioT" type="radio" name="main" value="1">是<input id="radioF" type="radio"
                                                                                               name="main" value="0">否
                </td>
                <td>状态:</td>
                <td><input name="linkManStatus.id" id="linkman_linkManStatus" class="easyui-combobox"></td>
                <td>院系:</td>
                <td><input name="institute" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td><input name="department" class="easyui-textbox"></td>
                <td>性别:</td>
                <td><input name="sex" class="easyui-combobox" data-options="
                                                valueField: 'label',
                                                textField: 'value',
                                                data: [{
                                                    label: '1',
                                                    value: '男'
                                                },{
                                                    label: '0',
                                                    value: '女'
                                                },{
                                                    label: '2',
                                                    value: '保密'
                                                }]"/>
                </td>
                <td>生日:</td>
                <td><input name="birthday" class="easyui-datebox"></td>
            </tr>
            <tr>
                <td>职务:</td>
                <td><input name="job" class="easyui-textbox"></td>
                <td>地址:</td>
                <td><input name="address" class="easyui-textbox"></td>
            </tr>
        </table>
    </form>
</div>
<div id="linkman_bnt">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-blueSave" plain="true" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="cancel">取消</a>
    </div>
</div>
<div id="linkman_bntAdv">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-select" plain="true" data-cmd="advQuery">查询</a>
        <a class="easyui-linkbutton" iconCls="icon-reset" plain="true" data-cmd="reset">重置</a>
        <a class="easyui-linkbutton" iconCls="icon-cnaclebnt" plain="true" data-cmd="advCancel">取消</a>
    </div>
</div>
<div id="linkman_adv">
    <form id="linkmanFormA">
        <table align="center" style="text-align: right">
            <tr>
                <td>姓名:</td>
                <td><input id="keyword" class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>学校:</td>
                <td><input id="linkman_advSchool" class="easyui-combobox"></td>
            </tr>
            <tr>
                <td>主要联系人:</td>
                <td><input id="linkman_advMain" class="easyui-combobox" data-options="
                                                valueField: 'label',
                                                textField: 'value',
                                                data: [{
                                                    label: '1',
                                                    value: '是'
                                                },{
                                                    label: '0',
                                                    value: '否'
                                                }]"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="linkman_see">
    <form id="linkmanFormS" method="post">
        <table align="center" style="text-align: right">
            <tr>
                <td>姓名:</td>
                <td><input name="name" type="text"></td>
                <td>学校:</td>
                <td><input name="school.name" type="text"></td>
                <td>称呼:</td>
                <td><input name="call" type="text"></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input name="phone" type="text"></td>
                <td>QQ:</td>
                <td><input name="qq" type="text"></td>
                <td>Email:</td>
                <td><input name="email" type="text"></td>
            </tr>
            <tr>
                <td>主要联系人:</td>
                <td align="left"><input name="main" type="text">
                </td>
                <td>状态:</td>
                <td><input name="linkManStatus.name" type="text"></td>
                <td>院系:</td>
                <td><input name="institute" type="text"></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td><input name="department" type="text"></td>
                <td>性别:</td>
                <td><input name="sex" type="text">
                </td>
                <td>生日:</td>
                <td><input name="birthday" type="text"></td>
            </tr>
            <tr>
                <td>职务:</td>
                <td><input name="job" type="text"></td>
                <td>地址:</td>
                <td><input name="address" type="text"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
